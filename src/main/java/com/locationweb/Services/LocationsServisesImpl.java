package com.locationweb.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.locationweb.Repository.LocationsRepository;
import com.locationweb.entity.Locations;
@Service//tells this is services layer
public class LocationsServisesImpl implements LocationsServices {//Inheritance is done
@Autowired//create required object
	private LocationsRepository locationRepo;//class down casting
	@Override
	public void saveLocation(Locations location) {
		locationRepo.save(location);//this is repository method given by SpringBoot
	}
	@Override
	public List<Locations> getAllLocations() {
		List<Locations> locations = locationRepo.findAll();
		return locations;
	}
	@Override
	public void deleteById(int id) {
		locationRepo.deleteById(id);
	}
	@Override
	public Locations getLocation(int id) {
		Optional<Locations> findById = locationRepo.findById(id);
		Locations location = findById.get();
		return location;
	}

}
