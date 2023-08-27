package com.app.replace.dao;


import com.app.replace.dto.ApplyDTO;
import com.app.replace.mapper.ApplyMapper;
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
}
