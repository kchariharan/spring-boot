package com.example.project;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class NewsController {


    @RequestMapping(value = "/api/news/topstories", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<News> getNews() throws Exception {
    //public  News getNews() throws Exception{
        News n = new News();
        n.setSection("123");
        n.setTitle("456");
        List l = new ArrayList();

        return ResponseEntity.ok().body(n);
    }

}
