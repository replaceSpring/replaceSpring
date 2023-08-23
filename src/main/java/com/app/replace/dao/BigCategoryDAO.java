package com.app.replace.dao;

import com.app.replace.mapper.BigCategoryMapper;
import com.app.replace.vo.BigCategoryVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BigCategoryDAO {
    private final BigCategoryMapper bigCategoryMapper;

    public List<BigCategoryVO> selectAll(){
        return bigCategoryMapper.selectAll();
    }
}
