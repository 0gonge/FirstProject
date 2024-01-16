package com.example.firstpractice.dto;

import com.example.firstpractice.entity.Article;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class ArticleForm {
    private Long id;
    private String title;
    private String contents;

    //전송받은 제목, 내용을 필드에 저장하는 생성자 Constructor
    //데이터를 잘 받았는지 확인 : toString()생성자

    public Article toEntity() {

        return new Article(id, title, contents);
    }
}
