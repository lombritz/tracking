package com.github.lombritz.tracking.model;

import lombok.Data;

/**
 * @author Jaime Rojas
 * Created on 5/22/2019.
 */
@Data
public class TrackingResponse {
  private TrackingInfo trackingInfo;
  private Boolean successful;
}
