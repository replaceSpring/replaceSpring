package com.app.replace.dao;

import com.app.replace.dto.BookmarkDTO;
import com.app.replace.mapper.BookmarkMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BookmarkDAO {
    private final BookmarkMapper bookmarkMapper;

    public List<BookmarkDTO> selectAll(long id){
        return bookmarkMapper.selectAll(id);
    }
}
