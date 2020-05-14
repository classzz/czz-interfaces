package com.classzz.czzinterfaces.services;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.classzz.czzinterfaces.CzzConstants;
import com.classzz.czzinterfaces.dtos.JsonParam;
import com.classzz.czzinterfaces.dtos.node.MiningInfoDto;
import com.classzz.czzinterfaces.utils.HttpUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NodeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(NodeService.class);

    public JSONObject getResult(List<Object> params, String methodName){

        JsonParam jsonParam = new JsonParam();
        jsonParam.setJsonrpc("2.0");
        jsonParam.setMethod(methodName);
        jsonParam.setParams(params);
        jsonParam.setId(67L);
        String param = JSONObject.toJSONString(jsonParam);
        String result = HttpUtil.doPost(CzzConstants.NODE_URL, param);
        JSONObject object = (JSONObject)JSONObject.parse(result);
        return object;

    }



    /**
     * Get block difficulty information
     * @return
     */
    public MiningInfoDto getMiningInfo(){
        List<Object> params = new ArrayList<>();

        JSONObject object = getResult(params,"getmininginfo");
        MiningInfoDto miningInfoDto = JSON.toJavaObject(object.getJSONObject("result"),MiningInfoDto.class) ;
        return miningInfoDto;
    }

}
