package Services;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import task.Meal;
import task.OrderDetails;
import task.Orders;
import task.Runner;
import task.RunnerStatus;
import task.User;

@Stateless
@Path("UserService")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserServiceController {
	@PersistenceContext
	private EntityManager entityManager;
	List<User>u =new ArrayList<>();
	
	public UserServiceController()
	{
		
	}
	
	@Path("AddNewUser/{deliveryFees}")
	@POST
	//@PermitAll
	public String Signup(User user,@PathParam("deliveryFees")double deliveryFees)
	{
		TypedQuery<User>query=entityManager.createQuery("SELECT user FROM User user",User.class);
		List<User>u=query.getResultList();
		if(u.size()>0)
		{
			for(int i=0;i<u.size();i++) 
			{
				if(u.get(i).getName().equals(user.getName())&& u.get(i).getRole().equals(user.getRole()))
				{
					return "User exists";	
				}
			}
		}
		if(user.getRole().equalsIgnoreCase("Runner"))
        {
            Runner r=new Runner();
            r.setName(user.getName());
            r.setDeliveryFees(deliveryFees);
            r.setStatus(RunnerStatus.AVAILABLE);
            entityManager.persist(r);
        }
		entityManager.persist(user);
		return "Name signed up";
	}
	
	
	
	@Path("Login")
	@GET
	//@PermitAll
	public String login(User user) {

		TypedQuery<User> query = entityManager
				.createQuery("SELECT u FROM User u WHERE u.name = :name and u.password =:password", User.class);
		query.setParameter("name", user.getName());
		query.setParameter("password", user.getPassword());
		List<User> u = query.getResultList();

		if (!u.isEmpty()) {
			return "login successfully";

		}

		return "login failed";
	}
    
    @Path("getusers")
    @GET
    //@PermitAll
	public List<User>getAllUsers()
	{
		TypedQuery<User>query=entityManager.createQuery("SELECT users FROM User users",User.class);
		List<User>users=query.getResultList();
		return users;
	}
    
    
    
}