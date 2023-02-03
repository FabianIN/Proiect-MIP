package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the publisher database table.
 * 
 */
@Entity
@NamedQuery(name = "Publisher.findAll", query = "SELECT p FROM Publisher p")
public class Publisher implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int publisherid;

	private String publishername;

	public Publisher() {
	}

	public int getPublisherid() {
		return this.publisherid;
	}

	public void setPublisherid(int publisherid) {
		this.publisherid = publisherid;
	}

	public String getPublishername() {
		return this.publishername;
	}

	public void setPublishername(String publishername) {
		this.publishername = publishername;
	}

}