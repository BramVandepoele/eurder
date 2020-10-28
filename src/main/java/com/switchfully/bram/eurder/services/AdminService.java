package com.switchfully.bram.eurder.services;

import com.switchfully.bram.eurder.instances.person.Admin;
import com.switchfully.bram.eurder.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class AdminService {

    private final AdminRepository adminRepository;

    @Autowired
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public Collection<Admin> getAll() {
        return adminRepository.getAll();
    }
}
