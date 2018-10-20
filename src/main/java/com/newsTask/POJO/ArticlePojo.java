package com.newsTask.POJO;

import lombok.Data;

@Data
public class ArticlePojo {
    private String author;
    private String title;
    private String description;
    private String date;
    private String sourceName;
    private String articleUrl;
    private String imageUrl;

    public ArticlePojo(Articles articles) {
        this.author = articles.getAuthor();
        this.title = articles.getTitle();
        this.description = articles.getDescription();
        this.date = articles.getPublishedAt();
        this.sourceName = articles.getSource().getName();
        this.articleUrl = articles.getUrl();
        this.imageUrl = articles.getUrlToImage();
    }
}
