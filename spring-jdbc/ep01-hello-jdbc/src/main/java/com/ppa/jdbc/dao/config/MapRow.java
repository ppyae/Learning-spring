package com.ppa.jdbc.dao.config;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.ppa.jdbc.dto.Member;

@Component
public class MapRow implements RowMapper<Member> {

	@Override
	public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
		var m = new Member();
		m.setLoginId(rs.getString(1));
		m.setName(rs.getString(2));
		m.setPhone(rs.getString(3));
		m.setEmail(rs.getString(4));
		return m;
	}

}
