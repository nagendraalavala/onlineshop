package com.example.onlineshop.Appuserui;


import com.perficient.onlineshop.appuser.AppUserRepo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class AppUserController {
    private AppuserClient appuserClient;

    public AppUserController(AppuserClient appuserClient) {
        this.appuserClient = appuserClient;
    }

    @GetMapping("/appusers")
    public String allAppUsers(Map<String,Object> model) {
        model.put("appusers", appuserClient.getAll());
        return "appusers";
    }

    @GetMapping("/appuser")
    public String view(@RequestParam(name="id") String id, Map<String,Object> model) {
        model.put("appuser", appUserRepo.findById(Long.parseLong(id)).get());
        return "appuser";
    }
}

