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
import javax.ws.rs.PathParam;
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
	public String Signup(User user)
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
		entityManager.persist(user);
		return "Name signed up";
	}
	
	
    @Path("Login/{name}/{password}")
    @GET
    public String login(@PathParam("name")String name,@PathParam("password") String password)
    {

    	   TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u WHERE u.name = :name", User.class);
    	   query.setParameter("name", name);
    	   List<User> users = query.getResultList();

    	   if (users.size() == 1) 
    	 {
    	      User user = users.get(0);
    	      if (user.getPassword().equals(password)) 
    	       {
    	         return "login successfully";
               }
    	      
         }

    	   return "login failed";
    }
    
    
    
    
    @Path("getusers")
    @GET
	public List<User>getAllUsers()
	{
		TypedQuery<User>query=entityManager.createQuery("SELECT users FROM User users",User.class);
		List<User>users=query.getResultList();
		return users;
		
	}
}
