package it.poliba.is45.ecoshipping;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ordine {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_ordine;
	private String indirizzo_partenza;
	private String indirizzo_consegna;
	private float volume_spedizione;
	private int num_telefono_destinatario;
	private String metodo_pagamento;
	private String note_consegna;
	private String fascia_oraria;
	private float costo_finale;
	private double longitudine_partenza;
	private double lstitudine_partenza;
	private double longitudine_destinazione;
	private double latitudine_destinazione;
	private int id_utente;

	public int getId_ordine() {
		return id_ordine;
	}

	public void setId_ordine(int id_ordine) {
		this.id_ordine = id_ordine;
	}

	public String getIndirizzo_partenza() {
		return indirizzo_partenza;
	}

	public void setIndirizzo_partenza(String indirizzo_partenza) {
		this.indirizzo_partenza = indirizzo_partenza;
	}

	public String getIndirizzo_consegna() {
		return indirizzo_consegna;
	}

	public void setIndirizzo_consegna(String indirizzo_consegna) {
		this.indirizzo_consegna = indirizzo_consegna;
	}

	public float getVolume_spedizione() {
		return volume_spedizione;
	}

	public void setVolume_spedizione(float volume_spedizione) {
		this.volume_spedizione = volume_spedizione;
	}

	public int getNum_telefono_destinatario() {
		return num_telefono_destinatario;
	}

	public void setNum_telefono_destinatario(int num_telefono_destinatario) {
		this.num_telefono_destinatario = num_telefono_destinatario;
	}

	public String getMetodo_pagamento() {
		return metodo_pagamento;
	}

	public void setMetodo_pagamento(String metodo_pagamento) {
		this.metodo_pagamento = metodo_pagamento;
	}

	public String getNote_consegna() {
		return note_consegna;
	}

	public void setNote_consegna(String note_consegna) {
		this.note_consegna = note_consegna;
	}

	public String getFascia_oraria() {
		return fascia_oraria;
	}

	public void setFascia_oraria(String fascia_oraria) {
		this.fascia_oraria = fascia_oraria;
	}

	public float getCosto_finale() {
		return costo_finale;
	}

	public void setCosto_finale(float costo_finale) {
		this.costo_finale = costo_finale;
	}

	public double getLongitudine_partenza() {
		return longitudine_partenza;
	}

	public void setLongitudine_partenza(double longitudine_partenza) {
		this.longitudine_partenza = longitudine_partenza;
	}

	public double getLstitudine_partenza() {
		return lstitudine_partenza;
	}

	public void setLstitudine_partenza(double lstitudine_partenza) {
		this.lstitudine_partenza = lstitudine_partenza;
	}

	public double getLongitudine_destinazione() {
		return longitudine_destinazione;
	}

	public void setLongitudine_destinazione(double longitudine_destinazione) {
		this.longitudine_destinazione = longitudine_destinazione;
	}

	public double getLatitudine_destinazione() {
		return latitudine_destinazione;
	}

	public void setLatitudine_destinazione(double latitudine_destinazione) {
		this.latitudine_destinazione = latitudine_destinazione;
	}

	public int getId_utente() {
		return id_utente;
	}

	public void setId_utente(int id_utente) {
		this.id_utente = id_utente;
	}
}