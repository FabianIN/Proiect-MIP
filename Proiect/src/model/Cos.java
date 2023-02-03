package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the cos database table.
 * 
 */
@Entity
@Table(name="cos")
@NamedQuery(name="Cos.findAll", query="SELECT c FROM Cos c")
public class Cos implements Serializable {
	private static final long serialVersionUID = 1L;

	private String joccos;

	private int pret;

	public Cos() {
	}

	public String getJoccos() {
		return this.joccos;
	}

	public void setJoccos(String joccos) {
		this.joccos = joccos;
	}

	public int getPret() {
		return this.pret;
	}

	public void setPret(int pret) {
		this.pret = pret;
	}

}