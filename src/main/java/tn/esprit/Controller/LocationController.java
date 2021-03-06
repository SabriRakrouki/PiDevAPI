package tn.esprit.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.entities.Location;
import tn.esprit.repositories.LocationRepository;

@RestController
@RequestMapping("/api/v1/location")
public class LocationController {
	
	
	private final LocationRepository locationRepository;
	
	
	public LocationController(LocationRepository locationRepository) {
		this.locationRepository = locationRepository;
	}


	@PostMapping("/add")
	@ResponseBody
	public Location addLocation(@RequestBody Location location) {
		
		
		return locationRepository.save(location);
	}
	
	
	
	

}
