package com.veterinary.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Veterinarian extends Person {
    private String username;
    private String password;
}
