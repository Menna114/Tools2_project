package task;
import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Orders implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID") 
	private Long id;
	
	private ArrayList<Meal> meals = new ArrayList<>();
	
	
	private double totalPrice;
	
	@Column(name = "status")
	@Enumerated(EnumType.STRING)
    private OrderStatus status;
	

	@ManyToOne
	@JoinColumn(name="runnerId")
	private Runner runner;
	@ManyToOne
	@JoinColumn(name="fk_restaurantId,")
	private Restaurant restaurantOrders;
	
	
    public double Totalprice()
    {
    	
    	for(int i =0;i<meals.size();i++)
    	{
    		totalPrice=meals.get(i).getPrice()+totalPrice;
    		
    	}
    	return totalPrice;
    }
	
	public void setTotalprice(double totalPrice)
	{
		this.totalPrice=totalPrice;
	}
	
	public double getTotalPrice()
	{
		return totalPrice;
	}
	public void setRestaurantOrders(Restaurant restaurant)
	{
		this.restaurantOrders=restaurant;
	}
	public Restaurant getRestaurantOrders()
	{
		return restaurantOrders;
	}
	public void setRunner(Runner runner)
	{
		this.runner=runner;
	}
	public Runner getRunner()
	{
		return runner;
	}

	public ArrayList<Meal> getMeals() {
		return meals;
	}

	public void setMeals(ArrayList<Meal> meals) {
		this.meals = meals;
	}
	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	
	

}
