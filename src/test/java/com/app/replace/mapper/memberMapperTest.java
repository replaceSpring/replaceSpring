package com.app.replace.mapper;

import com.app.replace.dao.MemberDAO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class memberMapperTest {
    @Autowired
    private MemberDAO memberDAO;
    @Test
    public void memberTest(){
        log.info("{}......", memberDAO.select(1L).toString());
    }


}
