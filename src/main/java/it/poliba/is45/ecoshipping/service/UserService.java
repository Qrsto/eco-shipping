package it.poliba.is45.ecoshipping.service;



import it.poliba.is45.ecoshipping.domain.Utente;

import java.util.List;

public interface UserService {
    public void saveUser(Utente user);
    public List<Object> isUserPresent(Utente user);
}