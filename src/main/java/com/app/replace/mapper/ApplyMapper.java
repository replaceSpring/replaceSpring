package com.app.replace.mapper;

import com.app.replace.dto.ApplyDTO;
import com.app.replace.vo.ApplyVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ApplyMapper {
    public List<ApplyDTO> selectAll(long id);
    public void deleteByPositionId(long id);
    public void insert(ApplyVO applyVO);
    public int check(ApplyVO applyVO);
    public void deleteByPositionAndMemberId(ApplyVO applyVO);
    public int checkByMemberId(long id);
}
