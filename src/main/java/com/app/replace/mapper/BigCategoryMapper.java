package com.app.replace.mapper;

import com.app.replace.vo.BigCategoryVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BigCategoryMapper {
    public List<BigCategoryVO> selectAll();
}
