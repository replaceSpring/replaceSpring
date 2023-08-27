package com.app.replace.controller;


import com.app.replace.dao.BigCategoryDAO;
import com.app.replace.dao.MidCategoryDAO;
import com.app.replace.dao.PositionDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;


@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/positionList/*")
public class PositionListController {
    private final MidCategoryDAO midCategoryDAO;
    private final BigCategoryDAO bigCategoryDAO;
    private final PositionDAO positionDAO;

    @GetMapping("main")
    public String gotoPositionList(Model model){
        long bigCategoryId = 1L;
        model.addAttribute("bigCategory", bigCategoryDAO.selectById(bigCategoryId));
        model.addAttribute("categories", bigCategoryDAO.selectAll());
        model.addAttribute("midCategoryList", midCategoryDAO.selectById(bigCategoryId));
        model.addAttribute("positions", positionDAO.selectByBigCategoryId(bigCategoryId));
        return "category";
    }

    @GetMapping("positions")
    public String gotoList(@RequestParam Map<String,Object> map, Model model){
        log.info("{}.......................",Long.parseLong((String)map.get("cid")));
        long bigCategoryId = Long.parseLong((String)map.get("cid"));
        model.addAttribute("bigCategory", bigCategoryDAO.selectById(bigCategoryId));
        model.addAttribute("categories", bigCategoryDAO.selectAll());
        model.addAttribute("midCategoryList", midCategoryDAO.selectById(bigCategoryId));
        model.addAttribute("positions", positionDAO.selectByBigCategoryId(bigCategoryId));
        log.info("category entered");
        return "category";
    }
}
