package com.classzz.czzinterfaces.controllers;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.classzz.czzinterfaces.dtos.node.MiningInfoDto;
import com.classzz.czzinterfaces.services.NodeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/")
public class NodeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(NodeController.class);

    @Autowired
    private NodeService nodeService;

    /**
     *
     * @return
     */
    @GetMapping("getAddressRanking")
    public @ResponseBody JSONObject getAddressRanking(@RequestBody String requestParam){
        JSONObject result = new JSONObject();
        result.put("state", 200);
        result.put("version", "v1.0");

        try{
            System.out.println(requestParam);
            Map<String, Object> requestMap = JSON.parseObject(requestParam, Map.class);
            System.out.println(requestMap.toString());
            //Parameter calibration
            for (Object map : requestMap.entrySet()) {
                if(((Map.Entry)map).getKey() == "orderby" && !((((Map.Entry)map).getValue()) instanceof Boolean)) {
                    throw new Exception("orderby parameter type error");
                } else if("rankfrom,rankto,pagenum,pagesize".indexOf(((Map.Entry)map).getKey().toString()) != -1 && !((((Map.Entry)map).getValue()) instanceof Integer)){
                    throw new Exception(((Map.Entry)map).getKey().toString() +" parameter type error");
                } else if("balancefrom,balanceto".indexOf(((Map.Entry)map).getKey().toString()) != -1 && !((((Map.Entry)map).getValue()) instanceof BigDecimal) && !((((Map.Entry)map).getValue()) instanceof Integer)){
                    throw new Exception(((Map.Entry)map).getKey().toString() +" parameter type error");
                } else if(((Map.Entry)map).getKey() != "orderby" && Double.valueOf(((Map.Entry)map).getValue().toString()) < 0) {
                    throw new Exception("The "+((Map.Entry)map).getKey().toString()+" cannot be negative");
                }
            }
            if(requestMap.get("balancefrom") != null
                    && requestMap.get("balanceto") != null
                    && Double.parseDouble(requestMap.get("balancefrom").toString()) >= Double.parseDouble(requestMap.get("balanceto").toString())){
                throw new Exception("Balancefrom is greater than balanceto");
            }
            if(requestMap.get("rankfrom") != null
                    && requestMap.get("rankto") != null
                    && Double.parseDouble(requestMap.get("rankfrom").toString()) >= Double.parseDouble(requestMap.get("rankto").toString())){
                throw new Exception("Rankfrom is greater than rankto");
            }
            if(requestMap.get("orderby") == null){
                requestMap.put("orderby", false);
            }
            if(requestMap.get("pagenum") == null){
                requestMap.put("pagenum", 1);
            }
            if(requestMap.get("pagesize") == null){
                requestMap.put("pagesize", 20);
            }

            List<Map<String, String>> data = nodeService.getAddressHoldMoneyRanking(requestMap);
            result.put("data", data);

        } catch (Exception e) {
            result.put("state", 500);
            result.put("msg", e.getMessage());
            LOGGER.debug(e.getMessage());
        }

        return result;
    }

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

            MiningInfoDto miningInfo = nodeService.getMainNetWorkInfo();

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
