package com.crowleyworks.basicweb.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

public class BasicService {

	/*
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	*/
	public List<String> getMany() {
		//StringBuffer query = new StringBuffer("select id, message from new_table");
		//return jdbcTemplate.query(query.toString(), new BasicRowMapper());
		List<String> results = new ArrayList<String>();
		results.add("one");
		results.add("two");
		return results;
	}
	
	public static final class BasicRowMapper implements RowMapper<String> {

		@Override
		public String mapRow(ResultSet rs, int arg1) throws SQLException {
			return rs.getString("message");
		}
	}

}
