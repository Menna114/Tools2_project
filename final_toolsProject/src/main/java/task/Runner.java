package task;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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


    private String name;
    
    
    private double deliveryFees;
    
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private RunnerStatus status;
    

	@OneToMany(mappedBy="runner")
	private Set<Orders>orders;
    
    public Set<Orders> getOrders() {
		return orders;
	}

	public void setOrders(Set<Orders> orders) {
		this.orders = orders;
	}

	public void setName(String name)
	{
		this.name=name;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setDeliveryFees(double deliveryFees)
	{
		this.deliveryFees=deliveryFees;
	}
	
	public double getDeliveryFees()
	{
		return deliveryFees;
	}
	public RunnerStatus getStatus() {
		return status;
	}

	public void setStatus(RunnerStatus status) {
		this.status = status;
	}
    
    
    
}
