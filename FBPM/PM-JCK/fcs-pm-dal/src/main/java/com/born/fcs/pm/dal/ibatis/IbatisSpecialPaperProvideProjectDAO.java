/**
 * www.yiji.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.born.fcs.pm.dal.ibatis;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import com.born.fcs.pm.dal.daointerface.SpecialPaperProvideProjectDAO;


// auto generated imports
import com.born.fcs.pm.dal.dataobject.SpecialPaperProvideProjectDO;
import org.springframework.dao.DataAccessException;
import java.util.List;
import java.util.Map;
	import java.util.HashMap;
	
/**
 * An ibatis based implementation of dao interface <tt>com.born.fcs.pm.dal.daointerface.SpecialPaperProvideProjectDAO</tt>.
 *
 * This file is generated by <tt>specialmer-dalgen</tt>, a DAL (Data Access Layer)
 * code generation utility specially developed for <tt>paygw</tt> project.
 * 
 * PLEASE DO NOT MODIFY THIS FILE MANUALLY, or else your modification may
 * be OVERWRITTEN by someone else. To modify the file, you should go to 
 * directory <tt>(project-home)/biz/dal/src/conf/dalgen</tt>, and 
 * find the corresponding configuration file (<tt>tables/special_paper_provide_project.xml</tt>). 
 * Modify the configuration file according to your needs, then run <tt>specialmer-dalgen</tt> 
 * to generate this file.
 *
 * @author peigen
 */ 
@SuppressWarnings({ "unchecked", "rawtypes" })

public class IbatisSpecialPaperProvideProjectDAO extends SqlMapClientDaoSupport implements SpecialPaperProvideProjectDAO {
	/**
	 *  Insert one <tt>SpecialPaperProvideProjectDO</tt> object to DB table <tt>special_paper_provide_project</tt>, return primary key
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>insert into special_paper_provide_project(receive_man_id,receive_man_name,provide_man_id,provide_man_name,project_code,project_name,receipt_place,receipt_man,pieces,profiles,raw_add_time) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)</tt>
	 *
	 *	@param specialPaperProvideProject
	 *	@return long
	 *	@throws DataAccessException
	 */	 
    public long insert(SpecialPaperProvideProjectDO specialPaperProvideProject) throws DataAccessException {
    	if (specialPaperProvideProject == null) {
    		throw new IllegalArgumentException("Can't insert a null data object into db.");
    	}
    	
        getSqlMapClientTemplate().insert("MS-SPECIAL-PAPER-PROVIDE-PROJECT-INSERT", specialPaperProvideProject);

        return specialPaperProvideProject.getId();
    }

	/**
	 *  Update DB table <tt>special_paper_provide_project</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>update special_paper_provide_project set receive_man_id=?, receive_man_name=?, provide_man_id=?, provide_man_name=?, project_code=?, project_name=?, receipt_place=?, receipt_man=?, pieces=?, profiles=? where (id = ?)</tt>
	 *
	 *	@param specialPaperProvideProject
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int update(SpecialPaperProvideProjectDO specialPaperProvideProject) throws DataAccessException {
    	if (specialPaperProvideProject == null) {
    		throw new IllegalArgumentException("Can't update by a null data object.");
    	}


        return getSqlMapClientTemplate().update("MS-SPECIAL-PAPER-PROVIDE-PROJECT-UPDATE", specialPaperProvideProject);
    }

	/**
	 *  Query DB table <tt>special_paper_provide_project</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select * from special_paper_provide_project where (id = ?)</tt>
	 *
	 *	@param id
	 *	@return SpecialPaperProvideProjectDO
	 *	@throws DataAccessException
	 */	 
    public SpecialPaperProvideProjectDO findById(long id) throws DataAccessException {
        Long param = new Long(id);

        return (SpecialPaperProvideProjectDO) getSqlMapClientTemplate().queryForObject("MS-SPECIAL-PAPER-PROVIDE-PROJECT-FIND-BY-ID", param);

    }

	/**
	 *  Delete records from DB table <tt>special_paper_provide_project</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>delete from special_paper_provide_project where (id = ?)</tt>
	 *
	 *	@param id
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int deleteById(long id) throws DataAccessException {
        Long param = new Long(id);

        return getSqlMapClientTemplate().delete("MS-SPECIAL-PAPER-PROVIDE-PROJECT-DELETE-BY-ID", param);
    }

	/**
	 *  Query DB table <tt>special_paper_provide_project</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select * from special_paper_provide_project where (1 = 1)</tt>
	 *
	 *	@param specialPaperProvideProject
	 *	@param limitStart
	 *	@param pageSize
	 *	@return List<SpecialPaperProvideProjectDO>
	 *	@throws DataAccessException
	 */	 
    public List<SpecialPaperProvideProjectDO> findByCondition(SpecialPaperProvideProjectDO specialPaperProvideProject, long limitStart, long pageSize) throws DataAccessException {
    	if (specialPaperProvideProject == null) {
    		throw new IllegalArgumentException("Can't select by a null data object.");
    	}

        Map param = new HashMap();

        param.put("specialPaperProvideProject", specialPaperProvideProject);
        param.put("limitStart", new Long(limitStart));
        param.put("pageSize", new Long(pageSize));

        return getSqlMapClientTemplate().queryForList("MS-SPECIAL-PAPER-PROVIDE-PROJECT-FIND-BY-CONDITION", param);

    }

	/**
	 *  Query DB table <tt>special_paper_provide_project</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select COUNT(*) from special_paper_provide_project where (1 = 1)</tt>
	 *
	 *	@param specialPaperProvideProject
	 *	@return long
	 *	@throws DataAccessException
	 */	 
    public long findByConditionCount(SpecialPaperProvideProjectDO specialPaperProvideProject) throws DataAccessException {
    	if (specialPaperProvideProject == null) {
    		throw new IllegalArgumentException("Can't select by a null data object.");
    	}


	    Long retObj = (Long) getSqlMapClientTemplate().queryForObject("MS-SPECIAL-PAPER-PROVIDE-PROJECT-FIND-BY-CONDITION-COUNT", specialPaperProvideProject);

		if (retObj == null) {
		    return 0;
		} else {
		    return retObj.longValue();
		}

    }

}