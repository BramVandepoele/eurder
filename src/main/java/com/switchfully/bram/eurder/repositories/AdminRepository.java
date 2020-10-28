package com.switchfully.bram.eurder.repositories;

import com.switchfully.bram.eurder.instances.person.Admin;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class AdminRepository {
    private static final Map<String, Admin> administrators = new HashMap<>();

    public AdminRepository(){
        addInitialAdmin();
    }

    public static Map<String, Admin> getAdministrators() {
        return administrators;
    }

    private void addInitialAdmin() {
        Admin admin = new Admin("Administrator" , "One", "admin1@eurder.com");
        administrators.put(admin.getId(), admin);
    }

    public Collection<Admin> getAll(){
        return new ArrayList<>(administrators.values());
    }
}
