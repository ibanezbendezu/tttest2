package com.test.one.web;

import com.test.one.service.WageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("wage-view")
public class WageController {

    private final WageService service;

    public WageController(WageService service) {
        this.service = service;
    }

    @GetMapping("{id}")
    public String showById(@PathVariable Long id, Model model){
        model.addAttribute("wage", this.service.getById(id, Boolean.TRUE));
        return "wage";
    }
}
