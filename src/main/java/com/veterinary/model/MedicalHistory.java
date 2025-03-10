package com.veterinary.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class MedicalHistory {
    private List<String> records = new ArrayList<>();
    
    public void addRecord(String record) {
        records.add(record);
    }
}
