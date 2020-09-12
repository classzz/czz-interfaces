package com.classzz.czzinterfaces.dtos.state;

public class BeaconFreeAssetDto {

    private String DOGE;
    private String LTC;
    private String BTC;
    private String BSV;
    private String BCH;

    public String getDOGE() {
        return DOGE;
    }

    public void setDOGE(String DOGE) {
        this.DOGE = DOGE;
    }

    public String getLTC() {
        return LTC;
    }

    public void setLTC(String LTC) {
        this.LTC = LTC;
    }

    public String getBTC() {
        return BTC;
    }

    public void setBTC(String BTC) {
        this.BTC = BTC;
    }

    public String getBSV() {
        return BSV;
    }

    public void setBSV(String BSV) {
        this.BSV = BSV;
    }

    public String getBCH() {
        return BCH;
    }

    public void setBCH(String BCH) {
        this.BCH = BCH;
    }

    @Override
    public String toString() {
        return "BeaconFreeAssetDto{" +
                "DOGE='" + DOGE + '\'' +
                ", LTC='" + LTC + '\'' +
                ", BTC='" + BTC + '\'' +
                ", BSV='" + BSV + '\'' +
                ", BCH='" + BCH + '\'' +
                '}';
    }
}
