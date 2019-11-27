package fr.efrei.TPRestWebService;

import javax.persistence.*;

@Entity
public class Car {
	
	@Id
	private long id;
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	private String plateNumber;
	private String brand;
	private int price;
	private boolean isRented;
	private int numberOfSeat;
	
	public int getNumberOfSeat() {
		return numberOfSeat;
	}

	public void setNumberOfSeat(int numberOfSeat) {
		this.numberOfSeat = numberOfSeat;
	}

	public boolean isRented() {
		return isRented;
	}

	public void setRented(boolean isRented) {
		this.isRented = isRented;
	}

	public Car() {
		super();
	}
	
	public Car(String plateNumber, String brand, int numberOfSeat, int price, boolean isRented) {
		super();
		this.plateNumber = plateNumber;
		this.brand = brand;
		this.price = price;
		this.numberOfSeat = numberOfSeat;
		this.isRented = isRented;
	}
	
	public String getPlateNumber() {
		return plateNumber;
	}
	
	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}
	
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Car [plateNumber=" + plateNumber + ", brand=" + brand + ", numberOfSeat=" + numberOfSeat + ", price=" + price + "]";
	}

}