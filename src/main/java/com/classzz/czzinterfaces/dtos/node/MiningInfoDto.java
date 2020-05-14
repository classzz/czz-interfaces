package com.classzz.czzinterfaces.dtos.node;

public class MiningInfoDto {

    private Integer blocks;
    private Integer currentBlockSize;
    private Integer currentBlockTx;
    private Double  difficulty;
    private String  errors;
    private Boolean generate;
    private Integer genproclimit;
    private Integer hashespersec;
    private Double  networkhashps;
    private Integer pooledtx;
    private Boolean testnet;

    public Integer getBlocks() {
        return blocks;
    }

    public void setBlocks(Integer blocks) {
        this.blocks = blocks;
    }

    public Integer getCurrentBlockSize() {
        return currentBlockSize;
    }

    public void setCurrentBlockSize(Integer currentBlockSize) {
        this.currentBlockSize = currentBlockSize;
    }

    public Integer getCurrentBlockTx() {
        return currentBlockTx;
    }

    public void setCurrentBlockTx(Integer currentBlockTx) {
        this.currentBlockTx = currentBlockTx;
    }

    public Double getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Double difficulty) {
        this.difficulty = difficulty;
    }

    public String getErrors() {
        return errors;
    }

    public void setErrors(String errors) {
        this.errors = errors;
    }

    public Boolean getGenerate() {
        return generate;
    }

    public void setGenerate(Boolean generate) {
        this.generate = generate;
    }

    public Integer getGenproclimit() {
        return genproclimit;
    }

    public void setGenproclimit(Integer genproclimit) {
        this.genproclimit = genproclimit;
    }

    public Integer getHashespersec() {
        return hashespersec;
    }

    public void setHashespersec(Integer hashespersec) {
        this.hashespersec = hashespersec;
    }

    public Double getNetworkhashps() {
        return networkhashps;
    }

    public void setNetworkhashps(Double networkhashps) {
        this.networkhashps = networkhashps;
    }

    public Integer getPooledtx() {
        return pooledtx;
    }

    public void setPooledtx(Integer pooledtx) {
        this.pooledtx = pooledtx;
    }

    public Boolean getTestnet() {
        return testnet;
    }

    public void setTestnet(Boolean testnet) {
        this.testnet = testnet;
    }
}
