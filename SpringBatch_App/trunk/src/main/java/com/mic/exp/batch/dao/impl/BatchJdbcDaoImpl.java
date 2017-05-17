/*
 * Creation  2014-05-15
 */
package com.mic.exp.batch.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.util.CollectionUtils;

import com.mic.exp.batch.dao.BatchDao;
import com.mic.exp.batch.dao.jdbc.impl.BaseJdbcDaoImpl;
import com.mic.exp.batch.model.Batch;

/**
 * The Class BatchJdbcDaoImpl.
 */
public class BatchJdbcDaoImpl extends BaseJdbcDaoImpl implements BatchDao {

    /**
     * {@inheritDoc}
     * 
     * @see com.mic.exp.batch.dao.BatchDao#findByName(java.lang.String)
     */
    @Override
    public Batch findByName(String name) {
        final String sql = "SELECT * FROM MIOQTLB0 WHERE LB_NOM = ? ";
        Object[] params = new Object[1];
        params[0] = name;
        List<Batch> list = getJdbcTemplate().query(sql, params, detailMapper);
        Batch result = null;
        if (!CollectionUtils.isEmpty(list)) {
            result = list.get(0);
        }
        return result;
    }

    /**
     * detail mapper.
     */
    protected static ParameterizedRowMapper<Batch> detailMapper = new ParameterizedRowMapper<Batch>() {
        public Batch mapRow(ResultSet rs, int rowNum) throws SQLException {
            Batch batch = new Batch();
            batch.setId(rs.getInt(1));
            batch.setLbNom(rs.getString(2));
            return batch;
        }
    };

}
