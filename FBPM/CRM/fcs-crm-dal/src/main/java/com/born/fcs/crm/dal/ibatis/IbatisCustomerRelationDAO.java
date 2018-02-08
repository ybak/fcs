/**
 * www.yiji.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.born.fcs.crm.dal.ibatis;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import com.born.fcs.crm.dal.daointerface.CustomerRelationDAO;


// auto generated imports
import com.born.fcs.crm.dal.dataobject.CustomerRelationDO;
import org.springframework.dao.DataAccessException;
import java.util.List;
import java.util.Map;
	import java.util.HashMap;
	
/**
 * An ibatis based implementation of dao interface <tt>com.born.fcs.crm.dal.daointerface.CustomerRelationDAO</tt>.
 *
 * This file is generated by <tt>specialmer-dalgen</tt>, a DAL (Data Access Layer)
 * code generation utility specially developed for <tt>paygw</tt> project.
 * 
 * PLEASE DO NOT MODIFY THIS FILE MANUALLY, or else your modification may
 * be OVERWRITTEN by someone else. To modify the file, you should go to 
 * directory <tt>(project-home)/biz/dal/src/conf/dalgen</tt>, and 
 * find the corresponding configuration file (<tt>tables/customer_relation.xml</tt>). 
 * Modify the configuration file according to your needs, then run <tt>specialmer-dalgen</tt> 
 * to generate this file.
 *
 * @author peigen
 */ 
@SuppressWarnings({ "unchecked", "rawtypes" })

public class IbatisCustomerRelationDAO extends SqlMapClientDaoSupport implements CustomerRelationDAO {
	/**
	 *  Insert one <tt>CustomerRelationDO</tt> object to DB table <tt>customer_relation</tt>, return primary key
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>insert into customer_relation(relation_id,user_id,customer_manager_id,customer_manager,director_id,director,dep_id,dep_name,dep_path,oper_id,oper_name,raw_add_time) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)</tt>
	 *
	 *	@param customerRelation
	 *	@return long
	 *	@throws DataAccessException
	 */	 
    public long insert(CustomerRelationDO customerRelation) throws DataAccessException {
    	if (customerRelation == null) {
    		throw new IllegalArgumentException("Can't insert a null data object into db.");
    	}
    	
        getSqlMapClientTemplate().insert("MS-CUSTOMER-RELATION-INSERT", customerRelation);

        return customerRelation.getRelationId();
    }

	/**
	 *  Query DB table <tt>customer_relation</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select relation_id, user_id, customer_manager_id, customer_manager, director_id, director, dep_id, dep_name, dep_path, oper_id, oper_name, raw_add_time, raw_update_time from customer_relation where (relation_id = ?)</tt>
	 *
	 *	@param relationId
	 *	@return CustomerRelationDO
	 *	@throws DataAccessException
	 */	 
    public CustomerRelationDO findById(long relationId) throws DataAccessException {
        Long param = new Long(relationId);

        return (CustomerRelationDO) getSqlMapClientTemplate().queryForObject("MS-CUSTOMER-RELATION-FIND-BY-ID", param);

    }

	/**
	 *  Query DB table <tt>customer_relation</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select relation_id, user_id, customer_manager_id, customer_manager, director_id, director, dep_id, dep_name, dep_path, oper_id, oper_name, raw_add_time, raw_update_time from customer_relation where (user_id = ?)</tt>
	 *
	 *	@param userId
	 *	@return List<CustomerRelationDO>
	 *	@throws DataAccessException
	 */	 
    public List<CustomerRelationDO> findByUserId(long userId) throws DataAccessException {
        Long param = new Long(userId);

        return getSqlMapClientTemplate().queryForList("MS-CUSTOMER-RELATION-FIND-BY-USER-ID", param);

    }

	/**
	 *  Query DB table <tt>customer_relation</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select relation_id, user_id, customer_manager_id, customer_manager, director_id, director, dep_id, dep_name, dep_path, oper_id, oper_name, raw_add_time, raw_update_time from customer_relation where ((user_id = ?) AND (customer_manager_id = ?))</tt>
	 *
	 *	@param userId
	 *	@param customerManagerId
	 *	@return List<CustomerRelationDO>
	 *	@throws DataAccessException
	 */	 
    public List<CustomerRelationDO> findByUserAndManagerId(long userId, long customerManagerId) throws DataAccessException {
        Map param = new HashMap();

        param.put("userId", new Long(userId));
        param.put("customerManagerId", new Long(customerManagerId));

        return getSqlMapClientTemplate().queryForList("MS-CUSTOMER-RELATION-FIND-BY-USER-AND-MANAGER-ID", param);

    }

	/**
	 *  Delete records from DB table <tt>customer_relation</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>delete from customer_relation where (relation_id = ?)</tt>
	 *
	 *	@param relationId
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int deleteById(long relationId) throws DataAccessException {
        Long param = new Long(relationId);

        return getSqlMapClientTemplate().delete("MS-CUSTOMER-RELATION-DELETE-BY-ID", param);
    }

	/**
	 *  Delete records from DB table <tt>customer_relation</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>delete from customer_relation where (user_id = ?)</tt>
	 *
	 *	@param userId
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int deleteByUserId(long userId) throws DataAccessException {
        Long param = new Long(userId);

        return getSqlMapClientTemplate().delete("MS-CUSTOMER-RELATION-DELETE-BY-USER-ID", param);
    }

	/**
	 *  Delete records from DB table <tt>customer_relation</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>delete from customer_relation where ((user_id = ?) AND (customer_manager_id = ?))</tt>
	 *
	 *	@param userId
	 *	@param customerManagerId
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int deleteByUserAndManagerId(long userId, long customerManagerId) throws DataAccessException {
        Map param = new HashMap();

        param.put("userId", new Long(userId));
        param.put("customerManagerId", new Long(customerManagerId));

        return getSqlMapClientTemplate().delete("MS-CUSTOMER-RELATION-DELETE-BY-USER-AND-MANAGER-ID", param);
    }

	/**
	 *  Update DB table <tt>customer_relation</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>update customer_relation set user_id=?, customer_manager_id=?, customer_manager=?, director_id=?, director=?, dep_id=?, dep_name=?, dep_path=?, oper_id=?, oper_name=? where (relation_id = ?)</tt>
	 *
	 *	@param customerRelation
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int updateId(CustomerRelationDO customerRelation) throws DataAccessException {
    	if (customerRelation == null) {
    		throw new IllegalArgumentException("Can't update by a null data object.");
    	}


        return getSqlMapClientTemplate().update("MS-CUSTOMER-RELATION-UPDATE-ID", customerRelation);
    }

	/**
	 *  Query DB table <tt>customer_relation</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select relation_id, user_id, customer_manager_id, customer_manager, director_id, director, dep_id, dep_name, dep_path, oper_id, oper_name, raw_add_time, raw_update_time from customer_relation</tt>
	 *
	 *	@param customerRelation
	 *	@param limitStart
	 *	@param pageSize
	 *	@return List<CustomerRelationDO>
	 *	@throws DataAccessException
	 */	 
    public List<CustomerRelationDO> findWithCondition(CustomerRelationDO customerRelation, long limitStart, long pageSize) throws DataAccessException {
    	if (customerRelation == null) {
    		throw new IllegalArgumentException("Can't select by a null data object.");
    	}

        Map param = new HashMap();

        param.put("customerRelation", customerRelation);
        param.put("limitStart", new Long(limitStart));
        param.put("pageSize", new Long(pageSize));

        return getSqlMapClientTemplate().queryForList("MS-CUSTOMER-RELATION-FIND-WITH-CONDITION", param);

    }

	/**
	 *  Query DB table <tt>customer_relation</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select COUNT(*) from customer_relation</tt>
	 *
	 *	@param customerRelation
	 *	@return long
	 *	@throws DataAccessException
	 */	 
    public long countWithCondition(CustomerRelationDO customerRelation) throws DataAccessException {
    	if (customerRelation == null) {
    		throw new IllegalArgumentException("Can't select by a null data object.");
    	}


	    Long retObj = (Long) getSqlMapClientTemplate().queryForObject("MS-CUSTOMER-RELATION-COUNT-WITH-CONDITION", customerRelation);

		if (retObj == null) {
		    return 0;
		} else {
		    return retObj.longValue();
		}

    }

}