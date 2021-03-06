package com.csc.lap.features.optional;

import java.util.Optional;

import com.csc.lap.domain.Car;
import com.csc.lap.domain.Insurance;
import com.csc.lap.domain.Person;

public class OptionalMain {

	public static void main(String[] args) {
		Car car = new Car();
		car.setInsurance(new Insurance("XYZ INSURANCE COMPANY"));
		Person personHavingInsurance = new Person();
		personHavingInsurance.setCar(car);
		
		System.out.println("Optional Approach - Insurance Name: " + getInsuranceNameWithOptional(personHavingInsurance));
		
		
		
	}
    public static String getInsuranceNameWithOptional(Person person) {
    	Optional<Car> car = person.getCarAsOptional();
    	if (car.isPresent()){
    		return car.get().getInsurance().getName();
    	} 
    	return "Unknown";
    }
    
   
}
