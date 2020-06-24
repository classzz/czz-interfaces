package com.classzz.czzinterfaces.controllers;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.classzz.czzinterfaces.dtos.node.MiningInfoDto;
import com.classzz.czzinterfaces.dtos.state.StateInfoDto;
import com.classzz.czzinterfaces.services.StateService;
import org.omg.PortableInterceptor.INACTIVE;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/")
public class StateController {
    private static final Logger LOGGER = LoggerFactory.getLogger(StateController.class);

    @Autowired
    private StateService stateService;

    @RequestMapping(value = "getStateInfo")
    public @ResponseBody
    JSONObject getStateInfo() {
        JSONObject result = new JSONObject();
        result.put("state", 200);
        result.put("version", "v1.0");
        try {
            JSONArray array = new JSONArray();
            List<StateInfoDto> stateInfo = stateService.getStateInfo();
            if (null != stateInfo && stateInfo.size() > 0) {
                for (int i = 0; i < stateInfo.size(); i++) {
                    JSONObject data = new JSONObject();
                    data.put("id", stateInfo.get(i).getExchange_id());
                    data.put("beacon_address", stateInfo.get(i).getAddress());
                    data.put("asset_flag", stateInfo.get(i).getAsset_flag());
                    array.add(data);
                }
            }
            result.put("data", array);

        } catch (Exception e) {
            result.put("state", 500);
            result.put("msg", e.getMessage());
            LOGGER.error(e.getMessage());
        }

        return result;
    }


    @RequestMapping(value = "getStateInfoById")
    public @ResponseBody
    JSONObject getStateInfoById(Integer id) {
        System.out.println(id);
        JSONObject result = new JSONObject();
        JSONArray array = new JSONArray();
        result.put("state", 200);
        result.put("version", "v1.0");

        if(null==id){
            result.put("data", array);
            return result;
        }

        try {
            List<StateInfoDto> stateInfo = stateService.getStateInfo();
            if (null != stateInfo && stateInfo.size() > 0) {
                for (int i = 0; i < stateInfo.size(); i++) {
                    if (stateInfo.get(i).getExchange_id().equals(id)) {
                        JSONObject data = new JSONObject();
                        data.put("exchange_id", stateInfo.get(i).getExchange_id());
                        data.put("address", stateInfo.get(i).getAddress());
                        data.put("toAddress_pk_hex", stateInfo.get(i).getToAddress_pk_hex());
                        data.put("staking_amount", stateInfo.get(i).getStaking_amount());
                        data.put("asset_flag", stateInfo.get(i).getAsset_flag());
                        data.put("fee", stateInfo.get(i).getFee());
                        data.put("keep_time", stateInfo.get(i).getKeep_time());
                        data.put("white_list", stateInfo.get(i).getWhite_list());
                        data.put("CoinBaseAddress", stateInfo.get(i).getCoinBaseAddress());
                        array.add(data);
                    }
                }
            }
            result.put("data", array);

        } catch (Exception e) {
            result.put("state", 500);
            result.put("msg", e.getMessage());
            LOGGER.error(e.getMessage());
        }
        return result;
    }
}
