package com.classzz.czzinterfaces.utils;

import com.alibaba.fastjson.JSONObject;
import com.classzz.czzinterfaces.CzzConstants;
import com.classzz.czzinterfaces.dtos.JsonParam;

import java.util.List;

public class HttpClient {

    public static JSONObject GetResult(List<Object> params, String methodName){

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
}
