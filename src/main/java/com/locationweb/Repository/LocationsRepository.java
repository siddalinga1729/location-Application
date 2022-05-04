package com.locationweb.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.locationweb.entity.Locations;
@Repository//it tells this is a repository layer ,it is not mandatory
public interface LocationsRepository extends JpaRepository<Locations, Integer> {
//Inheritance is done here
}
