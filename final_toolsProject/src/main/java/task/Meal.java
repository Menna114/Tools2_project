package task;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "meal")
public class Meal implements Serializable {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name="ID") 
	    private Long id;

	   
	    private String name;
        
	    @ManyToOne
	    @JoinColumn(name="fk_orders")
	    private Orders OrderMeals;
	    
	    private double price;
        
	    @ManyToOne
	    @JoinColumn(name = "fk_restaurantId")
	    private Restaurant restaurantMeals; 
	    
	    public Meal()
	    {
	    	
	    }
	    public Meal(double price, String name)
	    {
	    	this.price=price;
	    	this.name=name;
	    }
	    public void setName(String name)
		{
			this.name=name;
		}
		
		public String getName()
		{
			return name;
		}
		
		public void setPrice(double price)
		{
			this.price=price;
		}
		
		public double getPrice()
		{
			return price;
		}
		public void setRestaurantMeals(Restaurant restaurant)
		{
			this.restaurantMeals=restaurant;
		}
		public Restaurant getRestaurantMeals()
		{
			return restaurantMeals;
		}
		

}
