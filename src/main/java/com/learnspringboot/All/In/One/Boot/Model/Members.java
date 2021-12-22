package com.learnspringboot.All.In.One.Boot.Model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class Members {
  private Long id;
  private String name;
  private Long age;
  private Boolean deleted;
}
