package com.perficient.onlineshop;


import com.perficient.onlineshop.appuserui.AppUserClient;
import com.perficient.onlineshop.productui.ProductClient;
import com.perficient.onlineshop.transactionui.TransactionClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {
    private AppUserClient appUserClient;
    private ProductClient productClient;
    private TransactionClient transactionClient;

    public RootController(AppUserClient appUserClient, ProductClient productClient, TransactionClient transactionClient) {
        this.appUserClient = appUserClient;
        this.productClient = productClient;
        this.transactionClient = transactionClient;
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
