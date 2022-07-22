package com.abc.AssetManagement.UserEntity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "requestedAssets")
public class RequestedAssets implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int requestId;
	@Column(name = "product_name")
	private String ProductName;
	@Column(name = "Request_status")
	private String RequestStatus;
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnoreProperties(value = {"requestedAssets", "hibernateLazyInitializer"})
	private Employee employee;
	
	public RequestedAssets(){
		super();
		// TODO Auto-generated constructor stub
	}

	public RequestedAssets(int requestId, String productName, String requestStatus, Employee employee) {
		super();
		this.requestId = requestId;
		ProductName = productName;
		RequestStatus = requestStatus;
		this.employee = employee;
	}

	public int getRequestId() {
		return requestId;
	}
public void setRequestId(int requestId) {
	this.requestId = requestId;
}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public String getRequestStatus() {
		return RequestStatus;
	}
	public void setRequestStatus(String requestStatus) {
		RequestStatus = requestStatus;
	}
	@JsonIgnoreProperties("requests")
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}


	
}
