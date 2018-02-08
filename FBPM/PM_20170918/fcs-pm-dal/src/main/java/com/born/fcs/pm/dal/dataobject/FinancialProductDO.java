/**
 * www.yiji.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.born.fcs.pm.dal.dataobject;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

// auto generated imports
import com.yjf.common.lang.util.money.Money;
import java.util.Date;

/**
 * A data object class directly models database table <tt>financial_product</tt>.
 *
 * This file is generated by <tt>specialmer-dalgen</tt>, a DAL (Data Access Layer)
 * code generation utility specially developed for <tt>paygw</tt> project.
 * 
 * PLEASE DO NOT MODIFY THIS FILE MANUALLY, or else your modification may
 * be OVERWRITTEN by someone else. To modify the file, you should go to 
 * directory <tt>(project-home)/biz/dal/src/conf/dalgen</tt>, and 
 * find the corresponding configuration file (<tt>tables/financial_product.xml</tt>). 
 * Modify the configuration file according to your needs, then run <tt>specialmer-dalgen</tt> 
 * to generate this file.
 *
 * @author peigen
 */
public class FinancialProductDO implements Serializable{
	/** Comment for <code>serialVersionUID</code> */
    private static final long serialVersionUID = -4282603875229233564L;

    //========== properties ==========

	private long productId;

	private String productType;

	private String productName;

	private String interestType;

	private String termType;

	private int timeLimit;

	private String timeUnit;

	private String issueInstitution;

	private double interestRate;

	private double rateRangeStart;

	private double rateRangeEnd;

	private String interestSettlementWay;

	private Money price = new Money(0, 0);

	private String sellStatus;

	private String riskLevel;

	private int yearDayNum;

	private String remark;

	private Date rawAddTime;

	private Date rawUpdateTime;

    //========== getters and setters ==========

	public long getProductId() {
		return productId;
	}
	
	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductType() {
		return productType;
	}
	
	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getInterestType() {
		return interestType;
	}
	
	public void setInterestType(String interestType) {
		this.interestType = interestType;
	}

	public String getTermType() {
		return termType;
	}
	
	public void setTermType(String termType) {
		this.termType = termType;
	}

	public int getTimeLimit() {
		return timeLimit;
	}
	
	public void setTimeLimit(int timeLimit) {
		this.timeLimit = timeLimit;
	}

	public String getTimeUnit() {
		return timeUnit;
	}
	
	public void setTimeUnit(String timeUnit) {
		this.timeUnit = timeUnit;
	}

	public String getIssueInstitution() {
		return issueInstitution;
	}
	
	public void setIssueInstitution(String issueInstitution) {
		this.issueInstitution = issueInstitution;
	}

	public double getInterestRate() {
		return interestRate;
	}
	
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public double getRateRangeStart() {
		return rateRangeStart;
	}
	
	public void setRateRangeStart(double rateRangeStart) {
		this.rateRangeStart = rateRangeStart;
	}

	public double getRateRangeEnd() {
		return rateRangeEnd;
	}
	
	public void setRateRangeEnd(double rateRangeEnd) {
		this.rateRangeEnd = rateRangeEnd;
	}

	public String getInterestSettlementWay() {
		return interestSettlementWay;
	}
	
	public void setInterestSettlementWay(String interestSettlementWay) {
		this.interestSettlementWay = interestSettlementWay;
	}

	public Money getPrice() {
		return price;
	}
	
	public void setPrice(Money price) {
		if (price == null) {
			this.price = new Money(0, 0);
		} else {
			this.price = price;
		}
	}

	public String getSellStatus() {
		return sellStatus;
	}
	
	public void setSellStatus(String sellStatus) {
		this.sellStatus = sellStatus;
	}

	public String getRiskLevel() {
		return riskLevel;
	}
	
	public void setRiskLevel(String riskLevel) {
		this.riskLevel = riskLevel;
	}

	public int getYearDayNum() {
		return yearDayNum;
	}
	
	public void setYearDayNum(int yearDayNum) {
		this.yearDayNum = yearDayNum;
	}

	public String getRemark() {
		return remark;
	}
	
	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getRawAddTime() {
		return rawAddTime;
	}
	
	public void setRawAddTime(Date rawAddTime) {
		this.rawAddTime = rawAddTime;
	}

	public Date getRawUpdateTime() {
		return rawUpdateTime;
	}
	
	public void setRawUpdateTime(Date rawUpdateTime) {
		this.rawUpdateTime = rawUpdateTime;
	}


	/**
     * @return
     *
     * @see java.lang.Object#toString()
     */
	@Override
    public String toString() {

        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}