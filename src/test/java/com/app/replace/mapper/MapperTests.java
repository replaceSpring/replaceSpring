package com.app.replace.mapper;


import com.app.replace.dao.*;
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

    @Test
    public void test(){
        log.info("{}.......", positionDAO.select(1L).toString());
    }
}
