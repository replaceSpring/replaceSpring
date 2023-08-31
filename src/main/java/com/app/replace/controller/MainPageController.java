package com.app.replace.controller;

import com.app.replace.dao.BigCategoryDAO;
import com.app.replace.dao.PositionDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/main/*")
public class MainPageController {
    private final BigCategoryDAO bigCategoryDAO;
    private final PositionDAO positionDAO;

    @GetMapping("main")
    public String Main(Model model){
        model.addAttribute("categories", bigCategoryDAO.selectAll());
        log.info("categories : {}", bigCategoryDAO.selectAll());
        model.addAttribute("positionsByOpenDate", positionDAO.selectAllByPositionOpenDate());
        log.info("positionsByOpenDate : {}", positionDAO.selectAllByPositionOpenDate());
        model.addAttribute("positionsByDueDate", positionDAO.selectAllByPositionDueDate());
        log.info("positionsByDueDate : {}", positionDAO.selectAllByPositionDueDate());

        log.info("main entered...");
        return "index";
    }




}
