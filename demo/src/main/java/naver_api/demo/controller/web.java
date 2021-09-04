package naver_api.demo.controller;

import naver_api.demo.Crawler.NaverCrawler;
import naver_api.demo.Crawler.NaverCrawlerInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class web {

    @GetMapping("/{want}")

    public Optional<List> hello(@PathVariable("want") String want)
    {
        NaverCrawlerInfo Info=new NaverCrawlerInfo();

        return  Info.get_response(want);
    }

}
