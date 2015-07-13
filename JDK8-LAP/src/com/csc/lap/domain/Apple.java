package com.csc.lap.domain;

public class Apple {
	private Integer weight = 0;
	private String color = "";

	public Apple(String color, Integer weight) {
		this.weight = weight;
		this.color = color;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String toString() {
		return "Apple{" + "color='" + color + '\'' + ", weight=" + weight + '}';
	}
}
