package com.example.onlineshop;


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

//    @GetMapping("/setup")
//    public String setupDatabase(Map<String, Object> model, AppUserInitialList appUserInitialList, ProductInitialList productInitialList, TransactionInitialList transactionInitialList) {
//        appUserInitialList.asList().forEach(appUserRepo::save);
//        productInitialList.asList().forEach(productRepo::save);
//        transactionInitialList.asList().forEach(transRepo::save);
//        model.put("appusers", appUserRepo.findAll());
//        model.put("products", productRepo.findAll());
//        model.put("transactions", transRepo.findAll());
//        return "setup";
//    }

}
