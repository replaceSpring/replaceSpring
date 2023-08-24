package com.app.replace.mapper;

import com.app.replace.dao.MemberDAO;
import com.app.replace.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class memberMapperTest {
    @Autowired
    private MemberDAO memberDAO;

    @Autowired
    private MemberVO memberVO;

    @Test
    public void memberTest(){
        log.info("{}......", memberDAO.select(1L).toString());
    }

    @Test
    public void memberUpdateTest(){
        memberVO = memberDAO.select(1L);
        memberVO.setMemberNickname("patrick0225");
        memberVO.setMemberPhone("01053156548");
        memberVO.setMemberEmail("myEmail@gmail.com");

        log.info("{}.....", memberVO.toString());

        memberDAO.update(memberVO);
    }


}
