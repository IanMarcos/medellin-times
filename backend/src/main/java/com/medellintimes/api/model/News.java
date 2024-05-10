package com.medellintimes.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@Entity
@Table
@Data
@AllArgsConstructor
public class News {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "news_id")
  private int id;

  @Column
  private String author;

  @Column
  private String title;

  @Column
  private String subtitle;

  @Column
  private String content;

  @Column(name = "created_at")
  @CreationTimestamp
  private LocalDateTime createdAt;

  @Column(name = "updated_at")
  @UpdateTimestamp
  private LocalDateTime updatedAt;

  @Column
  private int enabled;

  @ManyToMany
  @JoinTable(
      name = "image_news",
      joinColumns = @JoinColumn(name = "news_id"),
      inverseJoinColumns = @JoinColumn(name = "image_id")
  )
  private List<Image> images;

  public News() {
    this.enabled = 1;
  }

  public boolean validateNews() {

    if (author == null || author.isEmpty()) {
      return false;
    }

    if (title == null || title.isEmpty()) {
      return false;
    }

    if (content == null || content.isEmpty()) {
      return false;
    }

    return true;
  }

  public void addImage(Image image) {
    if (images == null) {
      images = new ArrayList<>();
    }

    if (!isImageInNews(image.getId())) {
      images.add(image);
    }
  }

  public boolean isImageInNews(int imageId) {
    AtomicBoolean isIncluded = new AtomicBoolean(false);
    images.forEach(tempImage -> {
      if (imageId == tempImage.getId()) {
        isIncluded.set(true);
      }
    });

    return isIncluded.get();
  }
}
