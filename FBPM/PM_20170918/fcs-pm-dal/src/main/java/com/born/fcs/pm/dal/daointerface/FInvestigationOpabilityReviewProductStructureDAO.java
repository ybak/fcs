/**
 * www.yiji.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.born.fcs.pm.dal.daointerface;

// auto generated imports
import com.born.fcs.pm.dal.dataobject.FInvestigationOpabilityReviewProductStructureDO;
import org.springframework.dao.DataAccessException;
import java.util.List;

/**
 * A dao interface provides methods to access database table <tt>f_investigation_opability_review_product_structure</tt>.
 *
 * This file is generated by <tt>specialmer-dalgen</tt>, a DAL (Data Access Layer)
 * code generation utility specially developed for <tt>paygw</tt> project.
 * 
 * PLEASE DO NOT MODIFY THIS FILE MANUALLY, or else your modification may
 * be OVERWRITTEN by someone else. To modify the file, you should go to 
 * directory <tt>(project-home)/biz/dal/src/conf/dalgen</tt>, and 
 * find the corresponding configuration file (<tt>tables/f_investigation_opability_review_product_structure.xml</tt>). 
 * Modify the configuration file according to your needs, then run <tt>specialmer-dalgen</tt> 
 * to generate this file.
 *
 * @author peigen
 */
 @SuppressWarnings("rawtypes") 
public interface FInvestigationOpabilityReviewProductStructureDAO {
	/**
	 *  Insert one <tt>FInvestigationOpabilityReviewProductStructureDO</tt> object to DB table <tt>f_investigation_opability_review_product_structure</tt>, return primary key
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>insert into f_investigation_opability_review_product_structure(op_review_id,name,report_period1,report_period2,report_period3,income1,income2,income3,income_ratio1,income_ratio2,income_ratio3,sort_order,raw_add_time) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)</tt>
	 *
	 *	@param FInvestigationOpabilityReviewProductStructure
	 *	@return long
	 *	@throws DataAccessException
	 */	 
    public long insert(FInvestigationOpabilityReviewProductStructureDO FInvestigationOpabilityReviewProductStructure) throws DataAccessException;

	/**
	 *  Update DB table <tt>f_investigation_opability_review_product_structure</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>update f_investigation_opability_review_product_structure set op_review_id=?, name=?, report_period1=?, report_period2=?, report_period3=?, income1=?, income2=?, income3=?, income_ratio1=?, income_ratio2=?, income_ratio3=?, sort_order=? where (id = ?)</tt>
	 *
	 *	@param FInvestigationOpabilityReviewProductStructure
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int update(FInvestigationOpabilityReviewProductStructureDO FInvestigationOpabilityReviewProductStructure) throws DataAccessException;

	/**
	 *  Query DB table <tt>f_investigation_opability_review_product_structure</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select * from f_investigation_opability_review_product_structure where (id = ?)</tt>
	 *
	 *	@param id
	 *	@return FInvestigationOpabilityReviewProductStructureDO
	 *	@throws DataAccessException
	 */	 
    public FInvestigationOpabilityReviewProductStructureDO findById(long id) throws DataAccessException;

	/**
	 *  Query DB table <tt>f_investigation_opability_review_product_structure</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select * from f_investigation_opability_review_product_structure where (op_review_id = ?) order by sort_order ASC</tt>
	 *
	 *	@param opReviewId
	 *	@return List<FInvestigationOpabilityReviewProductStructureDO>
	 *	@throws DataAccessException
	 */	 
    public List<FInvestigationOpabilityReviewProductStructureDO> findByReviewId(long opReviewId) throws DataAccessException;

	/**
	 *  Delete records from DB table <tt>f_investigation_opability_review_product_structure</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>delete from f_investigation_opability_review_product_structure where (id = ?)</tt>
	 *
	 *	@param id
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int deleteById(long id) throws DataAccessException;

	/**
	 *  Delete records from DB table <tt>f_investigation_opability_review_product_structure</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>delete from f_investigation_opability_review_product_structure where (op_review_id = ?)</tt>
	 *
	 *	@param opReviewId
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int deleteByReviewId(long opReviewId) throws DataAccessException;

}