package task;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "users")
public class user implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID") 
	private long id;
	private String name;
	private String role;
	
	user()
	{}	
	void setName(String name)
	{
		this.name=name;
	}
	@Column(name="Name")
	String getName()
	{
		return name;
	}
	void setRole(String role)
	{
		this.role=role;
	}
	@Column(name="Role")
	String getRole()
	{
		return role;
	}

}
