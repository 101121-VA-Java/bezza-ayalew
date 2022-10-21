package com.horizon.dtos;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ReimbursementDto {
	private int reimbId;
	private double reimbAmount;
	private String reimbDescription;
	private String reimbReceipt;
	private LocalDate reimbResolved;
	private LocalDate reimbSubmitted;
	private int reimbAuthor;
	private int reimbResolver;
	private int reimbStatus;
	private int reimbType;

}
