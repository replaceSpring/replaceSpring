package com.app.replace.mapper;


import com.app.replace.dao.*;
import com.app.replace.dto.ApplyDTO;
import com.app.replace.dto.BookmarkDTO;
import com.app.replace.dto.MidCategoryDTO;
import com.app.replace.vo.MidCategoryVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class MapperTests {
    @Autowired
    private PositionDAO positionDAO;

    @Test
    public void test(){
        log.info("{}.....",positionDAO.selectByBigCategoryId(1L).toString());

    }
}
