package com.abc.AssetManagement.entity;


import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "releasedAssets")
public class ReleasedAssets{
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY )
	 private int ReleasedId;
	 @OneToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	 @JoinColumn(name = "fk_Reqs")
	 private RequestedAssets requestId;
	 
	@Column(name = "releaseStatus")
	private  String ReleaseStatus;


	
public ReleasedAssets() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReleasedAssets(int releaseId, String releaseStatus, int requestId) {
		super();
	
		ReleaseStatus = releaseStatus;
		
	}
	public String getReleaseStatus() {
		return ReleaseStatus;
	}
	public void setReleaseStatus(String releaseStatus) {
		ReleaseStatus = releaseStatus;
	}

}
