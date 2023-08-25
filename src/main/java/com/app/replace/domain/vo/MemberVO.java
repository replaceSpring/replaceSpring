package com.app.replace.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class MemberVO {
    private Long id;
    private String memberEmail;
    private String memberPassword;
    private String memberNickname;
    private String memberPhone;
    private String memberStatus;
}
