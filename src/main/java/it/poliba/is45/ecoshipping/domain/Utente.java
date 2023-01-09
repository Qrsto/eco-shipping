package it.poliba.is45.ecoshipping.domain;


import it.poliba.is45.ecoshipping.enumeratives.TipoUtente;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthoritiesContainer;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
public class Utente {

    @SequenceGenerator(
            name = "users_sequence",
            sequenceName = "users_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "users_sequence"
    )
    @Column(name = "id_utente")
    private int idUtente;      //si incrementa da solo ogni volta che si registra un nuovo utente
    private String username;
    private String password;
    private String nome;
    private String cognome;
    private String email;



    @Column(name = "indirizzo_residenza")
    private String indirizzoResidenza;
    private String citta;
    private String cap;


    @Column(name = "data_nas")
    private Date dataNasc;
    @Column(name = "num_telefono")
    private String numTelefono;

    private String iban;

    /*@Enumerated(EnumType.STRING)
    @Column(name = "tipo_utente")
    private TipoUtente tipoUtente;*/

    @Column(name = "longitudine_rider")
    private double longitudineRider;
    @Column(name = "latitudine_rider")
    private double latitudineRider;
    @Column(name = "disponibilita_lavoro")
    private boolean disponibilitaLavoro;


    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "locked")
    private Boolean locked = false;

    @Column(name = "enabled")
    private Boolean enabled = true;


    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.name());
        return Collections.singletonList(authority);
    }


    public boolean isAccountNonExpired() {
        return true;
    }


    public boolean isAccountNonLocked() {
        return !locked;
    }


    public boolean isCredentialsNonExpired() {
        return true;
    }


    public boolean isEnabled() {
        return enabled;
    }

    //relazione 1:N (bidirezionale con spedizione)
    @OneToMany(mappedBy = "utente")
    private Set<Spedizione> spedizione;

    //relazione 1:N (bidirezionale con tabella intermedia Ordine)
    @OneToMany(mappedBy = "utente")
    private Set<Ordine> ordini;


}