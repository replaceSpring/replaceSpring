package com.app.replace.controller;

import com.app.replace.domain.vo.MemberVO;
import com.app.replace.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/member/*")
public class MemberController {
    private final MemberService memberService;

    //    아이디 중복검사
    @GetMapping("check-email/{memberEmail}")
    @ResponseBody
    public boolean checkId(@PathVariable String memberEmail){
        return memberService.checkEmail(memberEmail).isPresent();
    }

    //    회원가입
    @GetMapping("join")
    public void goToJoinForm(MemberVO memberVO){;}

    @PostMapping("join")
    public RedirectView join(MemberVO memberVO){
        memberService.join(memberVO);
        return new RedirectView("/member/login");
    }

    @GetMapping("login")
    public void login(MemberVO memberVO){;}

    @PostMapping("login")
    public RedirectView login(String memberEmail, String memberPassword, HttpSession session, RedirectAttributes redirectAttributes) {
        final Optional<Long> foundMember = memberService.login(memberEmail, memberPassword);
        if(foundMember.isPresent()){
            session.setAttribute("id", foundMember.get());

            // 이메일이 "sld@gmail.com"인 경우 admin 페이지로 리디렉션하고, 그 외의 경우 main 페이지로 리디렉션합니다.
            if (memberEmail.equals("HGD1234@naver.com")) {
                return new RedirectView("/admin/member/memberList");
            } else {
                return new RedirectView("/main");
            }
        }
        redirectAttributes.addFlashAttribute("login", "fail");
        return new RedirectView("/member/login");
    }


    @GetMapping("logout")
    public RedirectView logout(HttpSession session){
        session.invalidate();
        return new RedirectView("/main");
    }



}

