package com.app.replace.mapper;

import com.app.replace.dao.BigCategoryDAO;
import com.app.replace.dao.PositionDAO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
@Slf4j
public class CategoryMapperTest {
    @Autowired
    private PositionDAO positionDAO;
    @Test
    public void CategoryTest(){
        log.info("{}......",positionDAO.selectAllWithCompanyName().toString());
    }
}
