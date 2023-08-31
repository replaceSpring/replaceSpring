package com.app.replace.mapper;

<<<<<<< HEAD
import com.app.replace.dao.PositionDAO;
import com.app.replace.dto.PositionDTO;
import com.app.replace.dto.Search;
=======

import com.app.replace.dao.*;
>>>>>>> 3cc62086bb56f45fb9d7ec4681bb912d7e54dbc4
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@Slf4j
public class MapperTests {
    @Autowired
    private PositionDAO positionDAO;
    @Autowired
    private PositionMapper positionMapper;

<<<<<<< HEAD
    @Test
    public void test(){
        Search search = new Search();
        search.setKeyword("마케팅");
//        log.info("{}.....",positionDAO.findAll(search).toString());
        positionMapper.selectAllBySearch(search).stream().map(PositionDTO::toString).forEach(log::info);
//        log.info(positionMapper.selectAllBySearch(search).toString());
=======
    @Autowired
    private PositionDAO positionDAO;

    @Test
    public void test(){
        log.info("{}.......", positionDAO.select(1L).toString());
>>>>>>> 3cc62086bb56f45fb9d7ec4681bb912d7e54dbc4
    }
}

