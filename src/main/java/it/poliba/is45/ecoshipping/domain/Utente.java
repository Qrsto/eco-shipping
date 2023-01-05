package it.poliba.is45.ecoshipping.domain;


import it.poliba.is45.ecoshipping.enumeratives.TipoUtente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthoritiesContainer;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Utente {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_utente")
    private int idUtente;        //PK
    private String username;
    private String nome;
    private String cognome;
    @Column(name = "indirizzo_residenza")
    private String indirizzoResidenza;
    private String citta;
    private String cap;
    @Column(name = "data_nas")
    private Date dataNasc;
    @Column(name = "num_telefono")
    private String numTelefono;
    private String password;
    private String iban;
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_utente")
    private TipoUtente tipoUtente;
    @Column(name = "longitudine_rider")
    private double longitudineRider;
    @Column(name = "latitudine_rider")
    private double latitudineRider;
    @Column(name = "disponibilita_lavoro")
    private boolean disponibilitaLavoro;


    //relazione 1:N (bidirezionale con spedizione)
    @OneToMany(mappedBy = "utente")
    private Set<Spedizione> spediziones;

    //relazione M:N (bidirezionale con tabella intermedia UtenteOrdini)
    @ManyToMany(mappedBy = "clienti")
    private Set<Ordine> ordines;



    public Collection<? extends GrantedAuthority> getAutorities(){
        return List.of(new SimpleGrantedAuthority("ADMIN"));
    }

}