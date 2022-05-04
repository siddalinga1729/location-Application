package com.locationweb.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.locationweb.Repository.LocationsRepository;
import com.locationweb.entity.Locations;

import net.bytebuddy.asm.Advice.Return;

@RestController
@RequestMapping("/Location/api")
public class LocationRestController {
	@Autowired
	private LocationsRepository locationRepo;

	@GetMapping
	public List<Locations> getLocation() {
		List<Locations> locations = locationRepo.findAll();
		return locations;
	}

	@PostMapping
	public void saveLocation(@RequestBody Locations location) {
		locationRepo.save(location);

	}

	@PutMapping
	public void updateLocation(@RequestBody Locations location) {
		locationRepo.save(location);

	}

	@DeleteMapping("/delete/{id}")
	public void deleteLocation(@PathVariable("id") int id) {
		locationRepo.deleteById(id);

	}

	@GetMapping("/get/{id}")
	public Locations getLocation(@PathVariable("id") int id) {
		try {
			Optional<Locations> findById = locationRepo.findById(id);
			Locations location = findById.get();
			return location;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
