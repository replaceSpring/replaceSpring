package com.app.replace.controller;

import com.app.replace.dao.BigCategoryDAO;
import com.app.replace.dao.MemberDAO;
import com.app.replace.dao.PositionDAO;
import com.app.replace.dao.*;
import com.app.replace.dto.PositionDTO;
import com.app.replace.vo.ApplyVO;
import com.app.replace.vo.CompanyVO;
import com.app.replace.vo.MemberVO;
import com.app.replace.vo.PositionVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpSession;
import java.util.List;
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

//    private final long session = 1L;

    private final HttpSession session;


    @GetMapping("main")
    public String Main(Model model){
        MemberVO memberVO = memberDAO.select((Long)session.getAttribute("id"));

        model.addAttribute("categories", bigCategoryDAO.selectAll());
        model.addAttribute("member", memberVO);
//        model.addAttribute("positions", positionDAO.selectAllWithCompanyName());
        model.addAttribute("midCategories", midCategoryDAO.selectAll());
        model.addAttribute("positions", applyDAO.selectAll((Long)session.getAttribute("id")));
//        model.addAttribute("positions", positionDAO.selectFavorites((Long)session.getAttribute("id")));


        if (companyDAO.selectCompanyCount((Long)session.getAttribute("id")) > 0){
            model.addAttribute("company", companyDAO.select((Long)session.getAttribute("id")).get());
        }

        if (positionDAO.selectPositionCountByMemberId((Long)session.getAttribute("id")) > 0){
            List<PositionDTO> positionDTOList = positionDAO.selectAllByMemberId((Long)session.getAttribute("id"));
            positionDTOList.forEach((pos)->{
                pos.setPositionDueDate(pos.getPositionDueDate().split(" ")[0].replace("-","/"));
                pos.setPositionOpenDate(pos.getPositionOpenDate().split(" ")[0].replace("-","/"));
            });
            model.addAttribute("myPositions", positionDTOList);
        }

        return "myPage";
    }

    @PostMapping("update")
    public RedirectView update(@RequestParam Map<String,Object> map){
        MemberVO memberVO = memberDAO.select((Long)session.getAttribute("id"));
        memberVO.setMemberPhone((String)map.get("phone"));
        memberVO.setMemberNickname((String)map.get("nickname"));
        memberVO.setMemberPassword((String)map.get("password"));

        memberDAO.update(memberVO);


        if (companyDAO.selectCompanyCount((Long)session.getAttribute("id")) >= 1){
            CompanyVO companyVO = companyDAO.select((Long)session.getAttribute("id")).get();
            companyVO.setCompanyVarificationCode((String)map.get("ccode"));
            companyVO.setCompanyName((String)map.get("cname"));
            companyVO.setCompanyAddress((String)map.get("caddress"));
            companyDAO.update(companyVO);
        }else{
            log.info("not a company member");
            if ((String)map.get("cname")!=null && (String)map.get("ccode") != null) {
                CompanyVO companyVO = new CompanyVO();
                companyVO.setMemberId((Long)session.getAttribute("id"));
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

        PositionVO positionVO = new PositionVO();

        log.info("position information : {}",(String)map.get("pinfo"));
        log.info("position name : {}",(String)map.get("pname"));
        log.info("position open date : {}",(String)map.get("popen"));
        log.info("position end date : {}",(String)map.get("pend"));
        log.info("position mid category id : {}",(String)map.get("category"));
        log.info("position company id : {}",(String)map.get("cid"));

        positionVO.setPositionInfo((String)map.get("pinfo"));
        positionVO.setPositionName((String)map.get("pname"));
        positionVO.setPositionOpenDate((String)map.get("popen"));
        positionVO.setPositionDueDate((String)map.get("pend"));
        positionVO.setCompanyId(Long.parseLong((String)map.get("cid")));
        positionVO.setMidCategoryId(Long.parseLong((String)map.get("category")));
        log.info("{}...........", positionVO);
        positionDAO.insert(positionVO);
        return new RedirectView("/myPage/main");
    }

    @PostMapping("removeApply")
    public RedirectView bookmarkRemove(@RequestParam Map<String,Object> map){
        ApplyVO applyVO = new ApplyVO();
        applyVO.setMemberId(Long.parseLong((String)map.get("mId")));
        applyVO.setPositionId(Long.parseLong((String)map.get("pId")));
        applyDAO.deleteByPositionAndMemberId(applyVO);
        return new RedirectView("/myPage/main");
    }

    @PostMapping("removePosition")
    public RedirectView PositionRemove(@RequestParam Map<String,Object> map){
        positionDAO.deletePositionById(Long.parseLong((String)map.get("pId")));

        return new RedirectView("/myPage/main");
    }

}
