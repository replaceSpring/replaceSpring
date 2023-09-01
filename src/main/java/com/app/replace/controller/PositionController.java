package com.app.replace.controller;

import com.app.replace.dto.Search;
import com.app.replace.service.SearchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/position/*")
public class PositionController {
    private final SearchService searchService;

    @GetMapping("list")
    public String list(Search search, Model model){
        model.addAttribute("positions", searchService.getList(search));
        log.info(searchService.getList(search).toString());
        return "list";
    }

}
