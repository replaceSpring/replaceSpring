package com.app.replace.controller;

import com.app.replace.dto.PositionDTO;
import com.app.replace.dto.Search;
import com.app.replace.service.SearchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/positions/api/*")
@RequiredArgsConstructor
public class PositionAPI {
    private final SearchService searchService;
    @GetMapping("list")
    public List<PositionDTO> getList(Search search){
        log.info("search keyword : {}", search.toString());
        return searchService.getList(search);
    }
}
