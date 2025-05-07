package fr.eni.bo;

import java.sql.Date;
import java.sql.Time;

public class Repas {
	private int identity;
	private Date date_repas;
	private  Time heure_repas;
	
	
	
	
	public Repas() {
	}

	public Repas(Date date_repas, Time heure_repas) {
		super();
		this.date_repas = date_repas;
		this.heure_repas = heure_repas;
	}

	public Repas(int identity, Date date_repas, Time heure_repas) {
		super();
		this.identity = identity;
		this.date_repas = date_repas;
		this.heure_repas = heure_repas;
	}

	public int getIdentity() {
		return identity;
	}

	public void setIdentity(int identity) {
		this.identity = identity;
	}

	public Date getDate_repas() {
		return date_repas;
	}

	public void setDate_repas(Date date_repas) {
		this.date_repas = date_repas;
	}

	public Time getHeure_repas() {
		return heure_repas;
	}

	public void setHeure_repas(Time heure_repas) {
		this.heure_repas = heure_repas;
	}

	@Override
	public String toString() {
		return "repas [identity=" + identity + ", date_repas=" + date_repas + ", heure_repas=" + heure_repas + "]";
	}

	
}
