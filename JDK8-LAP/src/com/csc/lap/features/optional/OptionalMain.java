package com.csc.lap.features.optional;

import java.util.*;
import java.util.function.Function;

import com.csc.lap.domain.Car;
import com.csc.lap.domain.Insurance;
import com.csc.lap.domain.Person;

public class OptionalMain {

	public static void main(String[] args) {
		Car car = new Car();
		car.setInsurance(new Insurance("XYZ INSURANCE COMPANY"));
		Person personHavingInsurance = new Person();
		personHavingInsurance.setCar(car);
		
		System.out.println("Imperative Approach - Insurance Name: " + getInsuranceNameImperative(personHavingInsurance));
		
		System.out.println("Optional Approach - Insurance Name: " + getInsuranceNameWithOptional(personHavingInsurance));
		
		/*
		Person personWithoutInsurance = new Person();
		personWithoutInsurance.setCar(new Car());
		
		System.out.println("Imperative Approach - Insurance Name: " + getInsuranceNameImperative(personWithoutInsurance));
		
		System.out.println("Optional Approach - Insurance Name: " + getInsuranceNameWithOptional(personWithoutInsurance));
		*/
		
	}
    public static String getInsuranceNameWithOptional(Person person) {
    	Optional<Car> car = person.getCarAsOptional();
    	if (car.isPresent()){
    		return car.get().getInsurance().getName();
    	} 
    	return "Unknown";
    }
    
    
   
    
    
    public static String getInsuranceNameImperative(Person person) {
        if (person != null){
        	Car car = person.getCar();
        	if (car != null) {
        		Insurance insurance = car.getInsurance();
        		if (insurance != null){
        			return insurance.getName();
        		}
        		
        	}
        }
        return "Unknown";
    }
    
    
 
    	

}
