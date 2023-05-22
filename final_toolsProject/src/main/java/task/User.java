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
	
	public User()
	{
		
	}	
	
	public void setName(String name)
	{
		this.name=name;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setRole(String role)
	{
		this.role=role;
	}
	
	public String getRole()
	{
		return role;
	}

<<<<<<< Updated upstream
=======
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Restaurant getOwnerId() {
		return OwnerId;
	}

	public void setOwnerId(Restaurant ownerId) {
		OwnerId = ownerId;
	}
	

>>>>>>> Stashed changes
}
