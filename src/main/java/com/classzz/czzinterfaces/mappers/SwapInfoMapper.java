package com.classzz.czzinterfaces.mappers;

import com.classzz.czzinterfaces.model.SwapInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SwapInfoMapper {

    List<SwapInfo> getSwapInfo(String systemType);
}
