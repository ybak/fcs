/**
 * www.yiji.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.born.fcs.pm.dal.ibatis;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import com.born.fcs.pm.dal.daointerface.RecoverProjectDAO;


// auto generated imports
import com.born.fcs.pm.dal.dataobject.RecoverProjectDO;
import org.springframework.dao.DataAccessException;
import java.util.Date;
import java.util.List;
import java.util.Map;
	import java.util.HashMap;
	
/**
 * An ibatis based implementation of dao interface <tt>com.born.fcs.pm.dal.daointerface.RecoverProjectDAO</tt>.
 *
 * This file is generated by <tt>specialmer-dalgen</tt>, a DAL (Data Access Layer)
 * code generation utility specially developed for <tt>paygw</tt> project.
 * 
 * PLEASE DO NOT MODIFY THIS FILE MANUALLY, or else your modification may
 * be OVERWRITTEN by someone else. To modify the file, you should go to 
 * directory <tt>(project-home)/biz/dal/src/conf/dalgen</tt>, and 
 * find the corresponding configuration file (<tt>tables/recover_project.xml</tt>). 
 * Modify the configuration file according to your needs, then run <tt>specialmer-dalgen</tt> 
 * to generate this file.
 *
 * @author peigen
 */ 
@SuppressWarnings({ "unchecked", "rawtypes" })

public class IbatisRecoverProjectDAO extends SqlMapClientDaoSupport implements RecoverProjectDAO {
	/**
	 *  Insert one <tt>RecoverProjectDO</tt> object to DB table <tt>recover_project</tt>, return primary key
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>insert into recover_project(project_code,project_name,customer_id,customer_name,busi_manager_id,busi_manager_name,status,raw_add_time) values (?, ?, ?, ?, ?, ?, ?, ?)</tt>
	 *
	 *	@param recoverProject
	 *	@return long
	 *	@throws DataAccessException
	 */	 
    public long insert(RecoverProjectDO recoverProject) throws DataAccessException {
    	if (recoverProject == null) {
    		throw new IllegalArgumentException("Can't insert a null data object into db.");
    	}
    	
        getSqlMapClientTemplate().insert("MS-RECOVER-PROJECT-INSERT", recoverProject);

        return recoverProject.getRecoverId();
    }

	/**
	 *  Update DB table <tt>recover_project</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>update recover_project set project_code=?, project_name=?, customer_id=?, customer_name=?, busi_manager_id=?, busi_manager_name=?, status=? where (recover_id = ?)</tt>
	 *
	 *	@param recoverProject
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int update(RecoverProjectDO recoverProject) throws DataAccessException {
    	if (recoverProject == null) {
    		throw new IllegalArgumentException("Can't update by a null data object.");
    	}


        return getSqlMapClientTemplate().update("MS-RECOVER-PROJECT-UPDATE", recoverProject);
    }

	/**
	 *  Query DB table <tt>recover_project</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select * from recover_project where (recover_id = ?)</tt>
	 *
	 *	@param recoverId
	 *	@return RecoverProjectDO
	 *	@throws DataAccessException
	 */	 
    public RecoverProjectDO findById(long recoverId) throws DataAccessException {
        Long param = new Long(recoverId);

        return (RecoverProjectDO) getSqlMapClientTemplate().queryForObject("MS-RECOVER-PROJECT-FIND-BY-ID", param);

    }

	/**
	 *  Delete records from DB table <tt>recover_project</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>delete from recover_project where (recover_id = ?)</tt>
	 *
	 *	@param recoverId
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int deleteById(long recoverId) throws DataAccessException {
        Long param = new Long(recoverId);

        return getSqlMapClientTemplate().delete("MS-RECOVER-PROJECT-DELETE-BY-ID", param);
    }

	/**
	 *  Query DB table <tt>recover_project</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select * from recover_project where (1 = 1)</tt>
	 *
	 *	@param recoverProject
	 *	@param limitStart
	 *	@param pageSize
	 *	@param updateTimeBegin
	 *	@param updateTimeEnd
	 *	@return List<RecoverProjectDO>
	 *	@throws DataAccessException
	 */	 
    public List<RecoverProjectDO> findByCondition(RecoverProjectDO recoverProject, long limitStart, long pageSize, Date updateTimeBegin, Date updateTimeEnd) throws DataAccessException {
    	if (recoverProject == null) {
    		throw new IllegalArgumentException("Can't select by a null data object.");
    	}

        Map param = new HashMap();

        param.put("recoverProject", recoverProject);
        param.put("limitStart", new Long(limitStart));
        param.put("pageSize", new Long(pageSize));
        param.put("updateTimeBegin", updateTimeBegin);
        param.put("updateTimeEnd", updateTimeEnd);

        return getSqlMapClientTemplate().queryForList("MS-RECOVER-PROJECT-FIND-BY-CONDITION", param);

    }

	/**
	 *  Query DB table <tt>recover_project</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select COUNT(*) from recover_project where (1 = 1)</tt>
	 *
	 *	@param recoverProject
	 *	@return long
	 *	@throws DataAccessException
	 */	 
    public long findByConditionCount(RecoverProjectDO recoverProject) throws DataAccessException {
    	if (recoverProject == null) {
    		throw new IllegalArgumentException("Can't select by a null data object.");
    	}


	    Long retObj = (Long) getSqlMapClientTemplate().queryForObject("MS-RECOVER-PROJECT-FIND-BY-CONDITION-COUNT", recoverProject);

		if (retObj == null) {
		    return 0;
		} else {
		    return retObj.longValue();
		}

    }

}