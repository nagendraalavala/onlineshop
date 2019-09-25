package com.perficient.onlineshop.appuserui;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

@Controller
public class AppUserController {
    private AppUserClient appUserClient;

    public AppUserController(AppUserClient appuserClient) {
        this.appUserClient = appuserClient;
    }

    @GetMapping("/appusers")
    public String allAppUsers(Map<String,Object> model) {
        model.put("appusers", appUserClient.getAll());
        return "appusers";
    }

    @GetMapping("/appusers/{id}")
    public String getUser(Map<String,Object> model, @PathVariable Long id) {
        model.put("viewuser", appUserClient.view(id));
        return "viewuser";
    }
//
//    @GetMapping("/appuser")
//    public String view(@RequestParam(name="id") String id, Map<String,Object> model) {
//        model.put("appuser", appuserClient.findById(Long.parseLong(id)).get());
//        return "appuser";
//    }
}

