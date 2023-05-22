package Services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import task.Runner;
import task.User;

@Stateless
@Path("UserService")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserServiceController {
	@PersistenceContext
	private EntityManager entityManager;
	List<User> u = new ArrayList <>();
	public UserServiceController()
	{
		
	}
<<<<<<< Updated upstream
	@Path("AddNewUser")
	@POST
	
	public String addNewUser(User user)
	{
=======
	
	@Path("AddNewUser/{deliveryFees}")
	@POST
	public String Signup(User user,@PathParam("deliveryFees")double deliveryFees)
	{
		TypedQuery<User>query=entityManager.createQuery("SELECT user FROM User user",User.class);
		u=query.getResultList();
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
	        entityManager.persist(r);
		}
>>>>>>> Stashed changes
		entityManager.persist(user);
		return("Signed in successfully");
	}
	
    @Path("GetUsers")
    @GET
	public List<User>getAllUsers()
	{
		TypedQuery<User>query=entityManager.createQuery("SELECT users FROM User users",User.class);
		List<User>users=query.getResultList();
		return users;
		
	}
    
    @Path("getanything")
    @GET
	public String anything() 
	{
	 return "accessed";
	}
}
