package com.example.BakalavarSpeciality.nodejsservice;

import com.example.BakalavarSpeciality.dto.IxtisasDto;
import lombok.RequiredArgsConstructor;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NodejsServiceImpl implements NodejsService{
    private final RestTemplate restTemplate;
    private String mainUrl = "http://localhost:5000/api/";
//    @Override
//    public String sendDataToNodeJsService(String id,Object result,String endpointurl) throws JSONException {
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        // Create the request body
//        JSONObject requestBody = new JSONObject();
//        requestBody.put("id", id);
//        requestBody.put("data", result);
//        // Create the HTTP entity with headers and body
//        HttpEntity<String> request = new HttpEntity<>(requestBody.toString(), headers);
//        // Send the POST request
//        ResponseEntity<String> response = restTemplate.exchange(endpointurl, HttpMethod.POST, request, String.class);
//        return response.getBody();
//    }

    @Override
    public String creatCache(String cachename) {
        String endpointUrl = mainUrl + "creatcache/" + cachename;
        // Set headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Set request body
        // You may need to construct a request body if required by the API
        // For example:
        // JSONObject requestBody = new JSONObject();
        // requestBody.put("key", "value");
        // String requestBodyString = requestBody.toString();

        // Create the HTTP entity with headers and body
        HttpEntity<String> request = new HttpEntity<>(null, headers); // Pass null as the body for now

        // Send the POST request
        ResponseEntity<String> response = restTemplate.exchange(endpointUrl, HttpMethod.POST, request, String.class);

        // Check response status and return body
        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            // Handle error response
            // For example:
            // throw new RuntimeException("Failed to create cache. Status code: " + response.getStatusCodeValue());
            return null; // Or handle the error in a different way
        }
    }

    @Override
    public String sendDataToCache(String cachename,String nameforcache,Object data){
        String endpointUrl = mainUrl + "senddatatocache/" + cachename;
        // Set headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        // Set request body
        // You may need to construct a request body if required by the API
        // For example:
         JSONObject requestBody = new JSONObject();
         requestBody.put("name",nameforcache);
         requestBody.put("data",data);
         String requestBodyString = requestBody.toString();
        // Create the HTTP entity with headers and body
        HttpEntity<String> request = new HttpEntity<>(requestBodyString, headers); // Pass null as the body for now

        // Send the POST request
        ResponseEntity<String> response = restTemplate.exchange(endpointUrl, HttpMethod.POST, request, String.class);

        // Check response status and return body
        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            // Handle error response
            // For example:
            // throw new RuntimeException("Failed to create cache. Status code: " + response.getStatusCodeValue());
            return null; // Or handle the error in a different way
        }



    }
    @Override
    public List<IxtisasDto> getdata(String cachename, String nameforcache) {
        String endpointUrl = mainUrl + "getdatafromcache/" + cachename + "/" + nameforcache;

        // Send the GET request and fetch the response body as a List<IxtisasDto>
        ResponseEntity<List<IxtisasDto>> response = restTemplate.exchange(
                endpointUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<IxtisasDto>>() {
                }
        );

        // Check response status
        if (response.getStatusCode().is2xxSuccessful()) {
            // Extract the List<IxtisasDto> from the response
            return response.getBody();
        } else {
            // Handle error response
            // For example:
            // throw new RuntimeException("Failed to retrieve data from cache. Status code: " + response.getStatusCodeValue());
            return null; // Or handle the error in a different way
        }
    }
    }
