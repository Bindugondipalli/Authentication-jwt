package me.aboullaite.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@Entity
@ApiModel(description="This is the user model")
@Table(name="User")
public class User {
	@ApiModelProperty(value = "A unique key for each service")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="u_Id")
	private Integer userId;
	@ApiModelProperty(value = "Name of the user")
	@Column(name="firstName")
	private String firstName;
	@ApiModelProperty(value = "Name of the user")
	@Column(name="lastName")
	private String lastName;
	@ApiModelProperty(value = "email of user")
	@Column(name="email")
	private String email;
	@Column(name="password")
	private String password;

	

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
}
