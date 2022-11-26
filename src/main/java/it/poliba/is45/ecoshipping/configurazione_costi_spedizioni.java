package it.poliba.is45.ecoshipping;

import java.persistence.Entity;
import java.persistence.GeneratedValue;
import java.persistence.GenerationType;
import java.persistence.Id;

@Entity
public class configurazione_costi_spedizioni {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    
    private float costo_100_grammi; // Il costo della spedizione aumenta ogni 100 grammi
    private float costo_KM; // Il costo della spedizione viene elaborato in base ai Km percorsi
    
    public Float costo_100_grammi() {
        return costo_100_grammi;
    }

    public void setcosto_100_grammi(Float costo_100_grammi) {
        this.costo_100_grammi = costo_100_grammi;
    }
    
    public Float costo_KM() {
        return costo_KM;
    }

    public void setcosto_KM(Float costo_KM) {
        this.costo_KM = costo_KM;
    }

    
    
}
