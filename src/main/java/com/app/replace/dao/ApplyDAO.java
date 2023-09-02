package com.app.replace.dao;


import com.app.replace.dto.ApplyDTO;
import com.app.replace.mapper.ApplyMapper;
import com.app.replace.vo.ApplyVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ApplyDAO {
    private final ApplyMapper applyMapper;

    public List<ApplyDTO> selectAll(long id){
        return applyMapper.selectAll(id);
    }
    public void deleteByPositionId(long id ){
        applyMapper.deleteByPositionId(id);
    }
    public void insert(ApplyVO applyVO){
        applyMapper.insert(applyVO);
    }
    public boolean check(ApplyVO applyVO){
        if (applyMapper.check(applyVO)>0){
            return true;
        }
        return false;
    }
    public void deleteByPositionAndMemberId(ApplyVO applyVO){
        applyMapper.deleteByPositionAndMemberId(applyVO);
    }
    public boolean checkByMemberId(long id){
        return applyMapper.checkByMemberId(id)>0;
    }
}
