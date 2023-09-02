package com.app.replace.mapper;

import com.app.replace.dao.PositionDAO;
import com.app.replace.dto.PositionDTO;
import com.app.replace.dto.Search;

import com.app.replace.dao.*;
import com.app.replace.vo.ApplyVO;
import com.app.replace.vo.PositionVO;
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
    private ApplyDAO applyDAO;

    @Test
    public void Test1(){
        PositionVO positionVO = new PositionVO();

        positionVO.setCompanyId(1L);
        positionVO.setMidCategoryId(1L);
        positionVO.setPositionDueDate("2000-01-01");
        positionVO.setPositionOpenDate("1999-12-12");
        positionVO.setPositionName("test name");
        positionVO.setPositionInfo("test info");

        positionDAO.insert(positionVO);
    }

    @Test
    public void Test2(){
        positionDAO.selectAllByMemberId(1L).forEach((p)->{
            log.info("position : {}............", p.toString());
        });
    }

    @Test
    public void Test3(){
        applyDAO.deleteByPositionId(182L);
    }

    @Test
    public void test4(){
        positionDAO.deletePositionById(182L);
    }

    @Test
    public void test5(){
        ApplyVO applyVO = new ApplyVO();
        applyVO.setApplyStatus("invited");
        applyVO.setMemberId(1L);
        applyVO.setPositionId(182);
//        applyDAO.insert(applyVO);
        log.info("check apply : {}", applyDAO.check(applyVO));
    }

}

