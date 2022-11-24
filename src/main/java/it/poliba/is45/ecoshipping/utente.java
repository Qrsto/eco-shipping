package it.poliba.is45.ecoshipping;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class utente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_utente;
    private String nome;
    private String cognome;
    private String indirizzo_residenza;
    private String citta;
    private String cap;
    private String data_nas;
    private String num_telefono;
    private String password;
    private String IBAN;
    private String tipo_utente;
    private double longitudine_rider;
    private double latitudine_rider;
    private boolean disponibilita_lavoro;

    public Long getId_utente() {
        return id_utente;
    }

    public void setId_utente(Long id_utente) {
        this.id_utente = id_utente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getIndirizzo_residenza() {
        return indirizzo_residenza;
    }

    public void setIndirizzo_residenza(String indirizzo_residenza) {
        this.indirizzo_residenza = indirizzo_residenza;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public String getCap() {
        return cap;
    }

    public void setCap(String cap) {
        this.cap = cap;
    }

    public String getData_nas() {
        return data_nas;
    }

    public void setData_nas(String data_nas) {
        this.data_nas = data_nas;
    }

    public String getNum_telefono() {
        return num_telefono;
    }

    public void setNum_telefono(String num_telefono) {
        this.num_telefono = num_telefono;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public String getTipo_utente() {
        return tipo_utente;
    }

    public void setTipo_utente(String tipo_utente) {
        this.tipo_utente = tipo_utente;
    }

    public double getLongitudine_rider() {
        return longitudine_rider;
    }

    public void setLongitudine_rider(double longitudine_rider) {
        this.longitudine_rider = longitudine_rider;
    }

    public double getLatitudine_rider() {
        return latitudine_rider;
    }

    public void setLatitudine_rider(double latitudine_rider) {
        this.latitudine_rider = latitudine_rider;
    }

    public boolean isDisponibilita_lavoro() {
        return disponibilita_lavoro;
    }

    public void setDisponibilita_lavoro(boolean disponibilita_lavoro) {
        this.disponibilita_lavoro = disponibilita_lavoro;
    }
}