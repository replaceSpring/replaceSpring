package com.app.replace.dao;

import com.app.replace.mapper.FileMapper;
import com.app.replace.vo.FileVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class FileDAO {
    private final FileMapper fileMapper;

    public void save(FileVO fileVO){
        fileMapper.insert(fileVO);
    }
    public Optional<FileVO> getFile(long id){
        return fileMapper.selectById(id);
    }
    public int getFileCountById(long id){
        return fileMapper.countFileById(id);
    }
    public void update(FileVO fileVO){
        fileMapper.update(fileVO);
    }
}
