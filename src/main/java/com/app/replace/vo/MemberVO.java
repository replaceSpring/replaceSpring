package com.app.replace.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class MemberVO {
    private long id;
    private String memberEmail;
    private String memberPassword;
    private String memberNickname;
    private String memberPhone;
    private String memberStatus;

}
