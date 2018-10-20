package com.newsTask.Service;

import com.newsTask.POJO.PojoNews;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Client used to download news from newsorg.api
 */
@FeignClient(name = "FeignClientImpl", url = "https://newsapi.org", configuration = NewsConfiguration.class)
public interface FeignClientImpl {
    /**
     * Get news by selected country and category
     *
     * @param country  parameter used to select country of news
     * @param category category of news
     * @param page     used for pagination
     * @param pageSize limit number of news per page
     * @param apiKey   needed for newsapi access
     * @return Pojo with news articles
     */
    @RequestMapping(method = RequestMethod.GET, value = "/v2/top-headlines")
    PojoNews callNewsApi(@RequestParam("country") String country, @RequestParam("category") String category, @RequestParam("page") Integer page, @RequestParam("pageSize") Integer pageSize, @RequestParam("apiKey") String apiKey);

    /**
     * Get news by provided search phrase
     *
     * @param search provided search phrase
     * @return Pojo with news articles
     */
    @RequestMapping(method = RequestMethod.GET, value = "/v2/everything")
    PojoNews callNewsApi(@RequestParam("q") String search, @RequestParam("page") Integer page, @RequestParam("pageSize") Integer pageSize, @RequestParam("apiKey") String apiKey);

}
