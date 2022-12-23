package com.example.Relations.service.requests;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateAuthorRequest {
    private String firstName;
    private String lastName;
  //  private Long id; dont want to set id by manual
}
