package it.poliba.is45.ecoshipping.payload.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

import javax.validation.constraints.*;
@Getter
@Setter

public class SignupRequest {
  @NotBlank
  @Size(min = 3, max = 20)
  private String username;

  @NotBlank
  @Size(max = 50)
  @Email
  private String email;

  private Set<String> role;

  @NotBlank
  @Size(min = 6, max = 40)
  private String password;


  private String nome;
  private String cognome;
  private String IndirizzoResidenza;
  private String citta;
  private String cap;
  private Date dataNasc;
  private String mobile;
  private String iban;

}


