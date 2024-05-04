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
    @Override
    public String creatCache(String cachename) {
        String endpointUrl = mainUrl + "creatcache/" + cachename;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<>(null, headers); // Pass null as the body for now

        ResponseEntity<String> response = restTemplate.exchange(endpointUrl, HttpMethod.POST, request, String.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            return null;
        }
    }

    @Override
    public String sendDataToCache(String cachename,String nameforcache,Object data){
        String endpointUrl = mainUrl + "senddatatocache/" + cachename;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
         JSONObject requestBody = new JSONObject();
         requestBody.put("name",nameforcache);
         requestBody.put("data",data);
         String requestBodyString = requestBody.toString();
        HttpEntity<String> request = new HttpEntity<>(requestBodyString, headers);
        ResponseEntity<String> response = restTemplate.exchange(endpointUrl, HttpMethod.POST, request, String.class);
        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            return null;
        }
    }
    @Override
    public List<IxtisasDto> getdata(String cachename, String nameforcache) {
        String endpointUrl = mainUrl + "getdatafromcache/" + cachename + "/" + nameforcache;
        ResponseEntity<List<IxtisasDto>> response = restTemplate.exchange(
                endpointUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<IxtisasDto>>() {
                }
        );
        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        } else {
            return null;
        }
    }
    }
