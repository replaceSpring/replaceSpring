package com.app.replace.controller;

import com.app.replace.dao.BigCategoryDAO;
import com.app.replace.dao.MemberDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/myPage/*")
public class myPageController {
    private final BigCategoryDAO bigCategoryDAO;
    private final MemberDAO memberDAO;


    @GetMapping("main")
    public String Main(Model model){
        model.addAttribute("categories", bigCategoryDAO.selectAll());
        model.addAttribute("member", memberDAO.select(1L));

        return "myPage";
    }
}
