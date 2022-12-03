package it.poliba.is45.ecoshipping.domain;

import javax.persistence.*;

@Entity
public class TabellaConfigurazione {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
@Column(name = "costo_100_grammi")
    private float costo100Grammi;
    @Column(name = "costo_km")
    private float costoKM;

    public TabellaConfigurazione(float costo100Grammi, float costoKM) {
        this.costo100Grammi = costo100Grammi;
        this.costoKM = costoKM;
    }
}
