package com.example.LibrarySpringBoot.repository;

import com.example.LibrarySpringBoot.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@Repository
public class MemberRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Member> getAllMembers(){
        String sql = "select * from member";
        List<Member> members = jdbcTemplate.query(sql, new MemberRowMapper());
        return members;
    }

    public Member getMemberById(int memberId){
        String sql = "select * from member where member_id = ?";
        Member member = jdbcTemplate.queryForObject(sql, new MemberRowMapper(),memberId);
        return member;
    }

    public void saveNewMember(Member m){
        String sql = "insert into member values (?, ?, ?, ? , ?)";
        jdbcTemplate.update(sql, m.getMember_id(), m.getName(), m.getPhone_num(), m.getEmail(), new Date());
    }

    private class MemberRowMapper implements RowMapper<Member>{

        @Override
        public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
            Member m = new Member();
            m.setMember_id(rs.getInt(1));
            m.setName(rs.getString(2));
            m.setPhone_num(rs.getString(3));
            m.setEmail(rs.getString(4));
            m.setDate_joined(rs.getDate(5));
            return m;
        }
    }
}
