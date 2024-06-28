package com.test.one.web.model;

import com.test.one.repository.model.enums.DetailType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class WageDetailVo {
    private Long id;
    private String name;
    private DetailType type;
    private BigDecimal amount;
}
