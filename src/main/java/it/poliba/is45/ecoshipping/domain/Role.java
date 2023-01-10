package it.poliba.is45.ecoshipping.domain;


public enum Role {
    ROLE_USER("User"),
    ROLE_RIDER("Rider"),
    ROLE_ADMIN("Admin");


    private final String value;

    private Role(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}