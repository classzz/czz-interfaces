package com.classzz.czzinterfaces.controllers;


import com.alibaba.fastjson.JSONObject;
import com.classzz.czzinterfaces.dtos.node.MiningInfoDto;
import com.classzz.czzinterfaces.services.NodeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/")
public class NodeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(NodeController.class);

    @Autowired
    private NodeService nodeService;

    @GetMapping("getHashRate")
    public @ResponseBody
    JSONObject getHashRate(){
        JSONObject result = new JSONObject();
        result.put("state", 200);
        result.put("version", "v1.0");

        try {
            MiningInfoDto miningInfoDto = nodeService.getMainNetWorkInfo();

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

    @RequestMapping(value = "getdifficulty")
    public @ResponseBody
    JSONObject getDifficulty() {
        JSONObject result = new JSONObject();
        result.put("state", 200);
        result.put("version", "v1.0");

        try {

            MiningInfoDto miningInfo = nodeService.getMiningInfo();

            JSONObject data = new JSONObject();
            data.put("block_height",miningInfo.getBlocks());
            data.put("difficulty",miningInfo.getDifficulty());
            data.put("testnet",miningInfo.getTestnet());
            result.put("data",data);

        } catch (Exception e){
            result.put("state", 500);
            result.put("msg", e.getMessage());
            LOGGER.error(e.getMessage());
        }

        return result;
    }
}
