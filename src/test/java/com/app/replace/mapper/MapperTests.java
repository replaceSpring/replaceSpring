package com.app.replace.mapper;

import com.app.replace.dao.PositionDAO;
import com.app.replace.dto.PositionDTO;
import com.app.replace.dto.Search;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class MapperTests {
    @Autowired
    private PositionDAO positionDAO;
    @Autowired
    private PositionMapper positionMapper;

    @Test
    public void test(){
        Search search = new Search();
        search.setKeyword("마케팅");
//        log.info("{}.....",positionDAO.findAll(search).toString());
        positionMapper.selectAllBySearch(search).stream().map(PositionDTO::toString).forEach(log::info);
//        log.info(positionMapper.selectAllBySearch(search).toString());
    }
}

