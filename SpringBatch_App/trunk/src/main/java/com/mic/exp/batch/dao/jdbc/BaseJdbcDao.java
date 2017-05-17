/*
 * Creation : 2014-3-24
 */
package com.mic.exp.batch.dao.jdbc;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.CannotGetJdbcConnectionException;

/**
 * The interface BaseJdbcDao.
 */
public interface BaseJdbcDao {

	/**
	 * Execute sql query.
	 * 
	 * @param sqlQuery
	 *            the sql query
	 * @return the list
	 */
	public Collection<Map<String, Object>> executeSqlQuery(String sqlQuery);

	/**
	 * Commit.
	 * 
	 * @throws CannotGetJdbcConnectionException
	 *             the cannot get jdbc connection exception
	 * @throws SQLException
	 *             the sQL exception
	 */
	void commit() throws CannotGetJdbcConnectionException, SQLException;

	/**
	 * Rollback.
	 * 
	 * @throws CannotGetJdbcConnectionException
	 *             the cannot get jdbc connection exception
	 * @throws SQLException
	 *             the sQL exception
	 */
	void rollback() throws CannotGetJdbcConnectionException, SQLException;

	/**
	 * Execute.
	 * 
	 * @param sql
	 *            the sql
	 */
	void execute(String sql);

	/**
	 * Query for object.
	 * 
	 * @param <T>
	 *            the generic type
	 * @param sql
	 *            the sql
	 * @param requiredType
	 *            the required type
	 * @param args
	 *            the args
	 * @return the t
	 */
	<T> T queryForObject(String sql, Class<T> requiredType, Object... args);

	/**
	 * Update.
	 * 
	 * @param sql
	 *            the sql
	 * @param args
	 *            the args
	 * @return the int
	 */
	int update(String sql, Object... args);

	/**
	 * Query for list.
	 * 
	 * @param sql
	 *            the sql
	 * @param args
	 *            the args
	 * @return the list
	 */
	List<Map<String, Object>> queryForList(String sql, Object... args);

	/**
	 * Query for map.
	 * 
	 * @param sql
	 *            the sql
	 * @param args
	 *            the args
	 * @return the map
	 */
	Map<String, Object> queryForMap(String sql, Object... args);

	/**
	 * Query for object.
	 * 
	 * @param <T>
	 *            the generic type
	 * @param sql
	 *            the sql
	 * @param requiredType
	 *            the required type
	 * @return the t
	 */
	<T> T queryForObject(String sql, Class<T> requiredType);

	/**
	 * Query for list.
	 * 
	 * @param sql
	 *            the sql
	 * @return the list
	 */
	List<Map<String, Object>> queryForList(String sql);

}
