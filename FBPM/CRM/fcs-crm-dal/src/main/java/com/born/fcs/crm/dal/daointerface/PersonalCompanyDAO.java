/**
 * www.yiji.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.born.fcs.crm.dal.daointerface;

// auto generated imports
import com.born.fcs.crm.dal.dataobject.PersonalCompanyDO;
import org.springframework.dao.DataAccessException;
import java.util.List;

/**
 * A dao interface provides methods to access database table <tt>personal_company</tt>.
 *
 * This file is generated by <tt>specialmer-dalgen</tt>, a DAL (Data Access Layer)
 * code generation utility specially developed for <tt>paygw</tt> project.
 * 
 * PLEASE DO NOT MODIFY THIS FILE MANUALLY, or else your modification may
 * be OVERWRITTEN by someone else. To modify the file, you should go to 
 * directory <tt>(project-home)/biz/dal/src/conf/dalgen</tt>, and 
 * find the corresponding configuration file (<tt>tables/personal_company.xml</tt>). 
 * Modify the configuration file according to your needs, then run <tt>specialmer-dalgen</tt> 
 * to generate this file.
 *
 * @author peigen
 */
 @SuppressWarnings("rawtypes") 
public interface PersonalCompanyDAO {
	/**
	 *  Insert one <tt>PersonalCompanyDO</tt> object to DB table <tt>personal_company</tt>, return primary key
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>insert into personal_company(id,customer_id,per_company,per_regist_amount,per_regist_date,per_link_person,per_address,per_link_mobile,per_memo,per_status,perent_id,child_id,per_is_temporary,raw_add_time) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)</tt>
	 *
	 *	@param personalCompany
	 *	@return long
	 *	@throws DataAccessException
	 */	 
    public long insert(PersonalCompanyDO personalCompany) throws DataAccessException;

	/**
	 *  Query DB table <tt>personal_company</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select id, customer_id, per_company, per_regist_amount, per_regist_date, per_link_person, per_address, per_link_mobile, per_memo, per_status, perent_id, child_id, per_is_temporary, raw_add_time, raw_update_time from personal_company where (id = ?)</tt>
	 *
	 *	@param id
	 *	@return PersonalCompanyDO
	 *	@throws DataAccessException
	 */	 
    public PersonalCompanyDO findById(long id) throws DataAccessException;

	/**
	 *  Query DB table <tt>personal_company</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select id from personal_company where (customer_id = ?)</tt>
	 *
	 *	@param customerId
	 *	@return List<Long>
	 *	@throws DataAccessException
	 */	 
    public List<Long> findByAllIds(String customerId) throws DataAccessException;

	/**
	 *  Delete records from DB table <tt>personal_company</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>delete from personal_company where (id = ?)</tt>
	 *
	 *	@param id
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int deleteById(long id) throws DataAccessException;

	/**
	 *  Delete records from DB table <tt>personal_company</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>delete from personal_company where (customer_id = ?)</tt>
	 *
	 *	@param customerId
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int deleteByCustomerId(String customerId) throws DataAccessException;

	/**
	 *  Update DB table <tt>personal_company</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>update personal_company set customer_id=?, per_company=?, per_regist_amount=?, per_regist_date=?, per_link_person=?, per_address=?, per_link_mobile=?, per_memo=?, per_status=?, perent_id=?, child_id=?, per_is_temporary=? where (id = ?)</tt>
	 *
	 *	@param personalCompany
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int update(PersonalCompanyDO personalCompany) throws DataAccessException;

	/**
	 *  Query DB table <tt>personal_company</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select id, customer_id, per_company, per_regist_amount, per_regist_date, per_link_person, per_address, per_link_mobile, per_memo, per_status, perent_id, child_id, per_is_temporary, raw_add_time, raw_update_time from personal_company</tt>
	 *
	 *	@param personalCompany
	 *	@param limitStart
	 *	@param pageSize
	 *	@return List<PersonalCompanyDO>
	 *	@throws DataAccessException
	 */	 
    public List<PersonalCompanyDO> findWithCondition(PersonalCompanyDO personalCompany, long limitStart, long pageSize) throws DataAccessException;

	/**
	 *  Query DB table <tt>personal_company</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select COUNT(*) from personal_company</tt>
	 *
	 *	@param personalCompany
	 *	@return long
	 *	@throws DataAccessException
	 */	 
    public long countWithCondition(PersonalCompanyDO personalCompany) throws DataAccessException;

}