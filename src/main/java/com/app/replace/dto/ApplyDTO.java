package com.app.replace.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class ApplyDTO {
    private long id;
    private long positionId;
    private long memberId;
    private String positionName;
    private String positionInfo;
    private String positionDueDate;
    private String positionOpenDate;
    private String positionStatus;
    private String companyName;
    private String midCategoryName;
    private String applyStatus;

}
