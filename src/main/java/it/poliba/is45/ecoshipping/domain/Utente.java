package it.poliba.is45.ecoshipping.domain;


import javax.persistence.*;

@Entity
public class Utente {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_utente;
    private String nome;
    private String cognome;
    @Column(name = "indirizzo_residenza")
    private String indirizzoResidenza;  //applicarlo a tutte lentita
    private String citta;
    private String cap;
    private String data_nas;
    @Column(name = "num_telefono")
    private String numTelefono;
    private String password;
    private String IBAN;
    @Column(name = "tipo_utente")
    private String tipoUtente;
    @Column(name = "longitudine_rider")
    private double longitudineRider;
    @Column(name = "latitudine_rider")
    private double latitudineRider;
    @Column(name = "disponibilita_lavoro")
    private boolean disponibilitaLavoro;


    public Utente(Long id_utente, String nome, String cognome, String indirizzoResidenza, String citta, String cap, String data_nas, String numTelefono, String password, String IBAN, String tipoUtente, double longitudineRider, double latitudineRider, boolean disponibilitaLavoro) {
        this.id_utente = id_utente;
        this.nome = nome;
        this.cognome = cognome;
        this.indirizzoResidenza = indirizzoResidenza;
        this.citta = citta;
        this.cap = cap;
        this.data_nas = data_nas;
        this.numTelefono = numTelefono;
        this.password = password;
        this.IBAN = IBAN;
        this.tipoUtente = tipoUtente;
        this.longitudineRider = longitudineRider;
        this.latitudineRider = latitudineRider;
        this.disponibilitaLavoro = disponibilitaLavoro;
    }
}