package com.app.replace.controller;

import com.app.replace.dao.BigCategoryDAO;
import com.app.replace.dao.MemberDAO;
import com.app.replace.dao.PositionDAO;
import com.app.replace.dao.*;
import com.app.replace.vo.CompanyVO;
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
import java.util.Optional;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/myPage/*")
public class MyPageController {
    private final BigCategoryDAO bigCategoryDAO;
    private final MidCategoryDAO midCategoryDAO;
    private final MemberDAO memberDAO;
    private final PositionDAO positionDAO;
    private final ApplyDAO applyDAO;
    private final CompanyDAO companyDAO;

    private final long session = 1L;

    @GetMapping("main")
    public String Main(Model model){
        MemberVO memberVO = memberDAO.select(session);
        model.addAttribute("categories", bigCategoryDAO.selectAll());
        model.addAttribute("member", memberVO);
        model.addAttribute("positions", positionDAO.selectAllWithCompanyName());
        model.addAttribute("midCategories", midCategoryDAO.selectAll());

        log.info("main entered member No.{}...", memberVO.getId());
        model.addAttribute("positions", applyDAO.selectAll(session));
  
        if (companyDAO.selectCompanyCount(session) >=1){
            model.addAttribute("company", companyDAO.select(session).get());
        }
        return "myPage";
    }

    @PostMapping("update")
    public RedirectView update(@RequestParam Map<String,Object> map){
        MemberVO memberVO = memberDAO.select(session);
        memberVO.setMemberPhone((String)map.get("phone"));
        memberVO.setMemberNickname((String)map.get("nickname"));
        memberVO.setMemberPassword((String)map.get("password"));

        memberDAO.update(memberVO);


        if (companyDAO.selectCompanyCount(session) >= 1){
            CompanyVO companyVO = companyDAO.select(session).get();
            companyVO.setCompanyVarificationCode((String)map.get("ccode"));
            companyVO.setCompanyName((String)map.get("cname"));
            companyVO.setCompanyAddress((String)map.get("caddress"));
            companyDAO.update(companyVO);
        }else{
            log.info("not a company member");
            if ((String)map.get("cname")!=null && (String)map.get("ccode") != null) {
                CompanyVO companyVO = new CompanyVO();
                companyVO.setMemberId(session);
                companyVO.setCompanyVarificationCode((String)map.get("ccode"));
                companyVO.setCompanyName((String)map.get("cname"));
                companyVO.setCompanyAddress((String)map.get("caddress"));
                companyDAO.insert(companyVO);
            }
        }

        return new RedirectView("/myPage/main");
    }
    @PostMapping("register")
    public RedirectView register(@RequestParam Map<String,Object> map){
        log.info((String)map.get("pinfo"));
        log.info((String)map.get("pname"));
        log.info((String)map.get("popen"));
        log.info((String)map.get("pend"));

        return new RedirectView("/myPage/main");
    }

    @PostMapping("remove")
    public RedirectView bookmarkRemove(@RequestParam Map<String,Object> map){

        log.info("{} : {}.......","remove",(String)map.get("pId"));


        return new RedirectView("/myPage/main");
    }

}
