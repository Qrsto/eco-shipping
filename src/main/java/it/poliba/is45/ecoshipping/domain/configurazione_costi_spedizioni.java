package it.poliba.is45.ecoshipping.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class configurazione_costi_spedizioni {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //aggiungere attrib (long) id
    private float costo_100_grammi; // Il costo della spedizione aumenta ogni 100 grammi
    private float costo_KM; // Il costo della spedizione viene elaborato in base ai Km percorsi

    public void setCosto_KM(float costo_KM) {
        this.costo_KM = costo_KM;
    }

    public void setCosto_100_grammi(float costo_100_grammi) {
        this.costo_100_grammi = costo_100_grammi;
    }

    public float getCosto_100_grammi() {
        return costo_100_grammi;
    }

    public float getCosto_KM() {
        return costo_KM;
    }
}
