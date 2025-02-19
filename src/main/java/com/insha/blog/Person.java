package com.insha.blog;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

@Getter
@ToString
@EqualsAndHashCode
@Jacksonized
@Builder
public class Person {
    private final String id;
    private final String firstName;
    private final String lastName;
    private final Integer age;
    private final String gender;

    public Person(String id, String firstName, String lastName, Integer age, String gender) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
        if (firstName == null || firstName.isBlank()) {
            throw new IllegalArgumentException("First name cannot be null or blank");
        }
        if (lastName == null || lastName.isBlank()) {
            throw new IllegalArgumentException("Last name cannot be null or blank");
        }
        if (age != null && age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
    }
}