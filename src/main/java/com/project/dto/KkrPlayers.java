package com.project.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class KkrPlayers {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String playerName;
	private String roll;
	private String auctionPrice;
	private String nation;
	@ManyToOne  //many CskPlayer To One Team
	Teams teams;
	
	
	
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public Teams getTeams() {
		return teams;
	}
	public void setTeams(Teams teams) {
		this.teams = teams;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public String getRoll() {
		return roll;
	}
	public void setRoll(String roll) {
		this.roll = roll;
	}
	public String getAuctionPrice() {
		return auctionPrice;
	}
	public void setAuctionPrice(String auctionPrice) {
		this.auctionPrice= auctionPrice;
	}
	
}
