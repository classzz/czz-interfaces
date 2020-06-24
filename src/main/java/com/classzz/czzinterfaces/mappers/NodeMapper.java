package com.classzz.czzinterfaces.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface NodeMapper {

    List<Map<String, String>> getAddressRankingMapper(Map<String, Object> map);
}
