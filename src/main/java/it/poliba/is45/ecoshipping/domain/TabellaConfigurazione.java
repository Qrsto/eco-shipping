package it.poliba.is45.ecoshipping.domain;

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

public class TabellaConfigurazione {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "costo_100_grammi")
    private float costo100Grammi;
    @Column(name = "costo_km")
    private float costoKM;


}
