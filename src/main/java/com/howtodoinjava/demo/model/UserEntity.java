package com.howtodoinjava.demo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="user")
public class UserEntity implements Serializable {
	@Id
    @GeneratedValue
	private Integer id;
	
	@NotEmpty
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private BigDecimal money;
	private String username;
	private String password;
	
	public UserEntity() {
		super();
	}
	
	public UserEntity(Integer id, String firstName, String lastName, String email, String phone, BigDecimal money,
			String username, String password, List<DeviceEntity> users) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.money = money;
		this.username = username;
		this.password = password;
		this.users = users;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<DeviceEntity> getUsers() {
		return users;
	}

	public void setUsers(List<DeviceEntity> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", phone=" + phone + ", money=" + money + ", username=" + username + ", password=" + password
				+ ", users=" + users + "]";
	}

	@OneToMany(mappedBy="user",cascade=CascadeType.PERSIST)
    private List<DeviceEntity> users = new ArrayList<DeviceEntity>();
	
	public List<DeviceEntity> getEmployees() {
        return users;
    }
    public void setEmployees(List<DeviceEntity> users) {
        this.users = users;
    }
}