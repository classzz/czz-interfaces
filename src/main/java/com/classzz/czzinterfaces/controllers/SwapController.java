package com.classzz.czzinterfaces.controllers;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.classzz.czzinterfaces.model.SwapInfo;
import com.classzz.czzinterfaces.services.SwapInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/swap")
public class SwapController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SwapController.class);

    @Autowired
    private SwapInfoService swapInfoService;

    @RequestMapping(value = "getSwapInfos")
    public @ResponseBody
    JSONObject getSwapInfos(String systemType) {
        JSONObject result = new JSONObject();
        result.put("state", 200);
        result.put("version", "v1.0");

        try {

            List<SwapInfo> swapInfos = swapInfoService.getSwapInfo(systemType);
            JSONArray data = (JSONArray)JSONArray.toJSON(swapInfos);
            result.put("data",data);

        } catch (Exception e){
            result.put("state", 500);
            result.put("msg", e.getMessage());
            LOGGER.error(e.getMessage());
        }

        return result;
    }


}
