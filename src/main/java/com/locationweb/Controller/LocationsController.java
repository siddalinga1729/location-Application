package com.locationweb.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.locationweb.Dto.LocationsData;
import com.locationweb.Services.LocationsServices;
import com.locationweb.entity.Locations;
import com.locationweb.utility.EmailService;

@Controller // tells this is controller layer
public class LocationsController {
	@Autowired // creates required object
	private LocationsServices locationServices;// Class Up Casting
@Autowired
private EmailService emailService;
	
	//handler methods like post,get method j2ee
	@RequestMapping("/showLocationPage") // it should match http
	public String show() {// name is not matter
		return "create_location";// it should match jsp file name

	}// without @ModelAttribute we can call the Locations dto

	@RequestMapping("/savelocation") // it should match with action in jsp
	public String saveLocationData( @ModelAttribute("loc")Locations location,ModelMap model) {//here entity class is mandatory
		locationServices.saveLocation(location);//this method belongs to services layer
		emailService.sendSimpleMessage("siddalinga1729@gmail.com", "text", "welcome");
		model.addAttribute("msg", "Location Is Saved!!");
		return "create_location";

	}
//	@RequestMapping("/savelocation") // it should match with action in jsp
//
//	public String saveLocationData(@RequestParam("id") int id, @RequestParam("name") String name,
//			@RequestParam("codes") String code, @RequestParam("type") String typ,ModelMap model) {
//		Locations location = new Locations();
//		location.setId(id);
//		location.setName(name);
//		location.setCodes(code);
//		location.setType(typ);
//		locationServices.saveLocation(location);// this method belongs to services layer
//		model.addAttribute("msg", "Location is Saved!!");
//		return "create_location";
//
//	}
// data transfer object
//	@RequestMapping("/savelocation") // it should match with action in jsp
//	public String saveLocationData( LocationsData loca,ModelMap model) {
//		Locations location=new Locations();
//		location.setId(loca.getId());
//		location.setName(loca.getName());
//		location.setCodes(loca.getCodes());
//		location.setType(loca.getType());
//		model.addAttribute("msg", "Location is Saved!!");
//		locationServices.saveLocation(location);//this method belongs to services layer
//		return "create_location";
//
//	}
	@RequestMapping("listAll")
	public String listAll(ModelMap model) {
		List<Locations> locations = locationServices.getAllLocations();
		model.addAttribute("locations", locations);
		return "search_result";
	}
	@RequestMapping("/Location_delete")//here "/" is not mandatory
	public String deleteLocation(@RequestParam("id")int id,ModelMap model) {
		locationServices.deleteById(id);
//		List<Locations> locations = locationServices.getAllLocations();
//		model.addAttribute("locations", locations);
		return "redirect:/search_result";
		
	}
	@RequestMapping("/update")
	public String getLocation(@RequestParam("id") int id,ModelMap model) {
		Locations location = locationServices.getLocation(id);
		model.addAttribute("location", location);
		return "update_Location";
		
	}//we can use any one of method out of three to read data
	@RequestMapping("updatelocation")
	public String updateLocation(@ModelAttribute() Locations locations,ModelMap model) {
		locationServices.saveLocation(locations);
		model.addAttribute("msg", "Location is Updated");
		return "update_Location";
		
	}
	
}
