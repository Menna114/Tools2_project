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
public class Order  implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID") 
	private Long id;
	
	private ArrayList<Meal> meals = new ArrayList<>();
	
	@Column(name="Totalprice")
	private double total_price;
	
	@Column(name = "status")
	@Enumerated(EnumType.STRING)
    private OrderStatus status;
	@ManyToOne
	@JoinColumn(name="runnerId")
	private Runner Runner;
	@ManyToOne
	@JoinColumn(name="restaurantId")
	private Restaurant Restaurant;
	
	void settotal_price(double total_price)
	{
		this.total_price=total_price;
	}
	
	double gettotal_price()
	{
		return total_price;
	}
	

}
