package com.classzz.czzinterfaces.services;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.classzz.czzinterfaces.dtos.node.MiningInfoDto;
import com.classzz.czzinterfaces.utils.HttpClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MainNetworkService {

    /**
     * @funution  Get mining-related information
     * @author Robin-byte
     * @time 2020/5/14 15:46
    */
    public MiningInfoDto getMainNetWorkInfo(){
        List<Object> params = new ArrayList<>();

        JSONObject object = HttpClient.GetResult(params,"getmininginfo");
        MiningInfoDto miningInfoDto = JSON.toJavaObject(object.getJSONObject("result"),MiningInfoDto.class) ;
        return miningInfoDto;

    }
}
