package Services;

import java.util.List;
import java.util.Set;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import task.Meal;
import task.Restaurant;
import task.User;

import javax.ws.rs.core.MediaType;
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON) 
@Path("/RestaurantServices")

public class RestaurantOwnerService {
	
	@PersistenceContext
	private EntityManager entityManager;
	private UserServiceController usc;
    /*@POST
    @Path("createMenu")
    public String createrestaurantMenu(Restaurant rest)
    {
        for(int i=0;i<usc.u.size();i++)
        {
           if(usc.u.get(i).getRole().equalsIgnoreCase("Owner"))
           {
               Long id = usc.u.get(i).getId();
               rest.setId(id);
           }
        }
        entityManager.persist(rest);
        return "Restaurant created";
    }*/
	@POST
	@Path("createMenu")
	public String createRestaurantAndMeals(Restaurant restaurant) {
		TypedQuery<User> query = entityManager.createQuery("SELECT users FROM User users where users.id =:id",
				User.class);

		query.setParameter("id", restaurant.getUser().getId());

		TypedQuery<Meal> query2 = entityManager.createQuery("SELECT meals FROM Meal meals", Meal.class);
		List<Meal> restMenu = query2.getResultList();
		User u = query.getSingleResult();

		if (u != null) {
			if (u.getRole().equalsIgnoreCase("owner")) {
				for (int i = 0; i < restaurant.getMeals().size(); i++) {
					Meal m = restaurant.getMeals().get(i);
					Meal m2 = new Meal(m.getPrice(), m.getName());
					m2.setRestaurantMeals(restaurant);
					entityManager.persist(m2);
					// if (!restMenu.contains(restaurant.getMeals().get(i))) {

					// } else
					// entityManager.merge(m2);
				}
				return "success";
				// return "hey";
				// }
				// how can we solve transaction rolled back problem?

				// u.setOwnerId(restaurant);
				// restaurant.setUser(u);
				// entityManager.merge(u);
				// entityManager.persist(restaurant);
				// } else
				// throw new NullPointerException("user is not an owner");
				// } else
				// throw new NullPointerException("no such user");
				// return "restaurant added";
			}
		}
		return "no";

	}

	public void getRestaurantMenu(Restaurant rest)
	{
		TypedQuery<Restaurant>query= entityManager.createQuery("SELECT restaurant FROM Restaurant restaurant where restaurant.id=?1",Restaurant.class);
		query.setParameter(1,rest.getId());
		Restaurant resturant=query.getSingleResult();
		for(int i=0;i<rest.getMeals().size();i++)
		{
			if(entityManager.contains(rest.getMeals().get(i)))
				continue;
			else
				entityManager.persist(rest.getMeals().get(i));	
		}
		resturant.setMeals(rest.getMeals());
		entityManager.merge(resturant);
		
	
	}
	@POST
	@Path("editMenu")
	public List<Meal> editRestaurantMenu(Restaurant rest)
	{
		TypedQuery<Restaurant>query= entityManager.createQuery("SELECT restaurant FROM Restaurant restaurant where restaurant.id=?1",Restaurant.class);
		query.setParameter(1,rest.getId());
		Restaurant resturant=query.getSingleResult();
		
		List<Meal>menuMeals=resturant.getMeals();
		
		for(Meal meal:menuMeals)
		{
			entityManager.remove(meal);
		}
		
		return menuMeals;
	}
	
	
	
	//public Restaurant editRestMenu 

}