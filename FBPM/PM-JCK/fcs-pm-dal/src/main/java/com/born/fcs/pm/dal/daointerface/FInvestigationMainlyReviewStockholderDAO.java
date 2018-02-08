/**
 * www.yiji.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.born.fcs.pm.dal.daointerface;

// auto generated imports
import com.born.fcs.pm.dal.dataobject.FInvestigationMainlyReviewStockholderDO;
import org.springframework.dao.DataAccessException;
import java.util.List;

/**
 * A dao interface provides methods to access database table <tt>f_investigation_mainly_review_stockholder</tt>.
 *
 * This file is generated by <tt>specialmer-dalgen</tt>, a DAL (Data Access Layer)
 * code generation utility specially developed for <tt>paygw</tt> project.
 * 
 * PLEASE DO NOT MODIFY THIS FILE MANUALLY, or else your modification may
 * be OVERWRITTEN by someone else. To modify the file, you should go to 
 * directory <tt>(project-home)/biz/dal/src/conf/dalgen</tt>, and 
 * find the corresponding configuration file (<tt>tables/f_investigation_mainly_review_stockholder.xml</tt>). 
 * Modify the configuration file according to your needs, then run <tt>specialmer-dalgen</tt> 
 * to generate this file.
 *
 * @author peigen
 */
 @SuppressWarnings("rawtypes") 
public interface FInvestigationMainlyReviewStockholderDAO {
	/**
	 *  Insert one <tt>FInvestigationMainlyReviewStockholderDO</tt> object to DB table <tt>f_investigation_mainly_review_stockholder</tt>, return primary key
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>insert into f_investigation_mainly_review_stockholder(m_review_id,holder_name,holder_type,holder_cert_type,holder_cert_no,actual_investment,paidin_capital_ratio,holder_major_busi,capital_scale,produce_scale,income_scale,holder_contact_no,marital_status,spouse_name,spouse_cert_type,spouse_cert_no,spouse_contact_no,sort_order,raw_add_time) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)</tt>
	 *
	 *	@param FInvestigationMainlyReviewStockholder
	 *	@return long
	 *	@throws DataAccessException
	 */	 
    public long insert(FInvestigationMainlyReviewStockholderDO FInvestigationMainlyReviewStockholder) throws DataAccessException;

	/**
	 *  Update DB table <tt>f_investigation_mainly_review_stockholder</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>update f_investigation_mainly_review_stockholder set m_review_id=?, holder_name=?, holder_type=?, holder_cert_type=?, holder_cert_no=?, actual_investment=?, paidin_capital_ratio=?, holder_major_busi=?, capital_scale=?, produce_scale=?, income_scale=?, holder_contact_no=?, marital_status=?, spouse_name=?, spouse_cert_type=?, spouse_cert_no=?, spouse_contact_no=?, sort_order=? where (id = ?)</tt>
	 *
	 *	@param FInvestigationMainlyReviewStockholder
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int update(FInvestigationMainlyReviewStockholderDO FInvestigationMainlyReviewStockholder) throws DataAccessException;

	/**
	 *  Query DB table <tt>f_investigation_mainly_review_stockholder</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select * from f_investigation_mainly_review_stockholder where (id = ?)</tt>
	 *
	 *	@param id
	 *	@return FInvestigationMainlyReviewStockholderDO
	 *	@throws DataAccessException
	 */	 
    public FInvestigationMainlyReviewStockholderDO findById(long id) throws DataAccessException;

	/**
	 *  Query DB table <tt>f_investigation_mainly_review_stockholder</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select * from f_investigation_mainly_review_stockholder where (m_review_id = ?) order by sort_order ASC</tt>
	 *
	 *	@param MReviewId
	 *	@return List<FInvestigationMainlyReviewStockholderDO>
	 *	@throws DataAccessException
	 */	 
    public List<FInvestigationMainlyReviewStockholderDO> findByReviewId(long MReviewId) throws DataAccessException;

	/**
	 *  Delete records from DB table <tt>f_investigation_mainly_review_stockholder</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>delete from f_investigation_mainly_review_stockholder where (id = ?)</tt>
	 *
	 *	@param id
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int deleteById(long id) throws DataAccessException;

	/**
	 *  Delete records from DB table <tt>f_investigation_mainly_review_stockholder</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>delete from f_investigation_mainly_review_stockholder where (m_review_id = ?)</tt>
	 *
	 *	@param MReviewId
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int deleteByReviewId(long MReviewId) throws DataAccessException;

}