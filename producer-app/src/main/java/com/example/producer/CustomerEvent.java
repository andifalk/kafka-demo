package com.example.producer;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class CustomerEvent {

    private final UUID identifier;
    private CustomerEventType type;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String email;

    public CustomerEvent(UUID identifier, CustomerEventType type, String firstName,
                         String lastName, LocalDate birthDate, String email) {
        this.identifier = identifier;
        this.type = type;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.email = email;
    }

    public CustomerEvent() {
        this.identifier = UUID.randomUUID();
    }

    public CustomerEventType getType() {
        return type;
    }

    public void setType(CustomerEventType type) {
        this.type = type;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UUID getIdentifier() {
        return identifier;
    }

    @Override
    public String toString() {
        return "CustomerEvent{" +
                "type=" + type +
                ", identifier='" + identifier + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerEvent that = (CustomerEvent) o;
        return Objects.equals(identifier, that.identifier) && type == that.type && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(birthDate, that.birthDate) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identifier, type, firstName, lastName, birthDate, email);
    }
}
