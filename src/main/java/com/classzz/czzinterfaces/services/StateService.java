package com.classzz.czzinterfaces.services;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.classzz.czzinterfaces.dtos.node.MiningInfoDto;
import com.classzz.czzinterfaces.dtos.state.AddressExchangeInfoDto;
import com.classzz.czzinterfaces.dtos.state.BeaconFreeAssetDto;
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

    /**
     *@funution  Get the getRateInfo interface of the main network
     *@return List<StateInfoDto>
     *@time 2020/6/24 15:46
     */
    public Double getRateInfo(String token){
        List<Object> params = new ArrayList<>();
        params.add(token);
        params.add("CZZ");
        JSONObject object = HttpClient.GetResult(params,"getrateinfo");
        Double result = object.getDouble("result");
        return result;
    }

    /**
     *@funution  Get the getAddressExchangeInfo interface of the main network
     *@return AddressExchangeInfoDto
     *@time 2020/6/24 15:46
     */
    public AddressExchangeInfoDto getAddressExchangeInfo(Integer BeaconID, String Address){
        List<Object> params = new ArrayList<>();
        params.add(BeaconID);
        params.add(Address);
        JSONObject object = HttpClient.GetResult(params,"getaddressexchangeinfo");
        AddressExchangeInfoDto result = JSON.parseObject(object.getString("result"), AddressExchangeInfoDto.class);
        return result;
    }

    /**
     *@funution  Get the getBeaconFreeAsset interface of the main network
     *@return BeaconFreeAssetDto
     *@time 2020/6/24 15:46
     */
    public BeaconFreeAssetDto getBeaconFreeAsset(Integer BeaconID){
        List<Object> params = new ArrayList<>();
        params.add(BeaconID);
        JSONObject object = HttpClient.GetResult(params,"getbeaconfreeasset");
        BeaconFreeAssetDto result = JSON.parseObject(object.getString("result"), BeaconFreeAssetDto.class);
        return result;
    }

    /**
     *@funution  Get the getBeaconFreeAsset interface of the main network
     *@return BeaconFreeAssetDto
     *@time 2020/6/24 15:46
     */
    public Long GetBeaconExchangeAsset(String Address){
        List<Object> params = new ArrayList<>();
        params.add(Address);
        JSONObject object = HttpClient.GetResult(params,"getbeaconfreeasset");
        Long result = object.getLong("result");
        return result;
    }

}

