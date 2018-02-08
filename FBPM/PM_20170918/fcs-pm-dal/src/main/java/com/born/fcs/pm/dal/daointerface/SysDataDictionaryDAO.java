/**
 * www.yiji.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.born.fcs.pm.dal.daointerface;

// auto generated imports
import com.born.fcs.pm.dal.dataobject.SysDataDictionaryDO;
import org.springframework.dao.DataAccessException;
import java.util.List;

/**
 * A dao interface provides methods to access database table <tt>sys_data_dictionary</tt>.
 *
 * This file is generated by <tt>specialmer-dalgen</tt>, a DAL (Data Access Layer)
 * code generation utility specially developed for <tt>paygw</tt> project.
 * 
 * PLEASE DO NOT MODIFY THIS FILE MANUALLY, or else your modification may
 * be OVERWRITTEN by someone else. To modify the file, you should go to 
 * directory <tt>(project-home)/biz/dal/src/conf/dalgen</tt>, and 
 * find the corresponding configuration file (<tt>tables/sys_data_dictionary.xml</tt>). 
 * Modify the configuration file according to your needs, then run <tt>specialmer-dalgen</tt> 
 * to generate this file.
 *
 * @author peigen
 */
 @SuppressWarnings("rawtypes") 
public interface SysDataDictionaryDAO {
	/**
	 *  Insert one <tt>SysDataDictionaryDO</tt> object to DB table <tt>sys_data_dictionary</tt>, return primary key
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>insert into sys_data_dictionary(id,parent_id,data_code,data_value,data_value1,data_value2,data_value3,children_num,sort_order,raw_add_time) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)</tt>
	 *
	 *	@param sysDataDictionary
	 *	@return long
	 *	@throws DataAccessException
	 */	 
    public long insert(SysDataDictionaryDO sysDataDictionary) throws DataAccessException;

	/**
	 *  Update DB table <tt>sys_data_dictionary</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>update sys_data_dictionary set parent_id=?, data_code=?, data_value=?, data_value1=?, data_value2=?, data_value3=?, children_num=?, sort_order=? where (id = ?)</tt>
	 *
	 *	@param sysDataDictionary
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int update(SysDataDictionaryDO sysDataDictionary) throws DataAccessException;

	/**
	 *  Query DB table <tt>sys_data_dictionary</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select * from sys_data_dictionary where (id = ?)</tt>
	 *
	 *	@param id
	 *	@return SysDataDictionaryDO
	 *	@throws DataAccessException
	 */	 
    public SysDataDictionaryDO findById(long id) throws DataAccessException;

	/**
	 *  Query DB table <tt>sys_data_dictionary</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select * from sys_data_dictionary where (data_code = ?)</tt>
	 *
	 *	@param dataCode
	 *	@return List<SysDataDictionaryDO>
	 *	@throws DataAccessException
	 */	 
    public List<SysDataDictionaryDO> findByDataCode(String dataCode) throws DataAccessException;

	/**
	 *  Query DB table <tt>sys_data_dictionary</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select * from sys_data_dictionary where ((data_code = ?) AND (parent_id = 0))</tt>
	 *
	 *	@param dataCode
	 *	@return List<SysDataDictionaryDO>
	 *	@throws DataAccessException
	 */	 
    public List<SysDataDictionaryDO> findByDataCodeNoChild(String dataCode) throws DataAccessException;

	/**
	 *  Query DB table <tt>sys_data_dictionary</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select * from sys_data_dictionary where (parent_id = ?)</tt>
	 *
	 *	@param parentId
	 *	@return List<SysDataDictionaryDO>
	 *	@throws DataAccessException
	 */	 
    public List<SysDataDictionaryDO> findByParentId(long parentId) throws DataAccessException;

	/**
	 *  Delete records from DB table <tt>sys_data_dictionary</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>delete from sys_data_dictionary where (id = ?)</tt>
	 *
	 *	@param id
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int deleteById(long id) throws DataAccessException;

	/**
	 *  Delete records from DB table <tt>sys_data_dictionary</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>delete from sys_data_dictionary where (parent_id = ?)</tt>
	 *
	 *	@param parentId
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int deleteByParentId(long parentId) throws DataAccessException;

	/**
	 *  Delete records from DB table <tt>sys_data_dictionary</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>delete from sys_data_dictionary where (data_code = ?)</tt>
	 *
	 *	@param dataCode
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int deleteByDataCode(String dataCode) throws DataAccessException;

}