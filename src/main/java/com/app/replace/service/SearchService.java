package com.app.replace.service;

import com.app.replace.dto.PositionDTO;
import com.app.replace.dto.Search;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SearchService {
    public List<PositionDTO> getList(Search search);

}
