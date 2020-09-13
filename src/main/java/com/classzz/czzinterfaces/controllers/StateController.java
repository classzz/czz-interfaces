package com.classzz.czzinterfaces.controllers;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.classzz.czzinterfaces.dtos.node.MiningInfoDto;
import com.classzz.czzinterfaces.dtos.state.AddressExchangeInfoDto;
import com.classzz.czzinterfaces.dtos.state.BeaconFreeAssetDto;
import com.classzz.czzinterfaces.dtos.state.StateInfoDto;
import com.classzz.czzinterfaces.services.StateService;
import org.omg.PortableInterceptor.INACTIVE;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.DecimalFormat;
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
        JSONObject result = new JSONObject();

        JSONObject data = new JSONObject();
        result.put("state", 200);
        result.put("version", "v1.0");

        if (null == id) {
            result.put("data", data);
            return result;
        }

        try {
            List<StateInfoDto> stateInfo = stateService.getStateInfo();
            if (null != stateInfo && stateInfo.size() > 0) {
                for (int i = 0; i < stateInfo.size(); i++) {
                    if (stateInfo.get(i).getExchange_id().equals(id)) {

                        data.put("id", stateInfo.get(i).getExchange_id());
                        data.put("address", stateInfo.get(i).getAddress());
                        data.put("beacon_address", stateInfo.get(i).getToAddress_pk_hex());

                        if(null!=stateInfo.get(i).getStaking_amount()&&stateInfo.get(i).getStaking_amount()>0) {
                            data.put("staking_amount", stateInfo.get(i).getStaking_amount()/ Math.pow(10,8));
                        }else{
                            data.put("staking_amount", stateInfo.get(i).getStaking_amount());
                        }

                        data.put("asset_flag", stateInfo.get(i).getAsset_flag());
                        data.put("fee", stateInfo.get(i).getFee());
                        data.put("keep_time", stateInfo.get(i).getKeep_time());
                        data.put("white_list", stateInfo.get(i).getWhite_list());
                        data.put("CoinBaseAddress", stateInfo.get(i).getCoinBaseAddress());
                        result.put("data", data);
                    }
                }
            }
            result.put("data", data);

        } catch (Exception e) {
            result.put("state", 500);
            result.put("msg", e.getMessage());
            LOGGER.error(e.getMessage());
        }
        return result;
    }


    @RequestMapping(value = "getRateInfo")
    public @ResponseBody
    JSONObject GetRateInfo() {
        JSONObject result = new JSONObject();

        JSONObject data = new JSONObject();
        result.put("state", 200);
        result.put("version", "v1.0");

        String[] tokens = new String[]{"DOGE","LTC ","BTC","BCH","BSV"};
        try {
            for (String token:tokens) {

                Double stateInfo = stateService.getRateInfo(token);
                JSONObject token1  = new JSONObject();
                if (null != stateInfo) {
                    String simple = token1 + "_CZZ";
                    result.put(simple, stateInfo);
                }
                result.put("data", data);
            }

        } catch (Exception e) {
            result.put("state", 500);
            result.put("msg", e.getMessage());
            LOGGER.error(e.getMessage());
        }
        return result;
    }


    @RequestMapping(value = "getAddressExchangeInfo")
    public @ResponseBody
    JSONObject GetAddressExchangeInfo(Integer BeaconID, String Address) {
        JSONObject result = new JSONObject();

        JSONObject data = new JSONObject();
        result.put("state", 200);
        result.put("version", "v1.0");

        if (null == BeaconID || null == Address) {
            result.put("data", data);
            return result;
        }

        try {

            AddressExchangeInfoDto exchangeInfo = stateService.getAddressExchangeInfo(BeaconID, Address);
            data.put("last_height",exchangeInfo.getLastHeight());
            data.put("max_redeem",exchangeInfo.getMaxRedeem());
            result.put("data", data);

        } catch (Exception e) {
            result.put("state", 500);
            result.put("msg", e.getMessage());
            LOGGER.error(e.getMessage());
        }
        return result;
    }


    @RequestMapping(value = "getBeaconFreeAsset")
    public @ResponseBody
    JSONObject GetBeaconFreeAsset(Integer BeaconID) {
        JSONObject result = new JSONObject();

        JSONObject data = new JSONObject();
        result.put("state", 200);
        result.put("version", "v1.0");

        if (null == BeaconID) {
            result.put("data", data);
            return result;
        }

        try {

            BeaconFreeAssetDto beaconFreeAsset = stateService.getBeaconFreeAsset(BeaconID);
            data.put("doge",beaconFreeAsset.getDOGE());
            data.put("ltc",beaconFreeAsset.getLTC());
            data.put("btc",beaconFreeAsset.getBTC());
            data.put("bsv",beaconFreeAsset.getBSV());
            data.put("bch",beaconFreeAsset.getBCH());
            result.put("data", data);

        } catch (Exception e) {
            result.put("state", 500);
            result.put("msg", e.getMessage());
            LOGGER.error(e.getMessage());
        }
        return result;
    }


    @RequestMapping(value = "getBeaconExchangeAsset")
    public @ResponseBody
    JSONObject GetBeaconExchangeAsset(String Address) {
        JSONObject result = new JSONObject();

        JSONObject data = new JSONObject();
        result.put("state", 200);
        result.put("version", "v1.0");

        if (null == Address) {
            result.put("data", data);
            return result;
        }

        try {

            Long stateInfo = stateService.GetBeaconExchangeAsset(Address);
            result.put("data", stateInfo);

        } catch (Exception e) {
            result.put("state", 500);
            result.put("msg", e.getMessage());
            LOGGER.error(e.getMessage());
        }
        return result;
    }


}
