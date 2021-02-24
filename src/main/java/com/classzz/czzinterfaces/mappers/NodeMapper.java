package com.classzz.czzinterfaces.mappers;

import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import java.util.Map;

@Mapper
public interface NodeMapper {

    List<Map<String, Object>> getAddressRankingMapper(Map<String, Object> map);
}
