package com.github.lombritz.tracking;

/**
 * @author Jaime Rojas
 * Created on 5/22/2019.
 */
public class Main {
  public static void main(String[] args) {
    TrackingService fedex = new FedExTrackingService();
    System.out.println(fedex.trackPackage("477937452712").getTrackingInfo().getStatus());
  }
}
