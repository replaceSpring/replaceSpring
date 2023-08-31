package com.app.replace.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class Search {
//    String type;
    private String keyword;
    private String order;

//    public String[] getTypes(){
//        return type.split("");
//    }
}
