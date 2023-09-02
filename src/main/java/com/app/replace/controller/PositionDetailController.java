package com.app.replace.controller;

import com.app.replace.dao.*;
import com.app.replace.dto.PositionDTO;
import com.app.replace.vo.ApplyVO;
import com.app.replace.vo.MemberVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/positionDetail/*")
public class PositionDetailController {

    private final BigCategoryDAO bigCategoryDAO;
    private final MemberDAO memberDAO;
    private final PositionDAO positionDAO;
    private final ApplyDAO applyDAO;

//    private final long session = 1L;
    private final HttpSession session;

    @GetMapping("detail")
    public String gotoDetail(@RequestParam("positionId") String positionId, Model model){
        PositionDTO positionDTO = positionDAO.select(Long.parseLong(positionId));
        MemberVO memberVO = memberDAO.select((Long)session.getAttribute("id"));
        positionDTO.setPositionOpenDate(positionDTO.getPositionOpenDate().split(" ")[0].replace("-","/"));
        positionDTO.setPositionDueDate(positionDTO.getPositionDueDate().split(" ")[0].replace("-","/"));
        model.addAttribute("position", positionDTO);
        log.info("position entered :  {}....", positionDTO.toString());
        model.addAttribute("member", memberVO);
        log.info("member entered : {}....", memberVO);
        return "detail-seat";
    }

    @PostMapping("bookmark")
    @ResponseBody
    public void bookmarked(@RequestParam Map<String,Object> map){

        ApplyVO applyVO = new ApplyVO();
        applyVO.setMemberId(Long.parseLong((String)map.get("mId")));
        applyVO.setPositionId(Long.parseLong((String)map.get("pId")));
        applyVO.setApplyStatus((String)map.get("status"));
        if (!applyDAO.check(applyVO)){
            applyDAO.insert(applyVO);
        }else{
            applyDAO.deleteByPositionAndMemberId(applyVO);
        }
        log.info(applyVO.toString());

    }

}
