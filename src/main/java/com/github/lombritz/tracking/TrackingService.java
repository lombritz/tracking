package com.github.lombritz.tracking;

import com.github.lombritz.tracking.model.TrackingResponse;

/**
 * @author Jaime Rojas
 * Created on 5/22/2019.
 */
public interface TrackingService {
  TrackingResponse trackPackage(String trackingNumber);
}
