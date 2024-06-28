package com.test.one.web.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class WageVo {
    private Long id;
    private LocalDate date;
    private List<WageDetailVo> detail;
    private Long employeeId;
    private EmployeeVo employee;
}
