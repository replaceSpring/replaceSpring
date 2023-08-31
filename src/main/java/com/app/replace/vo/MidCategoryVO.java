package com.app.replace.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class MidCategoryVO {
    private long id;
    private String midCategoryName;
    private long bigCategoryId;

}
