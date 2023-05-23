package Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
	
	@POST
	@Path("createMenu")
	public String createRestaurant(Restaurant restaurant) 
	{

		entityManager.persist(restaurant);
		return "rest created";

	}
	
	@GET
	@Path("getList")
	public List<Restaurant>listofRes()
	{
		TypedQuery<Restaurant>query=entityManager.createQuery("SELECT r FROM Restaurant r",Restaurant.class);
     	List<Restaurant> r=query.getResultList();
     	return r;
	}
	
	@POST
	@Path("getMenu/{restaurantId}")
	public String createMeal(@PathParam("restaurantId") long restaurantId,List<Meal>meals) {
        // Find the restaurant with the given id
        Restaurant restaurant = entityManager.find(Restaurant.class, restaurantId);
        return "hey";
        
//        List<Meal> m = new ArrayList<>();
//        for (Meal mealRequest : meals) {
//            Meal meal = new Meal();
//            meal.setName(mealRequest.getName());
//            meal.setPrice(mealRequest.getPrice());
//            meal.setRestaurantMeals(restaurant);
//            m.add(meal);
//        }
//        restaurant.getMealsList().addAll(m);
//        entityManager.persist(m);
//        entityManager.merge(restaurant);
//		return "done";
    }

	
	@GET
	@Path("restaurantDetails")
	public Restaurant getRestaurantDetails(int id)
	{
		TypedQuery<Restaurant>query= entityManager.createQuery("SELECT rest FROM Restaurant rest WHERE rest.id:id",Restaurant.class);
		query.setParameter("id", id);
		Restaurant restaurant =query.getSingleResult();
		return restaurant;
	}
	

	
	@Path("EditMenu/{restID}")
    @PUT
	public void updateMeal(@PathParam("restID")long restID, Meal meals) {
		
		Restaurant restaurant= entityManager.find(Restaurant.class, restID);
		
 
        Meal meal = null; 
        for (Meal m : restaurant.getMealsList()) {
            if (m.getId().equals(meals.getId())) {
                meal = m;
                break;
            }
        }

      
        if (meal != null) {
            meal.setName(meals.getName());
            meal.setPrice(meals.getPrice());
            entityManager.merge(meal); // Update the meal in the database
        }
        else
        	throw new NullPointerException("No item exists");
        
    }

}

	
	
	
//	public Report getRestaurantReport(int id)
//	{
//		TypedQuery<Restaurant>query=entityManager.createQuery("SELECT rest FROM Restaurant rest WHERE rest.id:id",Restaurant.class);
//		query.setParameter("id", id);
//		List<Res>
//	}
//	
	
	
	
	

