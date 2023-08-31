package com.app.replace.controller;

import com.app.replace.dto.PositionDTO;
import com.app.replace.dto.Search;
import com.app.replace.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/positions/api/*")
@RequiredArgsConstructor
public class PositionAPI {
    private final SearchService searchService;
    @GetMapping("list")
    public List<PositionDTO> getList(Search search){
        return searchService.getList(search);
    }
}
