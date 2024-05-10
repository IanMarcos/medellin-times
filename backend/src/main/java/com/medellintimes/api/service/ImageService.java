package com.medellintimes.api.service;

import com.medellintimes.api.dao.ImageRepository;
import com.medellintimes.api.model.Image;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImageService {

  private final ImageRepository imageRepository;

  public ImageService(ImageRepository imageRepository) {
    this.imageRepository = imageRepository;
  }

  public List<Image> createImages(List<String> newImageUrls) {
    List<Image> createdImages = new ArrayList<Image>();

    newImageUrls.forEach(url -> {
      Image auxImg = imageRepository.save(new Image(url));
      createdImages.add(auxImg);
    });

    return createdImages;
  }
}
