package com.medellintimes.api.controller;

import com.medellintimes.api.dto.NewImagesDTO;
import com.medellintimes.api.model.Image;
import com.medellintimes.api.service.ImageService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/images")
public class ImageController {

  private final ImageService imageService;

  public ImageController(ImageService imageService) {
    this.imageService = imageService;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public List<Image> createImages(@RequestBody NewImagesDTO newImages) {
    return imageService.createImages(newImages.getUrls());
  }
}
