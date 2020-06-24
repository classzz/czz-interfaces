package com.classzz.czzinterfaces.dtos.state;

import java.util.List;

public class StateInfoDto {
    private Integer asset_flag;
    private Long staking_amount;
    private Integer keep_time;
    private String white_list ;
    private Integer exchange_id;
    private String address;
    private Integer fee;
    private String toAddress_pk_hex;
    private List<String> CoinBaseAddress;
    public Integer getAsset_flag() {
        return asset_flag;
    }

    public void setAsset_flag(Integer asset_flag) {
        this.asset_flag = asset_flag;
    }

    public Long getStaking_amount() {
        return staking_amount;
    }

    public void setStaking_amount(Long staking_amount) {
        this.staking_amount = staking_amount;
    }

    public Integer getKeep_time() {
        return keep_time;
    }

    public void setKeep_time(Integer keep_time) {
        this.keep_time = keep_time;
    }

    public String getWhite_list() {
        return white_list;
    }

    public void setWhite_list(String white_list) {
        this.white_list = white_list;
    }

    public Integer getExchange_id() {
        return exchange_id;
    }

    public void setExchange_id(Integer exchange_id) {
        this.exchange_id = exchange_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getFee() {
        return fee;
    }

    public void setFee(Integer fee) {
        this.fee = fee;
    }

    public String getToAddress_pk_hex() {
        return toAddress_pk_hex;
    }

    public void setToAddress_pk_hex(String toAddress_pk_hex) {
        this.toAddress_pk_hex = toAddress_pk_hex;
    }

    public List<String> getCoinBaseAddress() {
        return CoinBaseAddress;
    }

    public void setCoinBaseAddress(List<String> coinBaseAddress) {
        CoinBaseAddress = coinBaseAddress;
    }
}
