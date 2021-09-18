package main;

import java.util.Objects;

public class Player {
	private static int idCount = 0;
	private int id;
	private char type;
	private int distance;
	
	@Override
	public int hashCode() {
		return Objects.hash(distance, type);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		return Objects.equals(distance, other.distance) && Objects.equals(type, other.type);
	}
	public char getType() {
		return type;
	}
	public void setType(char type) {
		this.type = type;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getIdCount() {
		return idCount;
	}

	@Override
	public String toString() {
		return "Player [type=" + type + ", distance=" + distance + "]";
	}
	public Player(char type, int distance) {
		super();
		this.type = type;
		this.distance = distance;
		idCount++;
	}
	
	public Player(char type) {
		super();
		this.type = type;
		this.distance = 0;
		idCount++;
	}
	
}
