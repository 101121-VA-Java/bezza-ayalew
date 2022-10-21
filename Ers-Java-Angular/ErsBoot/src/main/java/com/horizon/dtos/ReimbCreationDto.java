package com.horizon.dtos;

public class ReimbCreationDto {
	int reimbId;
	double reimbAmount;
	String reimbDescription;
	String reimbReceipt;
	int reimbAuthor;
	String reimbResolved;
	String reimbSubmitted;
	int reimbResolver;
	int reimbStatus;
	int reimbType;
	
	public ReimbCreationDto(int reimbId, double reimbAmount, String reimbDescription, String reimbReceipt, int reimbAuthor,
			String reimbResolved, String reimbSubmitted, int reimbResolver, int reimbStatus, int reimbType) {
		super();
		this.reimbId = reimbId;
		this.reimbAmount = reimbAmount;
		this.reimbDescription = reimbDescription;
		this.reimbReceipt = reimbReceipt;
		this.reimbAuthor = reimbAuthor;
		this.reimbResolved = reimbResolved;
		this.reimbSubmitted = reimbSubmitted;
		this.reimbResolver = reimbResolver;
		this.reimbStatus = reimbStatus;
		this.reimbType = reimbType;
	}

	public int getReimbId() {
		return reimbId;
	}

	public void setReimbId(int reimbId) {
		this.reimbId = reimbId;
	}
	
	public double getReimbAmount() {
		return reimbAmount;
	}

	public void setReimbAmount(double reimbAmount) {
		this.reimbAmount = reimbAmount;
	}

	public String getReimbDescription() {
		return reimbDescription;
	}

	public void setReimbDescription(String reimbDescription) {
		this.reimbDescription = reimbDescription;
	}

	public String getReimbReceipt() {
		return reimbReceipt;
	}

	public void setReimbReceipt(String reimbReceipt) {
		this.reimbReceipt = reimbReceipt;
	}

	public int getReimbAuthor() {
		return reimbAuthor;
	}

	public void setReimbAuthor(int reimbAuthor) {
		this.reimbAuthor = reimbAuthor;
	}

	public String getReimbResolved() {
		return reimbResolved;
	}

	public void setReimbResolved(String reimbResolved) {
		this.reimbResolved = reimbResolved;
	}

	public String getReimbSubmitted() {
		return reimbSubmitted;
	}

	public void setReimbSubmitted(String reimbSubmitted) {
		this.reimbSubmitted = reimbSubmitted;
	}

	public int getReimbResolver() {
		return reimbResolver;
	}

	public void setReimbResolver(int reimbResolver) {
		this.reimbResolver = reimbResolver;
	}

	public int getReimbStatus() {
		return reimbStatus;
	}

	public void setReimbStatus(int reimbStatus) {
		this.reimbStatus = reimbStatus;
	}

	public int getReimbType() {
		return reimbType;
	}

	public void setReimbType(int reimbType) {
		this.reimbType = reimbType;
	}
	
	
}
