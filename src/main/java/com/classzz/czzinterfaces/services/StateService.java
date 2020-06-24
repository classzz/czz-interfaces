package com.classzz.czzinterfaces.services;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.classzz.czzinterfaces.dtos.node.MiningInfoDto;
import com.classzz.czzinterfaces.dtos.state.StateInfoDto;
import com.classzz.czzinterfaces.utils.HttpClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StateService {

    /**
     *@funution  Get the getstateinfo interface of the main network
     *@return List<StateInfoDto>
     *@time 2020/6/24 15:46
     */
    public List<StateInfoDto> getStateInfo(){
        List<Object> params = new ArrayList<>();
        JSONObject object = HttpClient.GetResult(params,"getstateinfo");
        List<StateInfoDto> result = JSON.parseArray(object.getString("result"),StateInfoDto.class);
        return result;
    }

}
