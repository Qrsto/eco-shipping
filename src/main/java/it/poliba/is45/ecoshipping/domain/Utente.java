package it.poliba.is45.ecoshipping.domain;


import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
public class Utente  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_utente")
    private int idUtente;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "nome")
    private String nome;
    @Column(name = "cognome")
    private String cognome;
    @Column(name = "email")
    private String email;
    @Column(name = "indirizzo_residenza")
    private String indirizzoResidenza;
    @Column(name = "citta")
    private String citta;
    @Column(name = "cap")
    private String cap;
    @Column(name = "data_nas")
    private Date dataNasc;
    @Column(name = "num_telefono")
    private String mobile;
    @Column(name = "iban")
    private String iban;
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
    @Column(name = "locked")
    private Boolean locked = false;
    @Column(name = "enabled")
    private Boolean enabled = true;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(  name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();



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

    public Utente(String username, String email, String password){
        this.username= username;
        this.email=email;
        this.password=password;
    }

    public boolean getDisponibilitaLavoro() {
        return this.disponibilitaLavoro;
    }
}