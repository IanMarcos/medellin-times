package com.medellintimes.api.service;

import com.medellintimes.api.dao.NewsRepository;
import com.medellintimes.api.model.News;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

  public News getNewsById(int newsId) {
    return fetchNews(newsId);
  }

  public List<News> getAllNews() {
    return newsRepository.findAll();
  }

  public News updateNews(int newsId, News updatedEntity) {
    News dbNews = fetchNews(newsId);

    updatedEntity.setId(newsId);
    updatedEntity.setCreatedAt(dbNews.getCreatedAt());

    return newsRepository.save(updatedEntity);
  }

  private News fetchNews(int id) {
    Optional<News> dbNews = newsRepository.findById(id);
    if (dbNews.isEmpty()) {
      throw new RuntimeException("The note doesn't exist or is not active");
    }

    return dbNews.get();
  }
}
