package com.classzz.czzinterfaces.services;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.classzz.czzinterfaces.dtos.node.MiningInfoDto;
import com.classzz.czzinterfaces.mappers.NodeMapper;
import com.classzz.czzinterfaces.utils.HttpClient;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.soap.Node;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class NodeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(NodeService.class);

    @Autowired
    private SqlSessionFactory sqlSessionFactory;
    /**
     * @funution Get ...
     * @author Robin-byte
     * @time 2020/06/07 16:06
     * @return
     */
    public List<Map<String, String>> getAddressHoldMoneyRanking(Map<String, Object> map) throws Exception{
        List<Map<String, String>> resultAddressRankList = new ArrayList<>();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        NodeMapper nodeMapper = sqlSession.getMapper(NodeMapper.class);
        try {
            this.setPageNumOrSize(Integer.valueOf(map.get("pagenum").toString()), Integer.valueOf(map.get("pagesize").toString()), map);
            resultAddressRankList = nodeMapper.getAddressRankingMapper(map);
        } finally {
            sqlSession.close();
        }
        return resultAddressRankList;
    }

    private void setPageNumOrSize(Integer pageNum, Integer pageSize, Map<String, Object> map){
        map.put("limit1", (pageNum - 1) * pageSize);
        map.put("limit2", pageNum * pageSize);
    }

    /**
     * @funution  Get mining-related information
     * @author Robin-byte
     * @time 2020/5/14 15:46
     */
    public MiningInfoDto getMainNetWorkInfo(){
        List<Object> params = new ArrayList<>();

        JSONObject object = HttpClient.GetResult(params,"getmininginfo");
        MiningInfoDto miningInfoDto = JSON.toJavaObject(object.getJSONObject("result"),MiningInfoDto.class) ;
        return miningInfoDto;

    }

}
