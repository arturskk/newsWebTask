package com.newsTask.POJO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PojoNews {
    private String status;
    private int totalResults;
    private List<Articles> articles;
}
