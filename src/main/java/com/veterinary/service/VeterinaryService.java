package com.veterinary.service;

import com.veterinary.model.Administrator;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class VeterinaryService {
    private List<Administrator> administrators = new ArrayList<>();

    public void registerAdministrator(Administrator admin) {
        administrators.add(admin);
    }

    public List<Administrator> getAdministrators() {
        return administrators;
    }
}
