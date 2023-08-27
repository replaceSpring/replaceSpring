package com.app.replace.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class MidCategoryDTO {
    private long id;
    private String midCategoryName;
    private long bigCategoryId;
    private String bigCategoryName;
}
