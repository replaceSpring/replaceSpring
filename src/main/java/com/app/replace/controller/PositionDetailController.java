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

    private final long session = 21L;

    @GetMapping("detail")
    public String gotoDetail(@RequestParam("positionId") String positionId, Model model){
        PositionDTO positionDTO = positionDAO.select(Long.parseLong(positionId));
        MemberVO memberVO = memberDAO.select(session);
        positionDTO.setPositionOpenDate(positionDTO.getPositionOpenDate().split(" ")[0].replace("-","/"));
        positionDTO.setPositionDueDate(positionDTO.getPositionDueDate().split(" ")[0].replace("-","/"));
        model.addAttribute("position", positionDTO);
        log.info("position entered :  {}....", positionDTO.toString());
        model.addAttribute("member", memberVO);
        log.info("member entered : {}....", memberVO);
        return "detail-seat";
    }

}
