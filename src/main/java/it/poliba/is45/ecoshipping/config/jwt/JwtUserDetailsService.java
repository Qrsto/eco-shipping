package it.poliba.is45.ecoshipping.config.jwt;

import java.util.ArrayList;
import java.util.List;

import it.poliba.is45.ecoshipping.domain.Role;
import it.poliba.is45.ecoshipping.domain.Utente;
import it.poliba.is45.ecoshipping.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UtenteRepository utenteRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Utente utente= utenteRepository.findByUsername(username);
        if (utente==null){
                throw new UsernameNotFoundException("User not found with username: " + utente);}
                else {
            List<GrantedAuthority> role = new ArrayList<>();
            role.add(new SimpleGrantedAuthority(utente.getRole().toString()));
            return new User(utente.getUsername(), utente.getPassword(), role);
        }

    }
    }

