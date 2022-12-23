package com.example.Relations.service.requests;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateBookRequest {
  //  private Long author_id; id update gereksiz sadece yazar degistirme eklendi ki bu da gereksiz ama olsun :D
    private String isbn;
    private String name;
    private Long author_id;
}
