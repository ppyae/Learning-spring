package com.ppa.jdbc.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.ppa.jdbc.dto.Member;

public class MemberDao {

	private JdbcTemplate template;

	public MemberDao(JdbcTemplate template) {
		super();
		this.template = template;
	}
	
	public void create(Member member) {
		template.update(
				"insert into member values (?,?,?,?)", 
				member.getLoginId(),
				member.getName(),
				member.getPhone(),
				member.getEmail());
	}
}
