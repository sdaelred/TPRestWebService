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
	
	public CarRentalController() {//Constructeur avec deux voitures de bases
		cars.add(new Car("11AA22", "Ferrari", 2, 1000, true));
		cars.add(new Car("33BB44", "Porshe", 2, 2222, false));
	}
	
	
	
	@RequestMapping(value="/cars", method=RequestMethod.GET) 
	@ResponseStatus(HttpStatus.OK) 
	public List<Car> getListOfCars(){//Renvoie simplement la liste des voitures de la classe
		return cars;
	}
	
	@RequestMapping(value = "/cars", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public void addCar(@RequestBody Car car) throws Exception{//Ajoute une voiture dans la liste
		System.out.println(car);
		cars.add(car);
	}
	
	@RequestMapping(value = "/cars/{plateNumber}", method = RequestMethod.GET) 
	@ResponseStatus(HttpStatus.OK) 
	@ResponseBody
	public Car aCar(@PathVariable("plateNumber") String plateNumber) throws Exception{ 
		//Cette fonctione renvoie la première voiture (supposée la seule...) avec la même
		//plaque d'immatriculation que celle donnée en paramètre : @PathVariable("plateNumber") String plateNumber
		for(Car car : cars) {
			if(car.getPlateNumber().equals(plateNumber)) {
				return car;
			}
		}
		return null;
	}
	
	
	@RequestMapping(value = "/cars/{plateNumber}", method = RequestMethod.DELETE) 
	@ResponseStatus(HttpStatus.OK) 
	public void getBack(@PathVariable("plateNumber") String plateNumber) throws Exception{
		Car theCar = aCar(plateNumber);
		theCar.setRented(false);
		theCar.setBegin(null);
		theCar.setEnd(null);
	}
	
	@RequestMapping(value = "/cars/{plateNumber}", method = RequestMethod.PUT) 
	@ResponseStatus(HttpStatus.OK) 
	public void rent(@PathVariable("plateNumber") String plateNumber, @RequestBody(required = false) String dates) throws Exception{
		Car theCar = aCar(plateNumber);
		aCar(plateNumber).setRented(true);
		theCar.setBegin(dates);
		theCar.setEnd("Deux mois après le " + dates);//Location de deux mois
	}//Ne pouvant pas tester notre code, nous avons "simulé" une location de deux mois de base.
	//Dans la vraie vie, les dates entrées seraient de vraies dates proposées par l'utilisateur.
}