package com.test.one.service.impl;

import com.test.one.repository.WageRepository;
import com.test.one.repository.model.Wage;
import com.test.one.service.WageService;
import com.test.one.web.model.EmployeeVo;
import com.test.one.web.model.WageDetailVo;
import com.test.one.web.model.WageVo;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.stream.Collectors;

@Service
public class WageServiceImpl implements WageService {

    private final WageRepository repo;

    public WageServiceImpl(WageRepository repo) {
        this.repo = repo;
    }

    @Override
    public WageVo getById(Long id, boolean withEmployee) {
        Wage wage = this.repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontró sueldo"));

        WageVo vo = new WageVo();
        vo.setId(wage.getId());
        vo.setDate(wage.getDate());
        vo.setDetail(wage.getDetail().stream().map(wd->{
            WageDetailVo detailVo = new WageDetailVo();
            detailVo.setId(wd.getId());
            detailVo.setName(wd.getName());
            detailVo.setType(wd.getType());
            detailVo.setAmount(wd.getAmount());
            return detailVo;
        }).collect(Collectors.toList()));
        vo.setEmployeeId(wage.getEmployee().getId());
        if (withEmployee) {
            EmployeeVo employeeVo = new EmployeeVo();
            employeeVo.setId(wage.getEmployee().getId());
            employeeVo.setName(wage.getEmployee().getName());
            employeeVo.setLastName(wage.getEmployee().getLastName());
            employeeVo.setDocumentId(wage.getEmployee().getDocumentId());
            vo.setEmployee(employeeVo);
        }
        return vo;
    }
}
