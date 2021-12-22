package com.learnspringboot.All.In.One.Boot.Service;

import com.learnspringboot.All.In.One.Boot.Dao.MembersDao;
import com.learnspringboot.All.In.One.Boot.Model.Members;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MemberServiceImpl
    implements MemberService {

  private final MembersDao membersDao;

  @Override
  public List<Members> getAllMembers() {
    return membersDao.getAllMembers();
  }

  @Override
  public Members getMemberById(Long id) {
    return membersDao.getMemberById(id);
  }

  @Override
  public Members updateMember(Members members) {
    return membersDao.updateMember(members);
  }

  @Override
  public HttpStatus deleteMember(Long id) {
    return membersDao.deleteMember(id);
  }

  @Override
  public Members saveMember(Members members) {
    return membersDao.saveMember(members);
  }
}
