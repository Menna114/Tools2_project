package task;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "runner")
public class Runner implements Serializable {
	Runner()
	{
		
	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
    
    @Column(name = "delivery_fees")
    private double deliveryFees;
    
    //missing status
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private RunnerStatus status;
    
    void setName(String name)
	{
		this.name=name;
	}
	
	String getName()
	{
		return name;
	}
	
	void setDelivery_Fees(double deliveryFees)
	{
		this.deliveryFees=deliveryFees;
	}
	
	double getDelivery_Fees()
	{
		return deliveryFees;
	}
    
    
    
}
