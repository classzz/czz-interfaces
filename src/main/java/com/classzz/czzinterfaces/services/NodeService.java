package com.classzz.czzinterfaces.services;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.classzz.czzinterfaces.dtos.node.MiningInfoDto;
import com.classzz.czzinterfaces.utils.HttpClient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class NodeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(NodeService.class);

    /**
     * @funution Get ...
     * @author Robin-byte
     * @time 2020/06/07 16:06
     * @return
     */
    public static List<Map<String, String>> tempMethodName(Map map){
        List<Map<String, String>> resultList = new ArrayList<>();

        List<Object> params = new ArrayList<>();

        JSONObject object = HttpClient.GetResult(params,"getmininginfo");
        Map resultMap = JSON.toJavaObject(object.getJSONObject("result"), Map.class);

        return resultList;
    }

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
