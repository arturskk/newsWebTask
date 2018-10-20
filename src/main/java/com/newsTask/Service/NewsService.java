package com.newsTask.Service;

import com.newsTask.POJO.ArticlePojo;
import com.newsTask.POJO.PojoNews;
import com.newsTask.POJO.ResponeArticlePojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NewsService {

    @Autowired
    private FeignClientImpl feignClient;


    public ResponeArticlePojo callApi(String country, String category, Integer page) {
        return this.convertPojo(feignClient.callNewsApi(country, category, page, 5, "e4fb3ef351154d29b194ac2e0a2cf5df"), country, category, "");
    }

    public ResponeArticlePojo callApi(String search, Integer page) {
        return this.convertPojo(feignClient.callNewsApi(search, page, 5, "e4fb3ef351154d29b194ac2e0a2cf5df"), "world", "everything", search);
    }

    public ResponeArticlePojo convertPojo(PojoNews pojoNews, String country, String category, String search) {
        ResponeArticlePojo responeArticlePojo = new ResponeArticlePojo();
        List<ArticlePojo> articlePojos = pojoNews.getArticles().stream().map(ArticlePojo::new).collect(Collectors.toList());
        responeArticlePojo.setCountry(country);
        responeArticlePojo.setCategory(category);
        responeArticlePojo.setArticles(articlePojos);

        return responeArticlePojo;
    }

}
