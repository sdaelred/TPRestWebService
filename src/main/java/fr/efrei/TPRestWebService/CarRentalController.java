package fr.efrei.TPRestWebService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;

@RestController
public class CarRentalController {
	
	private List<Car> cars = new ArrayList<Car>();
	
	public CarRentalController() {
		cars.add(new Car("11AA22", "Ferrari", 1000));
		cars.add(new Car("33BB44", "Porshe", 2222));
	}
	
	@RequestMapping(value="/cars", method=RequestMethod.GET) 
	@ResponseStatus(HttpStatus.OK) 
	public List<Car> getListOfCars(){
		return cars;
	}
	
	@RequestMapping(value = "/cars", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public void addCar(@RequestBody Car car) throws Exception{
		System.out.println(car);
		cars.add(car);
	}

	@RequestMapping(value = "/cars", method = RequestMethod.GET) 
	@ResponseStatus(HttpStatus.OK) 
	@ResponseBody
	public List<Car> listOfCars(){ 
		return cars;
	}
	
	@RequestMapping(value = "/cars/{plateNumber}", method = RequestMethod.GET) 
	@ResponseStatus(HttpStatus.OK) 
	@ResponseBody
	public Car aCar(@PathVariable("plateNumber") String plateNumber) throws Exception{ 
		return null;//new Car(plateNumber, "Ferrari", 1000);
	}
	
	@RequestMapping(value = "/cars/{plateNumber}", method = RequestMethod.DELETE) 
	@ResponseStatus(HttpStatus.OK) 
	public void getBack(@PathVariable("plateNumber") String plateNumber) throws Exception{ }
	
	@RequestMapping(value = "/cars/{plateNumber}", method = RequestMethod.PUT) 
	@ResponseStatus(HttpStatus.OK) 
	public void rent(@PathVariable("plateNumber") String plateNumber) throws Exception{ }
	
	@RequestMapping(value = "/voiture/{plateNumber}", method = RequestMethod.PUT) 
	@ResponseStatus(HttpStatus.OK)  
	public void rentAndGetBack(@PathVariable("plateNumber") String plateNumber, @RequestParam(value="rent", required = true)boolean rent) throws Exception{ } 
	/*
	@RequestMapping(value = "/cars/{plateNumber}", method = RequestMethod.PUT)  
	public void rent(@PathVariable("plateNumber") String plateNumber, @RequestParam(value="rent", required = true)boolean rent, @RequestBody Dates dates){ }
*/
}