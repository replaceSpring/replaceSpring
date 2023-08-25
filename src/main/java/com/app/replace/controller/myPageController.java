package com.app.replace.controller;

import com.app.replace.dao.BigCategoryDAO;
import com.app.replace.dao.MemberDAO;
import com.app.replace.dao.PositionDAO;
import com.app.replace.vo.MemberVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Map;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/myPage/*")
public class myPageController {
    private final BigCategoryDAO bigCategoryDAO;
    private final MemberDAO memberDAO;
    private final PositionDAO positionDAO;

    private final long session = 1L;

    @GetMapping("main")
    public String Main(Model model){
        MemberVO memberVO = memberDAO.select(session);
        model.addAttribute("categories", bigCategoryDAO.selectAll());
        model.addAttribute("member", memberVO);
        model.addAttribute("positions", positionDAO.selectAllWithCompanyName());
        log.info("main entered...");
        return "myPage";
    }

    @PostMapping("update")
    public RedirectView update(@RequestParam Map<String,Object> map){
        MemberVO memberVO = memberDAO.select(session);
        memberVO.setMemberPhone((String)map.get("phone"));
        memberVO.setMemberNickname((String)map.get("nickname"));
        memberVO.setMemberPassword((String)map.get("password"));

        log.info("{} : {}.......","update",memberVO.toString());
        memberDAO.update(memberVO);

        return new RedirectView("/myPage/main");
    }
}
