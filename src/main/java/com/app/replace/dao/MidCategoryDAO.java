package com.app.replace.dao;

import com.app.replace.mapper.MidCategoryMapper;
import com.app.replace.vo.MidCategoryVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MidCategoryDAO {
    private final MidCategoryMapper midCategoryMapper;

    public List<MidCategoryVO> selectById(long id){
        return midCategoryMapper.selectById(id);
    }
    public List<MidCategoryVO> selectAll(){return midCategoryMapper.selectAll();}
}
