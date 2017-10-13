package pojo;

public class Abonnement {
	private int id_client;
	private int id_revue;
	private String date_deb;
	private String date_fin;
	
	public Abonnement() {
		
		
		this.id_client = 0;
		this.id_revue = 0;
		this.date_deb = "";
		this.date_fin = "";
	}
	
	public Abonnement(int id_client, int id_revue) {
		this.id_client = id_client;
		this.id_revue = id_revue;
	}

	public Abonnement(int id_client, int id_revue, String date_deb, String date_fin) {
		this.setId_client(id_client);
		this.setId_revue(id_revue);
		this.setDate_deb(date_deb);
		this.setDate_fin(date_fin);
	}
	
	public int getId_client() {
		return id_client;
	}

	public void setId_client(int id_client) {
		this.id_client = id_client;
	}

	public int getId_revue() {
		return id_revue;
	}

	public void setId_revue(int id_revue) {
		this.id_revue = id_revue;
	}

	public String getDate_deb() {
		return date_deb;
	}

	public void setDate_deb(String date_deb) {
		this.date_deb = date_deb;
	}

	public String getDate_fin() {
		return date_fin;
	}

	public void setDate_fin(String date_fin) {
		this.date_fin = date_fin;
	}

	@Override
	public String toString() {
		return "Abonnement [id_client=" + id_client + ", id_revue=" + id_revue + ", date_deb=" + date_deb
				+ ", date_fin=" + date_fin + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Abonnement other = (Abonnement) obj;
		if (date_deb == null) {
			if (other.date_deb != null)
				return false;
		} else if (!date_deb.equals(other.date_deb))
			return false;
		if (date_fin == null) {
			if (other.date_fin != null)
				return false;
		} else if (!date_fin.equals(other.date_fin))
			return false;
		if (id_client != other.id_client)
			return false;
		if (id_revue != other.id_revue)
			return false;
		return true;
	}
}
