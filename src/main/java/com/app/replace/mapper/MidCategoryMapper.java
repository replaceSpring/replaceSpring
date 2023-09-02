package com.app.replace.mapper;

import com.app.replace.vo.MidCategoryVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MidCategoryMapper {
    public List<MidCategoryVO> selectById(long id);
    public List<MidCategoryVO> selectAll();
}
