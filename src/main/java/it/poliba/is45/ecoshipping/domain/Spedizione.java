package it.poliba.is45.ecoshipping.domain;

import it.poliba.is45.ecoshipping.Enum.TipoStato;


import javax.persistence.*;
import java.sql.Time;
import java.util.Date;


@Entity
public class Spedizione {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_ordine;             //PK
    private int id_rider;              //FK
    @Column(name = "data_evasione")
    private Date dataEvasione;
    @Column(name = "ora_evasione")
    private Time oraEvasione;
    @Column(name = "tipo_stato")
    private TipoStato tipoStato;
    //Può essere anche null (se tipostato != "Non c..")
    @Column(name = "note_stato_nc")
    private String noteStatoNc;



    public Spedizione(Date data_evasione, Time ora_evasione, TipoStato tipo_stato, String note_stato_nc) {
        this.dataEvasione = data_evasione;
        this.oraEvasione = ora_evasione;
        this.tipoStato = tipo_stato;

        //controllo se lo stato è su non consegnato: se si prendo anche la nota_stato_nc altrimenti lo setto a null
        if (checkNonConsegnato(tipo_stato))
            this.noteStatoNc = note_stato_nc;

    }

    private boolean checkNonConsegnato (TipoStato tipo_stato) {
        return tipo_stato == TipoStato.NON_CONSEGNATO;
    }

    public Spedizione(int id_ordine, int id_rider, Date dataEvasione, Time oraEvasione, TipoStato tipoStato, String noteStatoNc) {
        this.id_ordine = id_ordine;
        this.id_rider = id_rider;
        this.dataEvasione = dataEvasione;
        this.oraEvasione = oraEvasione;
        this.tipoStato = tipoStato;
        this.noteStatoNc = noteStatoNc;
    }
}
