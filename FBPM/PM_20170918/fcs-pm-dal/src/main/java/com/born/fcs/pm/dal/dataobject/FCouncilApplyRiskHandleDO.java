/**
 * www.yiji.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.born.fcs.pm.dal.dataobject;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

// auto generated imports
import java.util.Date;
import com.yjf.common.lang.util.money.Money;

/**
 * A data object class directly models database table <tt>f_council_apply_risk_handle</tt>.
 *
 * This file is generated by <tt>specialmer-dalgen</tt>, a DAL (Data Access Layer)
 * code generation utility specially developed for <tt>paygw</tt> project.
 * 
 * PLEASE DO NOT MODIFY THIS FILE MANUALLY, or else your modification may
 * be OVERWRITTEN by someone else. To modify the file, you should go to 
 * directory <tt>(project-home)/biz/dal/src/conf/dalgen</tt>, and 
 * find the corresponding configuration file (<tt>tables/f_council_apply_risk_handle.xml</tt>). 
 * Modify the configuration file according to your needs, then run <tt>specialmer-dalgen</tt> 
 * to generate this file.
 *
 * @author peigen
 */
public class FCouncilApplyRiskHandleDO implements Serializable{
	/** Comment for <code>serialVersionUID</code> */
    private static final long serialVersionUID = -4282603875229233564L;

    //========== properties ==========

	private long id;

	private long applyId;

	private long formId;

	private String projectCode;

	private String projectName;

	private long customerId;

	private String customerName;

	private String isRepay;

	private String companyName;

	private String enterpriseType;

	private Money guaranteeAmount = new Money(0, 0);

	private double guaranteeRate;

	private String guaranteeRateType;

	private String loanBank;

	private String loanTimeLimit;

	private String busiManagerName;

	private String riskManagerName;

	private Money repayAmount = new Money(0, 0);

	private Date repayDate;

	private String loanType;

	private String creditTimeLimit;

	private Money creditAmount = new Money(0, 0);

	private String basicInfo;

	private String riskInfo;

	private String lastCouncilDecision;

	private String lastCouncilCheck;

	private String thisCouncilScheme;

	private String status;

	private Date rawAddTime;

	private Date rawUpdateTime;

    //========== getters and setters ==========

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public long getApplyId() {
		return applyId;
	}
	
	public void setApplyId(long applyId) {
		this.applyId = applyId;
	}

	public long getFormId() {
		return formId;
	}
	
	public void setFormId(long formId) {
		this.formId = formId;
	}

	public String getProjectCode() {
		return projectCode;
	}
	
	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	public String getProjectName() {
		return projectName;
	}
	
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public long getCustomerId() {
		return customerId;
	}
	
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}
	
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getIsRepay() {
		return isRepay;
	}
	
	public void setIsRepay(String isRepay) {
		this.isRepay = isRepay;
	}

	public String getCompanyName() {
		return companyName;
	}
	
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getEnterpriseType() {
		return enterpriseType;
	}
	
	public void setEnterpriseType(String enterpriseType) {
		this.enterpriseType = enterpriseType;
	}

	public Money getGuaranteeAmount() {
		return guaranteeAmount;
	}
	
	public void setGuaranteeAmount(Money guaranteeAmount) {
		if (guaranteeAmount == null) {
			this.guaranteeAmount = new Money(0, 0);
		} else {
			this.guaranteeAmount = guaranteeAmount;
		}
	}

	public double getGuaranteeRate() {
		return guaranteeRate;
	}
	
	public void setGuaranteeRate(double guaranteeRate) {
		this.guaranteeRate = guaranteeRate;
	}

	public String getGuaranteeRateType() {
		return guaranteeRateType;
	}
	
	public void setGuaranteeRateType(String guaranteeRateType) {
		this.guaranteeRateType = guaranteeRateType;
	}

	public String getLoanBank() {
		return loanBank;
	}
	
	public void setLoanBank(String loanBank) {
		this.loanBank = loanBank;
	}

	public String getLoanTimeLimit() {
		return loanTimeLimit;
	}
	
	public void setLoanTimeLimit(String loanTimeLimit) {
		this.loanTimeLimit = loanTimeLimit;
	}

	public String getBusiManagerName() {
		return busiManagerName;
	}
	
	public void setBusiManagerName(String busiManagerName) {
		this.busiManagerName = busiManagerName;
	}

	public String getRiskManagerName() {
		return riskManagerName;
	}
	
	public void setRiskManagerName(String riskManagerName) {
		this.riskManagerName = riskManagerName;
	}

	public Money getRepayAmount() {
		return repayAmount;
	}
	
	public void setRepayAmount(Money repayAmount) {
		if (repayAmount == null) {
			this.repayAmount = new Money(0, 0);
		} else {
			this.repayAmount = repayAmount;
		}
	}

	public Date getRepayDate() {
		return repayDate;
	}
	
	public void setRepayDate(Date repayDate) {
		this.repayDate = repayDate;
	}

	public String getLoanType() {
		return loanType;
	}
	
	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public String getCreditTimeLimit() {
		return creditTimeLimit;
	}
	
	public void setCreditTimeLimit(String creditTimeLimit) {
		this.creditTimeLimit = creditTimeLimit;
	}

	public Money getCreditAmount() {
		return creditAmount;
	}
	
	public void setCreditAmount(Money creditAmount) {
		if (creditAmount == null) {
			this.creditAmount = new Money(0, 0);
		} else {
			this.creditAmount = creditAmount;
		}
	}

	public String getBasicInfo() {
		return basicInfo;
	}
	
	public void setBasicInfo(String basicInfo) {
		this.basicInfo = basicInfo;
	}

	public String getRiskInfo() {
		return riskInfo;
	}
	
	public void setRiskInfo(String riskInfo) {
		this.riskInfo = riskInfo;
	}

	public String getLastCouncilDecision() {
		return lastCouncilDecision;
	}
	
	public void setLastCouncilDecision(String lastCouncilDecision) {
		this.lastCouncilDecision = lastCouncilDecision;
	}

	public String getLastCouncilCheck() {
		return lastCouncilCheck;
	}
	
	public void setLastCouncilCheck(String lastCouncilCheck) {
		this.lastCouncilCheck = lastCouncilCheck;
	}

	public String getThisCouncilScheme() {
		return thisCouncilScheme;
	}
	
	public void setThisCouncilScheme(String thisCouncilScheme) {
		this.thisCouncilScheme = thisCouncilScheme;
	}

	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
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