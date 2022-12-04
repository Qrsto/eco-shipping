package it.poliba.is45.ecoshipping.domain;


import it.poliba.is45.ecoshipping.Enum.TipoUtente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Utente {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_utente;
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
    private TipoUtente tipoUtente;
    @Column(name = "longitudine_rider")
    private double longitudineRider;
    @Column(name = "latitudine_rider")
    private double latitudineRider;
    @Column(name = "disponibilita_lavoro")
    private boolean disponibilitaLavoro;




}