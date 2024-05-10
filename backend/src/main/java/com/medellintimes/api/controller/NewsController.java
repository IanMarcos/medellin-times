package com.medellintimes.api.controller;

import com.medellintimes.api.model.News;
import com.medellintimes.api.service.NewsService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/news")
public class NewsController {

  private final NewsService newsService;

  public NewsController(NewsService newsService) {
    this.newsService = newsService;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public News createNews(@RequestBody News newObject) {
    return newsService.saveNews(newObject);
  }

  @GetMapping("/{id}")
  public News getNewsById(@PathVariable int id) {
    return newsService.getNewsById(id);
  }

  @GetMapping
  public List<News> getAllNews() {
    return newsService.getAllNews();
  }

  @PutMapping("/{id}")
  public News putNews(@PathVariable int id, @RequestBody News news) {
    return newsService.updateNews(id, news);
  }

  @DeleteMapping("/{id}")
  public void deleteNews(@PathVariable int id) {
    newsService.deleteNews(id);
  }
}
