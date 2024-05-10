package com.medellintimes.api.dto;

import com.medellintimes.api.model.Image;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImagesToNewsDTO {
  private List<Image> images;
}
