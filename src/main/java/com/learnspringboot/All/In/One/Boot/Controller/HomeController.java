package com.learnspringboot.All.In.One.Boot.Controller;

import com.learnspringboot.All.In.One.Boot.Model.Members;
import com.learnspringboot.All.In.One.Boot.Service.MemberService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class HomeController {

  private final MemberService memberService;

  @GetMapping("/")
  public String Home() {
    return "Home Page!!!";
  }

  @GetMapping("/member-list")
  public List<Members> UserList() {
    return memberService.getAllMembers();
  }

  @GetMapping("/member/{id}")
  public Members memberById(@PathVariable Long id) {
    return memberService.getMemberById(id);
  }

  @PostMapping("/create-member")
  public Members create(@RequestBody Members members) {
    return memberService.saveMember(members);
  }

  @PutMapping("/update-member")
  public Members update(@RequestBody Members members){
    return memberService.updateMember(members);
  }

  @DeleteMapping("/delete-member/{id}")
  public HttpStatus delete(@PathVariable("id") Long id){
    return memberService.deleteMember(id);
  }
}
