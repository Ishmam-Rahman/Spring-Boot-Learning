package com.learnspringboot.All.In.One.Boot.Dao;

import com.learnspringboot.All.In.One.Boot.Model.Members;
import java.util.List;
import org.springframework.http.HttpStatus;

public interface MembersDao {
  public List<Members> getAllMembers();

  public Members getMemberById(Long id);

  public Members saveMember(Members members);

  public Members updateMember(Members members);

  public HttpStatus deleteMember(Long id);
}
