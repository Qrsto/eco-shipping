package it.poliba.is45.ecoshipping.domain;

import it.poliba.is45.ecoshipping.Enum.Tipo_stato;


import javax.persistence.*;
import java.sql.Time;
import java.util.Date;


@Entity
public class spedizione {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_ordine;             //PK
    private int id_rider;              //FK
    private Date data_evasione;
    private Time ora_evasione;
    private Tipo_stato tipo_stato;
    //Può essere anche null (se tipostato != "Non c..")
    private String note_stato_nc;



    public spedizione(Date data_evasione, Time ora_evasione, Tipo_stato tipo_stato, String note_stato_nc) {
        this.data_evasione = data_evasione;
        this.ora_evasione = ora_evasione;
        this.tipo_stato = tipo_stato;

        //controllo se lo stato è su non consegnato: se si prendo anche la nota_stato_nc altrimenti lo setto a null
        if (checkNonConsegnato(tipo_stato))
            this.note_stato_nc = note_stato_nc;


    }

    private boolean checkNonConsegnato (Tipo_stato tipo_stato) {
        return tipo_stato == Tipo_stato.NON_CONSEGNATO;
    }

    public int getId_ordine() {
        return id_ordine;
    }

    public int getId_rider() {
        return id_rider;
    }

    public Date getData_evasione() {
        return data_evasione;
    }

    public Time getOra_evasione() {
        return ora_evasione;
    }

    public Tipo_stato getTipo_stato() {
        return tipo_stato;
    }

    public String getNote_stato_nc() {
        return note_stato_nc;
    }



     //   domande: costruttore si omette? metodiSet degli attributi (y,n) ? metodo riga38 check.. è utile??

}
