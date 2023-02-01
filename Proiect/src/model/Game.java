package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the game database table.
 * 
 */
@Entity
@NamedQuery(name="Game.findAll", query="SELECT g FROM Game g")
public class Game implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int gameid;

	private int artistid;

	private String description;

	private int designerid;

	private String gamename;

	private String players;

	private int publisherid;
	
	private int stoc;
	
	private int pret;

	public Game() {
	}

	public int getGameid() {
		return this.gameid;
	}

	public void setGameid(int gameid) {
		this.gameid = gameid;
	}

	public int getArtistid() {
		return this.artistid;
	}

	public void setArtistid(int artistid) {
		this.artistid = artistid;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDesignerid() {
		return this.designerid;
	}

	public void setDesignerid(int designerid) {
		this.designerid = designerid;
	}

	public String getGamename() {
		return this.gamename;
	}

	public void setGamename(String gamename) {
		this.gamename = gamename;
	}

	public String getPlayers() {
		return this.players;
	}

	public void setPlayers(String players) {
		this.players = players;
	}

	public int getPublisherid() {
		return this.publisherid;
	}

	public void setPublisherid(int publisherid) {
		this.publisherid = publisherid;
	}

	public int getStoc() {
		return this.stoc;
	}

	public void setStoc(int stoc) {
		this.stoc = stoc;
	}

	public int getPret() {
		return this.pret;
	}

	public void setPret(int pret) {
		this.pret = pret;
	}

	
	
}