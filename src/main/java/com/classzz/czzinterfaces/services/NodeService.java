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

@Service
public class NodeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(NodeService.class);

    /**
     * Get block difficulty information
     * @return
     */
    public MiningInfoDto getMiningInfo(){
        List<Object> params = new ArrayList<>();

        JSONObject object = HttpClient.GetResult(params,"getmininginfo");
        MiningInfoDto miningInfoDto = JSON.toJavaObject(object.getJSONObject("result"),MiningInfoDto.class) ;
        return miningInfoDto;
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
