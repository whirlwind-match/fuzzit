package org.fuzzydb.samples.mvc;

import java.util.ArrayList;

import org.fuzzydb.samples.Vehicle;
import org.fuzzydb.samples.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/autos", "/mobile/autos"}) 
public class VehicleController extends AbstractDataController<Vehicle> {


	@Autowired
	private VehicleRepository repo;

	
	@Override
	protected void createItem() {
		repo.save(dataGenerator.createRandomVehicle());
	}

	
	@Override
	protected String getDefaultSearchStyle() {
		return "autosMatchEverything";
	}

	@Override
	protected VehicleRepository getRepo() {
		return repo;
	}

	@Override
	protected String getViewPathPrefix() {
		return "autos";
	}

	@Override
	protected Vehicle getSearchForm() {
		Vehicle vehicle = new Vehicle("Entered search");
		vehicle.setPostcode("W1B");
		return vehicle;
	}

	
	@ModelAttribute("options")
	public ArrayList<String> getOptions() {
		return getOptionsForField("options");
	}

	@ModelAttribute("colours")
	public ArrayList<String> getColours() {
		return getOptionsForField("colour");
	}

	@ModelAttribute("carMakes")
	public ArrayList<String> getCarMakes() {
		return getOptionsForField("carMake");
	}
	
	@Override
	protected Vehicle getInitialSearchEntity() {
		return dataGenerator.createRandomVehicle();
	}
}

