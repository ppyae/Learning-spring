package com.ppa.jdbc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ppa.jdbc.dto.Member;

@Repository
public class MemberDao {

	@Autowired
	private JdbcTemplate template;
	
	public void create(Member member) {
		template.update(
				"insert into member values (?,?,?,?)", 
				member.getLoginId(),
				member.getName(),
				member.getPhone(),
				member.getEmail());
	}
}
