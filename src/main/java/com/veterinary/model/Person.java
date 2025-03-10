package com.veterinary.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public abstract class Person {
    private String id;
    private String name;
    private int age;
    private String role;
}
