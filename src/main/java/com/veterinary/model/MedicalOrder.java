package com.veterinary.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MedicalOrder {
    private String orderId;
    private String petId;
    private String ownerId;
    private String veterinarianId;
    private String medicine;
    private String dosage;
    private String date;
    private boolean isCancelled;
}
