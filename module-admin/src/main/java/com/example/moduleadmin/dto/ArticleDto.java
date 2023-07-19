package com.example.moduleadmin.dto;

import lombok.Data;

@Data
public class ArticleDto {
    private Long id;
    private Long userId;
    private String username;
    private String title;
    private String status;
    private String createdAt;


}
