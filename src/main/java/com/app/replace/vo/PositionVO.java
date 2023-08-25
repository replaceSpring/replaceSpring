package com.app.replace.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class PositionVO {
    private long id;
    private long companyId;
    private String positionName;
    private String positionInfo;
    private String positionDueDate;
    private String positionOpenDate;
    private String positionStatus;
    private long midCategoryId;
}
