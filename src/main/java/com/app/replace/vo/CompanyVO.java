package com.app.replace.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class CompanyVO {
    private long id;
    private String companyName;
    private String companyVarificationCode;
    private long memberId;
}
