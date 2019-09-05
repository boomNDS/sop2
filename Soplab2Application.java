package com.labsop.soplab2;

import java.awt.List;
import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Soplab2Application {
	private static ArrayList<Car> listcar = new ArrayList<Car> (); 
	public static void main(String[] args) {
		SpringApplication.run(Soplab2Application.class, args);
	}
	@RequestMapping(value="/{firstName}/{lastName}",method = RequestMethod.GET)
	public String hello(@PathVariable("firstName") String firstName,@PathVariable("lastName") String lastName){
		return String.format("{\"message\":\"Hello %s %s\"}",firstName,lastName);
	}
	@RequestMapping(value="/post",method = RequestMethod.POST)
	public String hello2(@RequestBody Object object) {
		return String.format("{\"payload\":\"%s\"}",object);
	}
	@RequestMapping(value="/get")
	public ResponseEntity<ArrayList<Car>> get(){
//		Car car = new Car();
//		car.setColor("Blue");
//		car.setType("Truck");
//		car.setDisplacement(1500);
//		car.hasSunroof(false);
//		car.setSpeed(60);
		return new ResponseEntity<ArrayList<Car>>(listcar, HttpStatus.OK);
	}
	@RequestMapping(value = "/read/{index}", method = RequestMethod.GET)
	public ResponseEntity<Car> read(@PathVariable int index){
		Car anscar = new Car();
		for(Car car : listcar) {
			if(car.getId() == index) {
				anscar = car;
			}
		}
		return new ResponseEntity<Car>(anscar, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<Car> create(@RequestBody Car car) {
	int id = car.getId();
	String color = car.getColor();
	String type = car.getType();
	int displacement = car.getDisplacement();
	boolean hasSubroof = car.isSunroof();
	listcar.add(car);
	return new ResponseEntity<Car>(car, HttpStatus.OK);
	}
	@RequestMapping(value = "/createMany", method = RequestMethod.POST)
	public ResponseEntity<ArrayList<Car>> createMany(
	@RequestBody ArrayList<Car> cars) {
	cars.stream().forEach(c -> listcar.add(c));
	return new ResponseEntity<ArrayList<Car>>(cars, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/update/{index}", method = RequestMethod.POST)
	public ResponseEntity<Car> update(@PathVariable int index,@RequestBody Car car) {
		for(Car i: listcar) {
			if(i.getId() == index) {
				i.setColor(car.getColor());
				i.setDisplacement(car.getDisplacement());
				i.setSpeed(car.getSpeed());
				i.setType(car.getType());
				i.hasSunroof(car.isSunroof());
			}
		}
	return new ResponseEntity<Car>(car, HttpStatus.OK);
	}
	@RequestMapping(value = "/updateMany", method = RequestMethod.POST)
	public ResponseEntity<ArrayList<Car>> updateMany(
	@RequestBody ArrayList<Car> cars) {
		for(Car car: cars) {
			for(Car i: listcar) {
				if(i.getId() == car.getId()) {
					i.setColor(car.getColor());
					i.setDisplacement(car.getDisplacement());
					i.setSpeed(car.getSpeed());
					i.setType(car.getType());
					i.hasSunroof(car.isSunroof());
				}
			}
		}
	return new ResponseEntity<ArrayList<Car>>(cars, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/detete/{index}", method = RequestMethod.DELETE)
	public ResponseEntity<ArrayList<Car>> Detete(@PathVariable int index){
		listcar.remove(index);
		return new ResponseEntity<ArrayList<Car>>(listcar, HttpStatus.OK);
	}

}
