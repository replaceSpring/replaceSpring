package com.app.replace.controller;

<<<<<<< HEAD
import com.app.replace.dao.BigCategoryDAO;
import com.app.replace.dao.MemberDAO;
import com.app.replace.dao.PositionDAO;
=======
import com.app.replace.dao.*;
import com.app.replace.vo.CompanyVO;
>>>>>>> 3cc62086bb56f45fb9d7ec4681bb912d7e54dbc4
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

<<<<<<< HEAD
import java.util.Map;
=======
import javax.swing.text.html.Option;
import java.util.Map;
import java.util.Optional;
>>>>>>> 3cc62086bb56f45fb9d7ec4681bb912d7e54dbc4

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/myPage/*")
public class MyPageController {
    private final BigCategoryDAO bigCategoryDAO;
    private final MemberDAO memberDAO;
<<<<<<< HEAD
    private final PositionDAO positionDAO;
=======
    private final ApplyDAO applyDAO;
    private final CompanyDAO companyDAO;
>>>>>>> 3cc62086bb56f45fb9d7ec4681bb912d7e54dbc4

    private final long session = 1L;

    @GetMapping("main")
    public String Main(Model model){
        MemberVO memberVO = memberDAO.select(session);
        model.addAttribute("categories", bigCategoryDAO.selectAll());
        model.addAttribute("member", memberVO);
<<<<<<< HEAD
        model.addAttribute("positions", positionDAO.selectAllWithCompanyName());
        log.info("main entered...");
=======
        model.addAttribute("positions", applyDAO.selectAll(session));
        try{
            if (companyDAO.select(session).isPresent()){
                model.addAttribute("company", companyDAO.select(session).get());
            }
        }catch (NullPointerException e){
            log.info(e.getMessage());
        }

>>>>>>> 3cc62086bb56f45fb9d7ec4681bb912d7e54dbc4
        return "myPage";
    }

    @PostMapping("update")
    public RedirectView update(@RequestParam Map<String,Object> map){
        MemberVO memberVO = memberDAO.select(session);
        memberVO.setMemberPhone((String)map.get("phone"));
        memberVO.setMemberNickname((String)map.get("nickname"));
        memberVO.setMemberPassword((String)map.get("password"));

<<<<<<< HEAD
        log.info("{} : {}…….","update",memberVO.toString());
        memberDAO.update(memberVO);

        return new RedirectView("/myPage/main");
    }
}
=======

        try{
            CompanyVO companyVO = companyDAO.select(session).get();
            companyVO.setCompanyVarificationCode((String)map.get("ccode"));
            companyVO.setCompanyName((String)map.get("cname"));
            companyDAO.update(companyVO);
        }catch (Exception e){
            log.info("not a company member");
            if ((String)map.get("cname")!=null && (String)map.get("ccode") != null) {
                CompanyVO companyVO = new CompanyVO();
                companyVO.setMemberId(session);
                companyVO.setCompanyVarificationCode((String)map.get("ccode"));
                companyVO.setCompanyName((String)map.get("cname"));
                log.info(companyVO.toString());
                companyDAO.insert(companyVO);
            }
        }

        memberDAO.update(memberVO);


        return new RedirectView("/myPage/main");
    }


    @PostMapping("remove")
    public RedirectView bookmarkRemove(@RequestParam Map<String,Object> map){

        log.info("{} : {}.......","remove",(String)map.get("pId"));

        return new RedirectView("/myPage/main");
    }

}
>>>>>>> 3cc62086bb56f45fb9d7ec4681bb912d7e54dbc4
