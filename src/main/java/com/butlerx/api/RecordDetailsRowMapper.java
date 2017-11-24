package com.butlerx.api;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.butlerx.admin.model.RecordDetails;

public class RecordDetailsRowMapper implements RowMapper<RecordDetails> {

	/* (non-Javadoc)
	 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
	 */
	@Override
	public RecordDetails mapRow(ResultSet rs, int rowIndex) throws SQLException {
		RecordDetails details = new RecordDetails();
		details.setId(rs.getString(0));
		return details;
	}
	

}
