package task;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	
	private String role;
	
	
	private String name;
	
	@OneToOne
    @JoinColumn(name = "restaurantID")
	private Restaurant OwnerId;
	
	User()
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
	
	void setRole(String role)
	{
		this.role=role;
	}
	
	String getRole()
	{
		return role;
	}

}
