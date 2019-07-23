package com.ji.model;

/**
 * @author JI
 *
 */

public class CustomerVO {
	private String cusId;
	private String cusName;
	private int age;
	private String rank;
	private String job;
	private int reserve;
	
	public CustomerVO() {
		
	}

	public CustomerVO(String cusId, String cusName, int age, String rank, String job, int reserve) {
		super();
		this.cusId = cusId;
		this.cusName = cusName;
		this.age = age;
		this.rank = rank;
		this.job = job;
		this.reserve = reserve;
	}
	
	
	
	public String getCusId() {
		return cusId;
	}

	public void setCusId(String cusId) {
		this.cusId = cusId;
	}

	public String getCusName() {
		return cusName;
	}

	public void setCusName(String cusName) {
		this.cusName = cusName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getReserve() {
		return reserve;
	}

	public void setReserve(int reserve) {
		this.reserve = reserve;
	}
	
	
	
	@Override
	public String toString() {
		return "CustomerVO [cusId=" + cusId + ", cusName=" + cusName + ", age=" + age + ", rank=" + rank + ", job="
				+ job + ", reserve=" + reserve + "]";
	}

}
