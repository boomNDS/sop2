package com.labsop.soplab2;

public class Car {
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private String color;
	private String type;
	private int displacement;
	private boolean sunroof;
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getDisplacement() {
		return displacement;
	}
	public void setDisplacement(int displacement) {
		this.displacement = displacement;
	}
	public boolean isSunroof() {
		return sunroof;
	}
	public void hasSunroof(boolean sunroof) {
		this.sunroof = sunroof;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	private int speed;
}
