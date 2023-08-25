package com.app.replace.dao;

import com.app.replace.dto.PositionDTO;
import com.app.replace.mapper.PositionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PositionDAO {
    private final PositionMapper positionMapper;

    public List<PositionDTO> selectAllWithCompanyName(){
        return positionMapper.selectAllWithCompanyName();
    }
}
