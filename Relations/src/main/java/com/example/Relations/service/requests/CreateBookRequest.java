package com.example.Relations.service.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBookRequest {
   // private Long id;
    private Long author_id;
    private String isbn;
    private String name;
}
