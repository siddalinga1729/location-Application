package com.locationweb.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.locationweb.entity.Locations;
@Service//tells this is services layer
public interface LocationsServices {
public void saveLocation(Locations location);

public List<Locations> getAllLocations();

public void deleteById(int id);

public Locations getLocation(int id);
}
