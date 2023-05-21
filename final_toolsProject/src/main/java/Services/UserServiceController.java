package Services;

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

import task.User;

@Stateless
@Path("UserService")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserServiceController {
	@PersistenceContext
	private EntityManager entityManager;
	
	public UserServiceController()
	{
		
	}
	@Path("AddNewUser")
	@POST
	
	public String addNewUser(User user)
	{
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
}
