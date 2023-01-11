package it.poliba.is45.ecoshipping.payload.request;

import it.poliba.is45.ecoshipping.dto.OrdineDto;

import javax.validation.constraints.NotBlank;


public class CreateOrderRequest {


    @NotBlank
    private OrdineDto ordineDto  ;


}
