package com.onlineauction.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class OpenProducts {
	private String productName;
	private Double actualPrice;
	private String productimage;
	private double minBid;
	private int noOfBiders;
	private LocalDateTime bidDate;
	private LocalDateTime bidEnd;
	
	public Double getActualPrice() {
		return actualPrice;
	}
	public void setActualPrice(Double actualPrice) {
		this.actualPrice = actualPrice;
	}
	public String getProductimage() {
		return productimage;
	}
	public void setProductimage(String productimage) {
		this.productimage = productimage;
	}
	public LocalDateTime getBidEnd() {
		return bidEnd;
	}
	public void setBidEnd(LocalDateTime bidEnd) {
		this.bidEnd = bidEnd;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getMinBid() {
		return minBid;
	}
	public void setMinBid(double minBid) {
		this.minBid = minBid;
	}
	public int getNoOfBiders() {
		return noOfBiders;
	}
	public void setNoOfBiders(int noOfBiders) {
		this.noOfBiders = noOfBiders;
	}
	public LocalDateTime getBidDate() {
		return bidDate;
	}
	public void setBidDate(LocalDateTime bidDate) {
		this.bidDate = bidDate;
	}	
}
