package com.example.onlineshop.Appuserui;

import com.perficient.onlineshop.appuser.AppUser;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class AppUserInitialList {

    public List<AppUser> asList() {
        return Arrays.asList(new AppUser("Kaitlyn","ks@gmail.com","1234", "Columbus"),
                new AppUser("Bob","bb@gmail.com","pass", "Detroit"),
                new AppUser("Steve","steve@gmail.com","password", "New York"),
                new AppUser("Karen","karen@gmail.com","1234", "Dayton")
        );
    }
}
