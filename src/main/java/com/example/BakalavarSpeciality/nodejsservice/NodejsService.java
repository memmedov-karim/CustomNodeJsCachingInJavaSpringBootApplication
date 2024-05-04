package com.example.BakalavarSpeciality.nodejsservice;

import com.example.BakalavarSpeciality.dto.IxtisasDto;
import org.json.JSONException;

import java.util.List;

public interface NodejsService {
    String creatCache(String cachename);
    String sendDataToCache(String cachename,String nameforcache,Object data);

    List<IxtisasDto> getdata(String cachename, String nameforcache);
}
