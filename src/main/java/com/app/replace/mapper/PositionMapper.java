package com.app.replace.mapper;

import com.app.replace.dto.PositionDTO;
import com.app.replace.vo.PositionVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PositionMapper {
    public List<PositionVO> selectAll();

    public List<PositionDTO> selectAllWithCompanyName();
}
