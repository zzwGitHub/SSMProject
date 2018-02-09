package com.ziw.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class DBHelper extends JdbcDaoSupport{

	private static Logger errorLog = LoggerFactory.getLogger(DBHelper.class);
	
	/**
	 * @Describe: 获取记录行数,带参数
	 * @Created on: 2016-04-27
	 * @return
	 */

	public Integer queryCount(String sql, Object... parms) {
		
		try {
			
			return getJdbcTemplate().queryForObject(sql, parms, Integer.class);
		} catch (Exception e) {
			errorLog.error("ERROR: queryCount查询时发生异常，异常信息：" + e.getMessage() + " SQL: \n" + sql);
		}
		return 0;
	}
	/**
	 * @Describe: 获取记录行数,无参数
	 * @Created on: 2016-04-27
	 * @return
	 */

	public Integer queryCount(String sql) {
		try {
			
			return getJdbcTemplate().queryForObject(sql,Integer.class);
		} catch (Exception e) {
			errorLog.error("ERROR: queryCount查询时发生异常，异常信息：" + e.getMessage() + " SQL: \n" + sql);
		}
		return 0;
	}
	

	/**
	 * @Describe: 根据参数查询记录信息
	 * @Created on: 2016-04-27
	 * @return
	 */
	public List<Map<String, Object>> queryForList(String sql, Object... parms) {
		try {
			return getJdbcTemplate().queryForList(sql, parms);
		} catch (Exception e) {
			errorLog.error("ERROR: queryForList发生异常，异常信息：" + e.getMessage() + " SQL: \n" + sql);
		}
		return null;
	}

	/**
	 * @Describe: 无参数获取所有记录信息
	 * @Created on: 2016-04-27
	 * @return
	 */
	public List<Map<String, Object>> queryForList(String sql) {
		try {
			return getJdbcTemplate().queryForList(sql);
		} catch (Exception e) {
			errorLog.error("ERROR: queryForList查询时发生异常，异常信息：" + e.getMessage() + " SQL: \n" + sql);
		}
		return null;
	}

	/**
	 * @Describe:分页查询获得返回结果
	 * @Created on: 2016-04-27
	 * @return
	 */
	public List<Map<String, Object>> queryForList(String sql, int startRow, int lastRow, String sortname, String sortorder, Object... parms) {
		try {
			sql = "SELECT * FROM (SELECT t.*, ROWNUM RN FROM (" + sql + ") t " + "WHERE ROWNUM <= " + lastRow + ") WHERE RN > " + startRow;
			if (sortorder != null) {
				sql += " ORDER BY " + sortname + " " + sortorder;
			}
			return getJdbcTemplate().queryForList(sql, parms);
		} catch (Exception e) {
			errorLog.error("ERROR: 进行SQL查询时发生异常，异常信息：" + e.getMessage() + " SQL: \n" + sql);
		}
		return null;
	}

	/**
	 * @Describe:数据库修改
	 * @Created on:2016-04-27
	 * @return >0 表示修改成功， 否则失败
	 */
	public int update(String sql, Object... parms) {
		try {
			return getJdbcTemplate().update(sql, parms);
		} catch (Exception e) {
			errorLog.error("ERROR:update修改时发生异常,异常信息:" + e.getMessage() + "SQL:\n" + sql);
		}
		return 0;
	}

	/**
	 * @Describe: 根据条件查询，返回一条数据，比如根据ID查询
	 * @Created on: 2016-04-27
	 * @return
	 */
	public Map<String, Object> getObjectById(String sql, Object... parms) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			map = getJdbcTemplate().queryForMap(sql, parms);
		} catch (Exception e) {
			return null;
		}
		return map;
	}
	


}
