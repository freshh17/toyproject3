package com.example.moduleadmin.controller;

import com.example.moduleadmin.dto.UserDto;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * 유저 관리 Controller.
 */
@Controller
@RequestMapping("/api/admin")
public class UserManagementController {
    /**
     * 유저 목록 가져오기. (통계) - 유저의 게시글 수, 댓글 수 List
     */
    @GetMapping("/userList")
    public String getUserList(Model model){
        String url = "http://localhost:8080/~~~~";

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
        List<UserDto> dto = res.getBody();
        model.addAttribute("users",dto);

        return "users";
    }

    /**
     * 댓글 수가 많은 유저순으로 정렬된 List 가져오기.
     */
    @GetMapping("/userList/reply")
    public String getUserListReply(Model model){
        String url = "http://localhost:8080/~~~~~~~~~~";

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

        List<UserDto> dto = res.getBody();
        model.addAttribute("users",dto);

        return "users";
    }

    /**
     * 게시글 수가 많은 유저 순으로 정렬된 List 가져오기.
     */
    @GetMapping("/userList/article")
    public String getUserListArticle(Model model){
        String url = "http://localhost:8080/~~~~~~~";

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

        List<UserDto> dto = res.getBody();
        model.addAttribute("users",dto);

        return "users";
    }
}
