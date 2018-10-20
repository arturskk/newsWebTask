package com.newsTask.POJO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponeArticlePojo {
    private String country;
    private String category;
    private List<ArticlePojo> articles;
}
