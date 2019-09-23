package com.perficient.onlineshop.transaction;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class TransController {
    private TransRepo transRepo;

    public TransController(TransRepo transRepo) {
        this.transRepo = transRepo;
    }
    @GetMapping("/transactions")
    public String allTransactions(Map<String,Object> model) {
        model.put("transactions", transRepo.findAll());
        return "transactions";
    }
}

