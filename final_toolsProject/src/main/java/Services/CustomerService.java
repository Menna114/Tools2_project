package Services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.Order;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import task.Meal;
import task.OrderDetails;
import task.OrderStatus;
import task.Orders;
import task.Restaurant;
import task.Runner;
import task.RunnerStatus;




@Stateless
@Path("CustomerService")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CustomerService {
  
	@PersistenceContext
	private EntityManager entityManager;
	
	@Path("createOrder")
    @POST
    public Orders createOrder(Orders order)
    {
    	TypedQuery<Runner>query=entityManager.createQuery("SELECT runners FROM Runner runners",Runner.class);
    	List<Runner>r=query.getResultList();
    	double totalPrice=0;
    	OrderDetails ord=new OrderDetails(order);
    	for(int i=0;i<r.size();i++)
    	{
    		if(r.get(i).getStatus().equals(RunnerStatus.AVAILABLE))
    		{
    			 ord.setRunnerName(r.get(i).getName());
    			 r.get(i).setStatus(RunnerStatus.BUSY);
    			 entityManager.merge(r);
    			 break;
    		}
    	}
    	for(int i=0;i<ord.getItemslist().size();i++)
    	{
    		Meal[]items=(Meal[])ord.getItemslist().toArray();
    		totalPrice=totalPrice+ items[i].getPrice();
    	}
    	double Total=totalPrice+ord.getDeliveryFees();
    	ord.setTotalReceipt(Total);
    	entityManager.persist(order);
    	
    	return order;
    }
	
	@Path("getAllRestaurants")
    @GET
    public List<Restaurant>getAllRestaurants()
	{
		TypedQuery<Restaurant>query=entityManager.createQuery("SELECT rest FROM Restaurant rest",Restaurant.class);
		List<Restaurant>rest=query.getResultList();
		return rest;
	
	}

	@Path("EditOrder")
	@PUT
	public void editOrder(Orders order)
	{

		TypedQuery<Orders>query=entityManager.createQuery("SELECT items FROM Orders items WHERE items.id=:id",Orders.class);
		query.setParameter("id", order.getId());
		List<Orders> details=query.getResultList();
		
			if(!(details.isEmpty()) && details.get(0).getStatus().equals(OrderStatus.PREPARING))
			{
				details.get(0).setMeals(order.getMeals());
				entityManager.merge(details.get(0));
			}
		
	}
	
}
