package com.app.replace.mapper;

import com.app.replace.dto.PositionDTO;
import com.app.replace.vo.PositionVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface PositionMapper {
    public List<PositionVO> selectAll();

    public List<PositionDTO> selectAllWithCompanyName();

    public List<PositionDTO> selectByBigCategory(long id);

    public PositionDTO select(long id);
}
