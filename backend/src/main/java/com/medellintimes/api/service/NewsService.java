package com.medellintimes.api.service;

import com.medellintimes.api.dao.NewsRepository;
import com.medellintimes.api.model.News;
import org.springframework.stereotype.Service;

@Service
public class NewsService {

  private final NewsRepository newsRepository;

  public NewsService(NewsRepository newsRepository) {
    this.newsRepository = newsRepository;
  }

  public News saveNews(News newEntity) {
    if (!newEntity.validateNews()) {
      throw new RuntimeException("Badly formated news");
    }
    newEntity.setImages(null);

    return newsRepository.save(newEntity);
  }
}
