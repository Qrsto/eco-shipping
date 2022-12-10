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
    @Column(name = "conf_key")
    private String confKey;
    @Column(name = "conf_value")
    private String confValue;


}
