package com.github.lombritz.tracking.model;

import lombok.Data;

/**
 * @author Jaime Rojas
 * Created on 5/22/2019.
 */
@Data
public class TrackingInfo {
  private Boolean delivered;
  private String trackingNumber;
  private String status;
  private Double totalKgsWgt;
  private Double totalLbsWgt;
}
