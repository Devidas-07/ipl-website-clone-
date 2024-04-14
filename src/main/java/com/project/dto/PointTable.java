package com.project.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PointTable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String team;
	private int position;
	private int played;
	private int won;
	private int loss;
	private double nr;
	private int points;
	
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public int getPlayed() {
		return played;
	}
	public void setPlayed(int played) {
		this.played = played;
	}
	public int getWon() {
		return won;
	}
	public void setWon(int won) {
		this.won = won;
	}
	public int getLoss() {
		return loss;
	}
	public void setLoss(int loss) {
		this.loss = loss;
	}
	
	public double getNr() {
		return nr;
	}
	public void setNr(double nr) {
		this.nr = nr;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
