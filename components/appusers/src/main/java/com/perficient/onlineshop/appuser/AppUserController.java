package com.perficient.onlineshop.appuser;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class AppUserController {
    private AppUserRepo appUserRepo;

    public AppUserController(AppUserRepo appUserRepo) {
        this.appUserRepo = appUserRepo;
    }

    @GetMapping("/appusers")
    public String allAppUsers(Map<String,Object> model) {
        model.put("appusers", appUserRepo.findAll());
        return "appusers";
    }

    @GetMapping("/appuser")
    public String view(@RequestParam(name="id") String id, Map<String,Object> model) {
        model.put("appuser", appUserRepo.findById(Long.parseLong(id)).get());
        return "appuser";
    }
}

