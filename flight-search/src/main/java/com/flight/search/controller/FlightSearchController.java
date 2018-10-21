package com.flight.search.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flight.search.service.IFlightSearchService;


/**
 * @author Pranab Kumar Sahoo
 *
 */
@RestController
@RequestMapping("/searchFlights")
public class FlightSearchController {
	@Autowired
	IFlightSearchService iFlightSearchService; 

//	@RequestMapping(value="/searchFlights/{Origin}/{Destination}",method=RequestMethod.GET)
	@GetMapping("/{Origin}/{Destination}")
	public String searchFlights(@PathVariable("Origin") String origin, @PathVariable("Destination") String destination){
		return iFlightSearchService.searchFlights(origin, destination);
	}
}
