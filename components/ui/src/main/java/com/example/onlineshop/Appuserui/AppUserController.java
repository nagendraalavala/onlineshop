package com.example.onlineshop.Appuserui;


import com.perficient.onlineshop.appuser.AppUserRepo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
}

