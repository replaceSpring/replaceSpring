package com.app.replace.dao;

import com.app.replace.dto.PositionDTO;
import com.app.replace.dto.Search;
import com.app.replace.mapper.ApplyMapper;
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
    private final ApplyDAO applyDAO;

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

    public List<PositionDTO> selectByBigCategoryId(long id){
        return positionMapper.selectByBigCategory(id);
    }

    public PositionDTO select(long id){
        return positionMapper.select(id);
    }
    public void insert(PositionVO positionVO){
        positionMapper.insert(positionVO);
    }
    public List<PositionDTO>selectAllByMemberId(long id){
        return positionMapper.selectAllByMemberId(id);
    }
    public int selectPositionCountByMemberId(long id){
        return positionMapper.selectPositionCountByMemberId(id);
    }
    public void deletePositionById(long id){
        applyDAO.deleteByPositionId(id);
        positionMapper.deletePositionById(id);
    }
    public List<PositionDTO>selectFavorites(long id){
        return positionMapper.selectFavorites(id);
    }
}
