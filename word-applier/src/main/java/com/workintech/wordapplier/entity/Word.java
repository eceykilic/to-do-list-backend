package com.workintech.wordapplier.entity;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Word {

    private Long id;
    private String writer;
    private String description;

}
