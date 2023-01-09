package it.poliba.is45.ecoshipping.domain;


public enum Role {
    USER("User"),
    RIDER("Rider"),
    ADMIN("Admin");


    private final String value;

    private Role(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}