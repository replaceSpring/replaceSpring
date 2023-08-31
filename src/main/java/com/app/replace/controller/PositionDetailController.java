package com.app.replace.controller;

import com.app.replace.dao.*;
import com.app.replace.dto.PositionDTO;
import com.app.replace.vo.MemberVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/positionDetail/*")
public class PositionDetailController {

    private final BigCategoryDAO bigCategoryDAO;
    private final MemberDAO memberDAO;
    private final PositionDAO positionDAO;

    private final long session = 1L;
    private final long positionId = 1L;

    @GetMapping("detail")
    public String gotoDetail(@RequestParam("positionId") String positionId, Model model){
        PositionDTO positionDTO = positionDAO.select(Long.parseLong(positionId));

        log.info("position entered :  {}....", positionDTO.toString());
        return "detail-seat";
    }

}
