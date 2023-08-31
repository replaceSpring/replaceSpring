package com.app.replace.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class ApplyVO {
    private long id;
    private long positionId;
    private long memberId;
    private String applyStatus;
}
