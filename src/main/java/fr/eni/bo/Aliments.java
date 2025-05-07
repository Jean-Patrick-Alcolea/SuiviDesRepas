package fr.eni.bo;

public class Aliments {
	private int id;
	private String nom;
	private int idRepas;
	
		
	public Aliments() {
	}

	public Aliments(String nom, int idRepas) {
		super();
		this.nom = nom;
		this.idRepas = idRepas;
	}

	public Aliments(int id, String nom, int idRepas) {
		super();
		this.id = id;
		this.nom = nom;
		this.idRepas = idRepas;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getIdRepas() {
		return idRepas;
	}

	public void setIdRepas(int idRepas) {
		this.idRepas = idRepas;
	}

	@Override
	public String toString() {
		return "aliments [id=" + id + ", nom=" + nom + ", idRepas=" + idRepas + "]";
	}
	
	
	
}
