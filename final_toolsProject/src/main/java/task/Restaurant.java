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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Restaurant implements Serializable {
	
    Restaurant()
    {
    	
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    
    @OneToOne(mappedBy="OwnerId")
    private User user;
    
   
	@OneToMany(mappedBy="restaurantOrders",fetch =FetchType.EAGER)
    private Set<Orders>orders;
    @OneToMany(mappedBy="restaurantMeals",fetch =FetchType.EAGER)
    private List<Meal> meals;


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
	public User getOwner() 
	 {
			return user;
	 }

     public void setOwner(User user) 
     {
			this.user = user;
	 }

}