package com.classzz.czzinterfaces.services;

import com.classzz.czzinterfaces.mappers.SwapInfoMapper;
import com.classzz.czzinterfaces.model.SwapInfo;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class SwapInfoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SwapInfoService.class);

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    public List<SwapInfo> getSwapInfo(String systemType) throws Exception{
        List<SwapInfo> SwapInfos = new ArrayList<>();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        SwapInfoMapper swapInfoMapper = sqlSession.getMapper(SwapInfoMapper.class);
        try {
            SwapInfos = swapInfoMapper.getSwapInfo(systemType);
        } finally {
            sqlSession.close();
        }
        return SwapInfos;
    }

}
