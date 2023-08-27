package com.app.replace.mapper;

import com.app.replace.dto.ApplyDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ApplyMapper {
    public List<ApplyDTO> selectAll(long id);
}
