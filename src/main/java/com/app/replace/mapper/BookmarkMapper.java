package com.app.replace.mapper;

import com.app.replace.dto.BookmarkDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookmarkMapper {
    public List<BookmarkDTO> selectAll(long id);
}
