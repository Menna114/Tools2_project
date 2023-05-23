package task;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
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
    
   
	@OneToMany(mappedBy="restaurantOrders",cascade = CascadeType.ALL, orphanRemoval = true)
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public ArrayList<Meal> getMealsList() {
		return mealsList;
	}

	public void setMealsList(ArrayList<Meal> mealsList) {
		this.mealsList = mealsList;
	}

//	public User getUser() 
//	 {
//			return user;
//	 }
//
//    public void setUser(User user) 
//    {
//			this.user = user;
//	 }
}