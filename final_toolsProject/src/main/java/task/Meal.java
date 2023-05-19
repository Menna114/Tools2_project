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

	    @Column(name = "name")
	    private String name;

	    @Column(name = "price")
	    private double price;
        
	    @ManyToOne
	    @JoinColumn(name = "fk_restaurantId")
	    private Restaurant restaurant; 
	    
	    Meal()
	    {
	    	
	    }
	    void setName(String name)
		{
			this.name=name;
		}
		
		String getName()
		{
			return name;
		}
		
		void setPrice(double price)
		{
			this.price=price;
		}
		
		double getPrice()
		{
			return price;
		}
		

}
