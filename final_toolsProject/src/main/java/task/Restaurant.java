package task;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Restaurant implements Serializable {
	
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    
    protected String name;
    
    @OneToOne(mappedBy="OwnerId")
    private User user;
    
   
	@OneToMany(mappedBy="restaurantOrders")
    private Set<Orders>orders;
    @OneToMany(mappedBy="restaurantMeals")
    private List<Meal> meals;
    
    @Lob
    protected ArrayList<Meal>mealsList = new ArrayList<Meal>();


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Meal> getMeals() {
		return meals;
	}

	public void setMeals(List<Meal> meals) {
		this.meals = meals;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public User getUser() 
	 {
			return user;
	 }

    public void setUser(User user) 
    {
			this.user = user;
	 }
}