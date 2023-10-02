package com.example.consumer;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class CustomerEvent {

    @Id
    private final Long id;

    private UUID identifier;
    private CustomerEventType type;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String email;

    public static CustomerEvent of(Long id, UUID identifier, CustomerEventType type, String firstName,
                            String lastName, LocalDate birthDate, String email) {
        return new CustomerEvent(null, identifier, type, firstName, lastName, birthDate, email);
    }

    @PersistenceCreator
    public CustomerEvent(Long id, UUID identifier, CustomerEventType type, String firstName,
                         String lastName, LocalDate birthDate, String email) {
        this.id = id;
        this.identifier = identifier;
        this.type = type;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.email = email;
    }

    public CustomerEvent(UUID identifier, CustomerEventType type, String firstName,
                         String lastName, LocalDate birthDate, String email) {
        this.id = null;
        this.identifier = identifier;
        this.type = type;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.email = email;
    }

    public CustomerEvent() {
        this.id = null;
    }

    public CustomerEvent withId(Long id) {
        return new CustomerEvent(id, identifier, type, firstName, lastName, birthDate, email);
    }

    public CustomerEventType getType() {
        return type;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getEmail() {
        return email;
    }

    public UUID getIdentifier() {
        return identifier;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "CustomerEvent{" +
                "type=" + type +
                ", id='" + id + '\'' +
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
