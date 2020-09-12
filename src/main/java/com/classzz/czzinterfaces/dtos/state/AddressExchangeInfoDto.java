package com.classzz.czzinterfaces.dtos.state;

public class AddressExchangeInfoDto {

    private Long lastHeight;
    private Long MaxRedeem;

    public Long getLastHeight() {
        return lastHeight;
    }

    public void setLastHeight(Long lastHeight) {
        this.lastHeight = lastHeight;
    }

    public Long getMaxRedeem() {
        return MaxRedeem;
    }

    public void setMaxRedeem(Long maxRedeem) {
        MaxRedeem = maxRedeem;
    }

    @Override
    public String toString() {
        return "AddressExchangeInfoDto{" +
                "lastHeight=" + lastHeight +
                ", MaxRedeem=" + MaxRedeem +
                '}';
    }
}
