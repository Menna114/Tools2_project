package Services;
import task.OrderStatus;
import task.Orders;
import task.Runner;
import task.RunnerStatus;

import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.persistence.EntityManager;

@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON) 
@Path("/runnerService")

public class RunnerService {
	@PersistenceContext
	private EntityManager entitymanger;
	@POST
	@Path("markOrder")
	public void markOrder(int id)
	
	{
		TypedQuery<Orders>query=entitymanger.createQuery("SELECT order FROM Orders order WHERE order.id =?1",Orders.class);
		query.setParameter(1,id);
		Orders o=query.getSingleResult();
		if(o==null)
		{
			throw new NullPointerException("Error, please try again later");
		}
		o.setStatus(OrderStatus.DELIVERED);
		Runner runner=o.getRunner();
		runner.setStatus(RunnerStatus.AVAILABLE);
		entitymanger.merge(runner);
		entitymanger.merge(o);
		
	}
	@GET
	@Path("getNumOfTrips")
	public int getTotalNumberOfTrips(int id)
	{
		TypedQuery<Runner>query=entitymanger.createQuery("SELECT runner FROM Runner runner WHERE runner.id =?1",Runner.class);
		query.setParameter(1,id);
		Runner runner=query.getSingleResult();
		if(runner != null) 
		{
			
			return runner.getOrders().size();
			//Orders[] order= runner.getOrders().toArray();	
		}
		else
			throw new NullPointerException("Error");

	}

}
