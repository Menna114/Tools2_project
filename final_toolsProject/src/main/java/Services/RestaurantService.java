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
import javax.ws.rs.core.MediaType;
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON) 
@Path("/RestaurantServices")

public class RestaurantService {
	
	@PersistenceContext
	private EntityManager entityManager;
	@POST
	@Path("createMenu")
	
	public List<Meal> createRestaurantMenu(Restaurant rest)
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
		return resturant.getMeals();
	
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
