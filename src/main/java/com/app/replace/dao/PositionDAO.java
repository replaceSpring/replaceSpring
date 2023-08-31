package com.app.replace.dao;

import com.app.replace.dto.PositionDTO;
import com.app.replace.dto.Search;
import com.app.replace.mapper.PositionMapper;
import com.app.replace.vo.PositionVO;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PositionDAO {
    private final PositionMapper positionMapper;

    public List<PositionDTO> selectAllWithCompanyName(){
        return positionMapper.selectAllWithCompanyName();
    }
    public List<PositionDTO> selectAllByPositionOpenDate(){
        return positionMapper.selectAllByPositionOpenDate();
    }
    public List<PositionDTO> selectAllByPositionDueDate(){
        return positionMapper.selectAllByPositionDueDate();
    }

    public List<PositionDTO> findAll(Search search) {
        return positionMapper.selectAllBySearch(search);
    }
};
