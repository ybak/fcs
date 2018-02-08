/**
 * www.yiji.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.born.fcs.pm.dal.daointerface;

// auto generated imports
import com.born.fcs.pm.dal.dataobject.FormMessageTempleteDO;
import org.springframework.dao.DataAccessException;
import java.util.List;

/**
 * A dao interface provides methods to access database table <tt>form_message_templete</tt>.
 *
 * This file is generated by <tt>specialmer-dalgen</tt>, a DAL (Data Access Layer)
 * code generation utility specially developed for <tt>paygw</tt> project.
 * 
 * PLEASE DO NOT MODIFY THIS FILE MANUALLY, or else your modification may
 * be OVERWRITTEN by someone else. To modify the file, you should go to 
 * directory <tt>(project-home)/biz/dal/src/conf/dalgen</tt>, and 
 * find the corresponding configuration file (<tt>tables/form_message_templete.xml</tt>). 
 * Modify the configuration file according to your needs, then run <tt>specialmer-dalgen</tt> 
 * to generate this file.
 *
 * @author peigen
 */
 @SuppressWarnings("rawtypes") 
public interface FormMessageTempleteDAO {
	/**
	 *  Insert one <tt>FormMessageTempleteDO</tt> object to DB table <tt>form_message_templete</tt>, return primary key
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>insert into form_message_templete(templete_id,form_code,type,subject,content_html,content_txt,is_send_site_message,is_send_mail,is_send_sms,with_audit_opinion,base_on,remark,raw_add_time) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)</tt>
	 *
	 *	@param formMessageTemplete
	 *	@return long
	 *	@throws DataAccessException
	 */	 
    public long insert(FormMessageTempleteDO formMessageTemplete) throws DataAccessException;

	/**
	 *  Update DB table <tt>form_message_templete</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>update form_message_templete set form_code=?, type=?, subject=?, content_html=?, content_txt=?, is_send_site_message=?, is_send_mail=?, is_send_sms=?, with_audit_opinion=?, base_on=?, remark=? where (templete_id = ?)</tt>
	 *
	 *	@param formMessageTemplete
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int update(FormMessageTempleteDO formMessageTemplete) throws DataAccessException;

	/**
	 *  Query DB table <tt>form_message_templete</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select * from form_message_templete where (templete_id = ?)</tt>
	 *
	 *	@param templeteId
	 *	@return FormMessageTempleteDO
	 *	@throws DataAccessException
	 */	 
    public FormMessageTempleteDO findById(long templeteId) throws DataAccessException;

	/**
	 *  Query DB table <tt>form_message_templete</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select * from form_message_templete where ((form_code = ?) AND (type = ?))</tt>
	 *
	 *	@param formCode
	 *	@param type
	 *	@return FormMessageTempleteDO
	 *	@throws DataAccessException
	 */	 
    public FormMessageTempleteDO findByFormCodeAndType(String formCode, String type) throws DataAccessException;

	/**
	 *  Delete records from DB table <tt>form_message_templete</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>delete from form_message_templete where (templete_id = ?)</tt>
	 *
	 *	@param templeteId
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int deleteById(long templeteId) throws DataAccessException;

	/**
	 *  Delete records from DB table <tt>form_message_templete</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>delete from form_message_templete where ((form_code = ?) AND (type = ?))</tt>
	 *
	 *	@param formCode
	 *	@param type
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int deleteByFormCodeAndType(String formCode, String type) throws DataAccessException;

	/**
	 *  Query DB table <tt>form_message_templete</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select * from form_message_templete where (1 = 1)</tt>
	 *
	 *	@param formMessageTemplete
	 *	@param sortCol
	 *	@param sortOrder
	 *	@param limitStart
	 *	@param pageSize
	 *	@return List<FormMessageTempleteDO>
	 *	@throws DataAccessException
	 */	 
    public List<FormMessageTempleteDO> findByCondition(FormMessageTempleteDO formMessageTemplete, String sortCol, String sortOrder, long limitStart, long pageSize) throws DataAccessException;

	/**
	 *  Query DB table <tt>form_message_templete</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select COUNT(*) from form_message_templete where (1 = 1)</tt>
	 *
	 *	@param formMessageTemplete
	 *	@return long
	 *	@throws DataAccessException
	 */	 
    public long findByConditionCount(FormMessageTempleteDO formMessageTemplete) throws DataAccessException;

}