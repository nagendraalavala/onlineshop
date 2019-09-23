package com.perficient.onlineshop;


import com.perficient.onlineshop.appuser.AppUserRepo;
import com.perficient.onlineshop.product.ProductRepo;
import com.perficient.onlineshop.transaction.TransRepo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {
    private AppUserRepo appUserRepo;
    private ProductRepo productRepo;
    private TransRepo transRepo;

    public RootController(AppUserRepo appUserRepo, ProductRepo productRepo, TransRepo transRepo) {
        this.appUserRepo = appUserRepo;
        this.productRepo = productRepo;
        this.transRepo = transRepo;
    }
    @GetMapping("/")
    public String rootPath()
    {
        return "home";
    }


}