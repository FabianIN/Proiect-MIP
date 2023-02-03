package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the artist database table.
 * 
 */
@Entity
@NamedQuery(name = "Artist.findAll", query = "SELECT a FROM Artist a")
public class Artist implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int artistid;

	private String name;

	public Artist() {
	}

	public int getArtistid() {
		return this.artistid;
	}

	public void setArtistid(int artistid) {
		this.artistid = artistid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}