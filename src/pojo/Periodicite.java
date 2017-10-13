package pojo;

public class Periodicite {
	private int id_periodicite;
	private String libelle;
	
	public Periodicite() {
		this.id_periodicite = 0;
		this.libelle = "";
	}
	
	public Periodicite(int id_periodicite) {
		this.id_periodicite = id_periodicite;
	}

	public Periodicite(String libelle2) {
		this.libelle = libelle2;
	}
	
	public Periodicite(int id_periodicite, String libelle) {
		this.id_periodicite = id_periodicite;
		this.libelle = libelle;
	}
	

	public int getId() {
		return id_periodicite;
	}


	public void setId(int id_periodicite) {
		this.id_periodicite = id_periodicite;
	}


	public String getLibelle() {
		return libelle;
	}


	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


	@Override
	public String toString() {
		return "Periodicite [id_periodicite=" + id_periodicite + ", libelle=" + libelle + "]";
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		
		if (obj == null)
			return false;
		
		if (getClass() != obj.getClass())
			return false;
		
		Periodicite other = (Periodicite) obj;
		if (id_periodicite != other.id_periodicite)
			return false;
		
		if (libelle == null) {
			if (other.libelle != null)
				return false;
		} else if (!libelle.equals(other.libelle))
			return false;
		
		return true;
	}
}
