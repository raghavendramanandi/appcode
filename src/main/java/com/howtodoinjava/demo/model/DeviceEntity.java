package com.howtodoinjava.demo.model;

import java.io.Serializable;
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

@Entity
@Table (name="device")
public class DeviceEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private String securityCode;
	private int clickCount;
	private int securityRetryCount;
	private String connName;
	private String connPassword;
	private String connMode;
	
	@NotNull
	@ManyToOne
	private UserEntity user;

	public DeviceEntity(Integer id, String name, String securityCode, int clickCount, int securityRetryCount,
			String connName, String connPassword, String connMode, UserEntity user) {
		super();
		this.id = id;
		this.name = name;
		this.securityCode = securityCode;
		this.clickCount = clickCount;
		this.securityRetryCount = securityRetryCount;
		this.connName = connName;
		this.connPassword = connPassword;
		this.connMode = connMode;
		this.user = user;
	}

	public DeviceEntity() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}

	public int getClickCount() {
		return clickCount;
	}

	public void setClickCount(int clickCount) {
		this.clickCount = clickCount;
	}

	public int getSecurityRetryCount() {
		return securityRetryCount;
	}

	public void setSecurityRetryCount(int securityRetryCount) {
		this.securityRetryCount = securityRetryCount;
	}

	public String getConnName() {
		return connName;
	}

	public void setConnName(String connName) {
		this.connName = connName;
	}

	public String getConnPassword() {
		return connPassword;
	}

	public void setConnPassword(String connPassword) {
		this.connPassword = connPassword;
	}

	public String getConnMode() {
		return connMode;
	}

	public void setConnMode(String connMode) {
		this.connMode = connMode;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "DeviceEntity [id=" + id + ", name=" + name + ", securityCode=" + securityCode + ", clickCount="
				+ clickCount + ", securityRetryCount=" + securityRetryCount + ", connName=" + connName
				+ ", connPassword=" + connPassword + ", connMode=" + connMode + ", user=" + user + "]";
	}
}
