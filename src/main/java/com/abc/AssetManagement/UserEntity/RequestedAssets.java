package com.abc.AssetManagement.UserEntity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

@Entity
@Table(name = "requestedAssets")
public class RequestedAssets {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int requestId;
	@Column(name = "product_name")
	private String ProductName;
	@Column(name = "Request_status")
	private String RequestStatus;
	
	public RequestedAssets(){
		super();
		// TODO Auto-generated constructor stub
	}
	public RequestedAssets(int requestId, String productName, String requestStatus) {
		super();
		this.requestId = requestId;
		ProductName = productName;
		RequestStatus = requestStatus;
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


	
}
