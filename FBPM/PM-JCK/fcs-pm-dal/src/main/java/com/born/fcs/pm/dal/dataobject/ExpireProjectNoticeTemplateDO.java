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

/**
 * A data object class directly models database table <tt>expire_project_notice_template</tt>.
 *
 * This file is generated by <tt>specialmer-dalgen</tt>, a DAL (Data Access Layer)
 * code generation utility specially developed for <tt>paygw</tt> project.
 * 
 * PLEASE DO NOT MODIFY THIS FILE MANUALLY, or else your modification may
 * be OVERWRITTEN by someone else. To modify the file, you should go to 
 * directory <tt>(project-home)/biz/dal/src/conf/dalgen</tt>, and 
 * find the corresponding configuration file (<tt>tables/expire_project_notice_template.xml</tt>). 
 * Modify the configuration file according to your needs, then run <tt>specialmer-dalgen</tt> 
 * to generate this file.
 *
 * @author peigen
 */
public class ExpireProjectNoticeTemplateDO implements Serializable{
	/** Comment for <code>serialVersionUID</code> */
    private static final long serialVersionUID = -4282603875229233564L;

    //========== properties ==========

	private long id;

	private long expireId;

	private String year;

	private String sequence;

	private String projectCode;

	private String projectName;

	private String exhibitionPeriodProtocolNo;

	private long borrowMoney;

	private long operatorId;

	private String operator;

	private Date issueDate;

	private Date expirationDate;

	private long interest;

	private long fullInNumbers;

	private long returnNumbers;

	private String status;

	private String receipt;

	private String remark;

	private String html;

	private Date rawAddTime;

	private Date rawUpdateTime;

    //========== getters and setters ==========

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public long getExpireId() {
		return expireId;
	}
	
	public void setExpireId(long expireId) {
		this.expireId = expireId;
	}

	public String getYear() {
		return year;
	}
	
	public void setYear(String year) {
		this.year = year;
	}

	public String getSequence() {
		return sequence;
	}

	public void setSequence(String sequence) {
		this.sequence = sequence;
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

	public String getExhibitionPeriodProtocolNo() {
		return exhibitionPeriodProtocolNo;
	}
	
	public void setExhibitionPeriodProtocolNo(String exhibitionPeriodProtocolNo) {
		this.exhibitionPeriodProtocolNo = exhibitionPeriodProtocolNo;
	}

	public long getBorrowMoney() {
		return borrowMoney;
	}
	
	public void setBorrowMoney(long borrowMoney) {
		this.borrowMoney = borrowMoney;
	}

	public long getOperatorId() {
		return operatorId;
	}
	
	public void setOperatorId(long operatorId) {
		this.operatorId = operatorId;
	}

	public String getOperator() {
		return operator;
	}
	
	public void setOperator(String operator) {
		this.operator = operator;
	}

	public Date getIssueDate() {
		return issueDate;
	}
	
	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}
	
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public long getInterest() {
		return interest;
	}
	
	public void setInterest(long interest) {
		this.interest = interest;
	}

	public long getFullInNumbers() {
		return fullInNumbers;
	}
	
	public void setFullInNumbers(long fullInNumbers) {
		this.fullInNumbers = fullInNumbers;
	}

	public long getReturnNumbers() {
		return returnNumbers;
	}
	
	public void setReturnNumbers(long returnNumbers) {
		this.returnNumbers = returnNumbers;
	}

	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}

	public String getReceipt() {
		return receipt;
	}
	
	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}

	public String getRemark() {
		return remark;
	}
	
	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getHtml() {
		return html;
	}
	
	public void setHtml(String html) {
		this.html = html;
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