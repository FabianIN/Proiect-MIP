package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the designer database table.
 * 
 */
@Entity
@NamedQuery(name="Designer.findAll", query="SELECT d FROM Designer d")
public class Designer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int designerid;

	private String name;

	public Designer() {
	}

	public int getDesignerid() {
		return this.designerid;
	}

	public void setDesignerid(int designerid) {
		this.designerid = designerid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}