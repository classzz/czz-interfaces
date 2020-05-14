package com.classzz.czzinterfaces.controllers;

import com.alibaba.fastjson.JSONObject;
import com.classzz.czzinterfaces.dtos.node.MiningInfoDto;
import com.classzz.czzinterfaces.services.MainNetworkService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
public class MainNetworkController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MainNetworkController.class);

    @Autowired
    private MainNetworkService mainNetworkService;

    @GetMapping("getHashRate")
    public JSONObject getHashRate(){
        JSONObject result = new JSONObject();
        result.put("state", 200);
        result.put("version", "v1.0");

        try {
            MiningInfoDto miningInfoDto = mainNetworkService.getMainNetWorkInfo();

            JSONObject data = new JSONObject();
            data.put("block_height", miningInfoDto.getBlocks());
            data.put("hash_rate", miningInfoDto.getNetworkhashps());
            data.put("testnet", miningInfoDto.getTestnet());
            result.put("data", data);

        } catch (Exception e) {
            result.put("state", 500);
            result.put("msg", e.getMessage());
            LOGGER.debug(e.getMessage());
        }

        return result;
    }
}
