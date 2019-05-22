package com.github.lombritz.tracking;

import com.github.lombritz.tracking.model.TrackingResponse;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jaime Rojas
 * Created on 5/22/2019.
 */
public class FedExTrackingService implements TrackingService {
  public TrackingResponse trackPackage(String trackingNumber) {
    String url = "https://www.fedex.com/trackingCal/track";
    String json = requestData(trackingNumber);
    HttpClient httpClient = HttpClientBuilder.create().build();
    List<NameValuePair> parameters = new ArrayList<>();
    parameters.add(new BasicNameValuePair("data", requestData(trackingNumber)));
    parameters.add(new BasicNameValuePair("action", "trackpackages"));
    parameters.add(new BasicNameValuePair("locale", "en_US"));
    parameters.add(new BasicNameValuePair("version", "1"));
    parameters.add(new BasicNameValuePair("format", "json"));

    TrackingResponse response = null;
    try {
      HttpEntity form = new UrlEncodedFormEntity(parameters);
      HttpPost httpPost = new HttpPost(url);
      httpPost.setEntity(form);
      HttpResponse httpResponse = httpClient.execute(httpPost);
      HttpEntity responseEntity = httpResponse.getEntity();
      response = parseTrackingInfo(responseEntity);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return response;
  }

  private TrackingResponse parseTrackingInfo(HttpEntity responseEntity) {
    // TODO: implement
    return null;
  }

  private String requestData(String trackingNumber) {
    return "{\"TrackPackagesRequest\":{\"appType\":\"WTRK\",\"appDeviceType\":\"\",\"supportHTML\":true," +
        "\"supportCurrentLocation\":true,\"uniqueKey\":\"\",\"processingParameters\":{}," +
        "\"trackingInfoList\":[{\"trackNumberInfo\":{\"trackingNumber\":\"" + trackingNumber +
        "\",\"trackingQualifier\":\"\",\"trackingCarrier\":\"\"}}]}}";
  }
}
