package com.example.moduleadmin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/admin")
@Controller
public class MainController {
    /**
     *  관리자 페이지 url(http://localhost:8081/api/admin)으로 왔을 때 관리자 계정인지 확인하는 부분
     *  8080에서 관리자계정인지 체크하는 api 생성 후
     *  true인지 false인지 반환
     *  관리자 계정 맞으면 관리자 페이지로 이동
     */
}
