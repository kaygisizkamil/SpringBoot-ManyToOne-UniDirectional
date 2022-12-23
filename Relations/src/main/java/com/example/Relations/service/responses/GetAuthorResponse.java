package com.example.Relations.service.responses;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAuthorResponse {
    //if you also need id you can add that in here to responses
    private Long id;
    private String firstName;
    private String lastName;


}
