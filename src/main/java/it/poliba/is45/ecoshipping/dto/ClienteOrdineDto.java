package it.poliba.is45.ecoshipping.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteOrdineDto {
    private String nomeCliente;
    private String cognomeCliente;
    private int idCliente;
    private int idOrdine;

}
