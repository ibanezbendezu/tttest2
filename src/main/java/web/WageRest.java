package com.test.one.web;

import com.test.one.service.WageService;
import com.test.one.web.model.WageVo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("wage")
public class WageRest {
    private final WageService service;

    public WageRest(WageService service) {
        this.service = service;
    }

    @GetMapping("{id}")
    private ResponseEntity<WageVo> getById(
            @PathVariable Long id,
            @RequestParam(required = false, defaultValue = "false") Boolean withEmployee
    ) {
        return ResponseEntity.ok(this.service.getById(id, withEmployee));
    }
}
