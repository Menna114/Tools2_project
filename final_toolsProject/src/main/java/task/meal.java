package task;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "meal")
public class meal implements Serializable {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name="ID") 
	    private Long id;

	    @Column(name = "name")
	    private String name;

	    @Column(name = "price")
	    private double price;

	    //missing fk_restaurantId
	    
	    meal()
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
