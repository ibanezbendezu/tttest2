package com.test.one.service;

import com.test.one.web.model.WageVo;

public interface WageService {
    WageVo getById(Long id, boolean withEmployee);
}
