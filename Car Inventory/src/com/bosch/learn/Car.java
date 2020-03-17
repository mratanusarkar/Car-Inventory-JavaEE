package com.bosch.learn;

public class Car {
	public String name;
	private String make;
	private String model;
	private int year;
	private double salePrice;
	
	public Car() {
		this.make = "";
		this.model = "";
		this.year = 0;
		this.salePrice = 0.0;
	}
	
	public Car(String make, String model, int year, double salePrice) {
		this.make = make;
		this.model = model;
		this.year = year;
		this.salePrice = salePrice;
	}
	
	public Car(String name, String make, String model, int year, double salePrice) {
		this.name = name;
		this.make = make;
		this.model = model;
		this.year = year;
		this.salePrice = salePrice;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
