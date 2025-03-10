package com.veterinary.controller;

import com.veterinary.model.Administrator;
import com.veterinary.service.VeterinaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/veterinary")
public class VeterinaryController {

    @Autowired
    private VeterinaryService veterinaryService;

    @PostMapping("/register-admin")
    public String registerAdmin(@RequestBody Administrator admin) {
        veterinaryService.registerAdministrator(admin);
        return "Administrator registered successfully!";
    }

    @GetMapping("/admins")
    public List<Administrator> getAdministrators() {
        return veterinaryService.getAdministrators();
    }
}

