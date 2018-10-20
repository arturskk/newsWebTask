package com.newsTask.Controller;


import com.newsTask.POJO.ResponeArticlePojo;
import com.newsTask.Service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Rest api end points
 */
@RestController
public class newsController {

    @Autowired
    NewsService newsService;

    /**
     * Search by provided country and category
     */
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = {"/news/{country}/{category}/"})
    public final ResponeArticlePojo getNewsByCountryAndCategory(@PathVariable String country, @PathVariable String category, @RequestParam(value = "page", required = false) Integer page) {
        return newsService.callApi(country, category, page);

    }

    /**
     * Search by provided search phrase
     */
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = {"/news/{search}/"})
    public final ResponeArticlePojo getNewsBySearch(@PathVariable String search, @RequestParam(value = "page", required = false) Integer page) {
        return newsService.callApi(search, page);

    }


}
