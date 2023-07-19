package com.example.moduleadmin.controller;

import com.example.moduleadmin.dto.ArticleDto;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import java.util.List;


/**
 * 관리자 회원 게시글 CRUD 관리 Controller
 */
@RequestMapping("/api/admin")
@Controller
public class ArticleManagementController {

    /**
     * 게시글 목록 보기
     */
    @GetMapping("articles")
    public String getArticle(Model model){

        /**
         * url은 8080에서 게시글 데이터를 주는 api 주소
         */
        String url = "http://localhost:8080/~~~~";

        /**
         * RestTemplate
         * 두 개의 다른 포트를 가진 서버에서 api호출을 가능하게 하는 도구.
         */
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity request = new HttpEntity(httpHeaders);

        ResponseEntity<List> res = restTemplate.exchange(
                url,
                HttpMethod.GET,
                request,
                List.class
        );

        List<ArticleDto> dto =res.getBody();
        model.addAttribute("articles",dto);

        return "articles";
    }

    /**
     *  게시글 삭제
     *  삭제 실행되면 해당 게시글의 id와 함께 http://localhost:8081/api/admin/delete/article/1 이렇게 넘겨준다.
     *  삭제가 완료되면 200 status
     */

    @GetMapping("/delete/article/{id}")
    public ResponseEntity<?> deleteArticle(@RequestParam("id") Long id){
        String url = "http://localhost:8080/~~~";

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity request = new HttpEntity(httpHeaders);

        ResponseEntity<Void> res = restTemplate.exchange(
                url,
                HttpMethod.DELETE,
                request,
                Void.class
        );
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    /**
     * 게시글 숨기기, 보이기 기능
     * 게시글 엔티티에 hidden이라는 boolean 타입의 필드값을 추가
     * 관리자가 해당 hidden 값을 true로 할 건지 false로 할 건지 결정하면 됨.
     * true : 게시글은 있지만 유저들에게 보이지 않는다.
     * false : 유저들에게 게시글이 보인다.
     */

    /**
     * 게시글 숨기기
     */
    @GetMapping("/hide/article/{id}")
    public ResponseEntity<?> hideArticle(@RequestParam("id") Long id){
        String url = "http://localhost:8080/~~~~";

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity request = new HttpEntity(httpHeaders);

        ResponseEntity<Void> res = restTemplate.exchange(
                url,
                HttpMethod.PUT,
                request,
                Void.class
        );
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    /**
     * 게시글 보이기
     */
    @GetMapping("/open/article/{id}")
    public ResponseEntity<?> hideArticle(@RequestParam("id") Long id){
        String url = "http://localhost:8080/~~~~";

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity request = new HttpEntity(httpHeaders);

        ResponseEntity<Void> res = restTemplate.exchange(
                url,
                HttpMethod.PUT,
                request,
                Void.class
        );
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    /**
     * 블랙리스트 등록
     */
    @GetMapping("/blackList/article/{id}")
    public ResponseEntity<?> blackListArticle(@RequestParam("id") Long id){
        String url = "http://localhost:8080/~~~~~";

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity request = new HttpEntity(httpHeaders);

        ResponseEntity<Void> res = restTemplate.exchange(
                url,
                HttpMethod.PUT,
                request,
                Void.class
        );
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    /**
     * 블랙리스트 취소
     */
    @GetMapping("/blackList-cancel/article/{id}")
    public ResponseEntity<?> blackLisCanceltArticle(@RequestParam("id") Long id){
        String url = "http://localhost:8080/~~~~~~";

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity request = new HttpEntity(httpHeaders);

        ResponseEntity<Void> res = restTemplate.exchange(
                url,
                HttpMethod.PUT,
                request,
                Void.class
        );
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
