package com.csc.lap.domain;

import java.util.Optional;

public class Person {
	
	private Car car;
	
	
	

	public void setCar(Car car) {
		this.car = car;
	}

	
	public Optional<Car> getCarAsOptional() {
		return Optional.ofNullable(car);
	}

	public Car getCar() {
		return car;
	}
}
