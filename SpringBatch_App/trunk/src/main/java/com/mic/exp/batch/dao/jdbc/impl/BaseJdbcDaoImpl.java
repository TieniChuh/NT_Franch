/*
 * Creation : 2014-3-24
 */
package com.mic.exp.batch.dao.jdbc.impl;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.activation.DataSource;

import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

import com.mic.exp.batch.dao.jdbc.BaseJdbcDao;

// TO DO
/**
 * The Class BaseJdbcDaoImpl.
 */
public class BaseJdbcDaoImpl extends NamedParameterJdbcDaoSupport implements BaseJdbcDao {

    /** The data source. */
    private DataSource dataSource;

    /**
     * {@inheritDoc}
     * 
     * @see org.springframework.jdbc.core.support.JdbcDaoSupport#setDataSource(javax.sql.DataSource)
     */
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.mic.exp.db.dao.jdbc.BaseJdbcDao#executeSqlQuery(java.lang.String)
     */
    public Collection<Map<String, Object>> executeSqlQuery(String sqlQuery) {
        logger.debug("Debut sql");
        logger.debug("sqlQuery :" + sqlQuery);
        // List<Map<String, Object>> resultList =
        // super.getNamedParameterJdbcTemplate().queryForList(sqlQuery, new
        // HashMap<String, Object>());

        List<HashMap<String, Object>> resTmp = getJdbcTemplate().query(sqlQuery, new HashMapRowMapper());

        Collection<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
        resultList.addAll(resTmp);
        logger.debug("fin sql");
        return resultList;
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.mic.exp.db.dao.jdbc.BaseJdbcDao#commit()
     */
    @Override
    public void commit() throws CannotGetJdbcConnectionException, SQLException {
        if (getConnection().getAutoCommit()) {
            getConnection().setAutoCommit(false);
        }
        getConnection().commit();
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.mic.exp.db.dao.jdbc.BaseJdbcDao#rollback()
     */
    @Override
    public void rollback() throws CannotGetJdbcConnectionException, SQLException {
        if (getConnection().getAutoCommit()) {
            getConnection().setAutoCommit(false);
        }
        getConnection().rollback();
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.mic.exp.db.dao.jdbc.BaseJdbcDao#execute(java.lang.String)
     */
    @Override
    public void execute(String sql) {
        getJdbcTemplate().execute(sql);
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.mic.exp.db.dao.jdbc.BaseJdbcDao#update(java.lang.String, java.lang.Object[])
     */
    @Override
    public int update(String sql, Object... args) {
        return getJdbcTemplate().update(sql, args);
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.mic.exp.db.dao.jdbc.BaseJdbcDao#queryForObject(java.lang.String, java.lang.Class, java.lang.Object[])
     */
    @Override
    public <T> T queryForObject(String sql, Class<T> requiredType, Object... args) {
        return getJdbcTemplate().queryForObject(sql, requiredType, args);
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.mic.exp.db.dao.jdbc.BaseJdbcDao#queryForObject(java.lang.String, java.lang.Class)
     */
    @Override
    public <T> T queryForObject(String sql, Class<T> requiredType) {
        return getJdbcTemplate().queryForObject(sql, requiredType);
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.mic.exp.db.dao.jdbc.BaseJdbcDao#queryForList(java.lang.String, java.lang.Object[])
     */
    @Override
    public List<Map<String, Object>> queryForList(String sql, Object... args) {
        return getJdbcTemplate().queryForList(sql, args);

    }

    @Override
    public List<Map<String, Object>> queryForList(String sql) {
        return getJdbcTemplate().queryForList(sql);

    }

    /**
     * {@inheritDoc}
     * 
     * @see com.mic.exp.db.dao.jdbc.BaseJdbcDao#queryForMap(java.lang.String, java.lang.Object[])
     */
    @Override
    public Map<String, Object> queryForMap(String sql, Object... args) {
        return getJdbcTemplate().queryForMap(sql, args);
    }

    /**
     * The Class HashMapRowMapper.
     */
    protected class HashMapRowMapper implements RowMapper<HashMap<String, Object>> {

        /**
         * mapRow.
         * 
         * @param rs ResultSet
         * @param rowNum int
         * @return ViewSearchMandate
         * @throws SQLException SQLException
         */
        public HashMap<String, Object> mapRow(ResultSet rs, int rowNum) throws SQLException {
            ResultSetMetaData meta = rs.getMetaData();
            HashMap<String, Object> map = new HashMap<String, Object>();
            for (int i = 1; i <= meta.getColumnCount(); i++) {
                String name = meta.getColumnName(i);
                map.put(name, rs.getObject(name));
            }
            return map;
        }
    }
}
