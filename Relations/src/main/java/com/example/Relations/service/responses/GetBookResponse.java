package com.example.Relations.service.responses;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetBookResponse {
    private Long author_id;
    private String isbn;
    private String name;
    private Long id;
}
