package com.example.firstpractice.controller;

import com.example.firstpractice.dto.ArticleForm;
import com.example.firstpractice.entity.Article;
import com.example.firstpractice.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Slf4j
@Controller
public class ArticleController {
    @Autowired //스프링부트가 미리 생성해 놓은 레파지토리 객체 주입(DI)
    private ArticleRepository articleRepository;
    @GetMapping("/articles/new")
    public String newArticleForm(){
        return "articles/new";
    }

    @GetMapping("/articles/{id}")
    public String show(@PathVariable Long id, Model model){
        log.info("id = " + id);
        //1. id를 조회해 데이터 가져오기
        Optional<Article> articleEntity = Optional.ofNullable(articleRepository.findById(id).orElse(null));
        // 2. 모델에 데이터 등록하기
        model.addAttribute("article", articleEntity);
        //3. 뷰 페이지 반환하기
        return "articles/show";
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form){
        log.info(form.toString());
//        System.out.println(form.toString());
        //1. DTO를 엔티티로 변환해준다.
        Article article = form.toEntity();
        log.info(article.toString());
//        System.out.println(article.toString());
        //2. 레파지터리로 엔티티를 DB에 저장해준다.
        Article saved = articleRepository.save(article);
        log.info(saved.toString());
//        System.out.println(saved.toString());
        return"";
    }
}
