package com.learnspringboot.All.In.One.Boot.Dao;

import com.learnspringboot.All.In.One.Boot.Model.Members;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MembersDaoImpl implements MembersDao {
  private final JdbcTemplate jdbcTemplate;

  @Override
  public List<Members> getAllMembers() {
    String sql = "SELECT user_id, name, age, deleted FROM members where deleted is false";
    return jdbcTemplate.query(sql, this::membersRowMap);
  }

  @Override
  public Members getMemberById(Long id) {
    String sql = "SELECT user_id, name, age, deleted FROM members where user_id = ?";
    return jdbcTemplate.queryForObject(sql, this::membersRowMap, id);
  }

  @Override
  public Members saveMember(Members members) {
    String sql = "INSERT INTO members(name, age) values(?,?)";
    // jdbcTemplate.update(sql, members.getName(), members.getAge());
    KeyHolder keyHolder = new GeneratedKeyHolder();

    jdbcTemplate.update(con -> {
      PreparedStatement stmnt = con.prepareStatement(sql, new String[] {"user_id"});
      stmnt.setString(1, members.getName());
      stmnt.setLong(2, members.getAge());
      return stmnt;
    }, keyHolder);
    members.setId(keyHolder.getKey().longValue());

    return members;
  }

  @Override
  public Members updateMember(Members members) {
    String sql = "update members set name=?, age=?, deleted=? where user_id = ?";
    jdbcTemplate.update(sql, members.getName(), members.getAge(), members.getDeleted(),
        members.getId());
    return members;
  }

  @Override
  public HttpStatus deleteMember(Long id) {

    String sql2 = "update members set deleted=? where user_id = ?";
    jdbcTemplate.update(sql2, Boolean.TRUE, id);
    return HttpStatus.OK;
  }

  private Members membersRowMap(ResultSet rs, int n) throws SQLException {
    Members members = new Members();
    members.setId(rs.getLong("user_id"));
    members.setName(rs.getString("name"));
    members.setAge(rs.getLong("age"));
    members.setDeleted(rs.getBoolean("deleted"));
    return members;
  }
}
