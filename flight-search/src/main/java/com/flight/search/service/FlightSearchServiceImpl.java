package com.flight.search.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.beans.FlightsProviderDetails;
import com.flight.util.DateUtils;
import com.flight.util.FlightProviderReader;

/**
 * @author Pranab Kumar Sahoo
 *
 */
@Service
public class FlightSearchServiceImpl implements IFlightSearchService{

	private static final String NO_FLIGHT = "No Flights Found for ";
	private static final Logger logger = Logger.getLogger(FlightSearchServiceImpl.class);

	@Autowired
	FlightProviderReader fligitProviderReader;

	/* (non-Javadoc)
	 * @see com.flight.search.service.IFlightSearchService#searchFlights(java.lang.String, java.lang.String)
	 */
	@Override
	public String searchFlights(String origin,String destination){

		ArrayList<FlightsProviderDetails> flightProviders = fligitProviderReader.getFlightProviders();
		List<FlightsProviderDetails> filterFlights = flightProviders.stream().filter(flightProvider->flightProvider.getOrigin().contains(origin) && flightProvider.getDestination().contains(destination)).distinct().collect(Collectors.toList());

		StringBuilder flightResult = new StringBuilder();

		if(null != filterFlights && !filterFlights.isEmpty()){
			fligitProviderReader.sortByPriceAndDepartureTime(filterFlights);

			filterFlights.forEach(flightBean->flightResult.append(flightBean.getOrigin() +" --> " +flightBean.getDestination() +" ("+DateUtils.parseDateToString(flightBean.getDepartureTime())+" --> "+DateUtils.parseDateFormat(flightBean.getDestinationTime())+" ) -  $"+flightBean.getPrice()+"0").append("\n"));
		}else{
			flightResult.append(NO_FLIGHT+origin+" --> "+destination);
		}
		logger.info(flightResult);

		return new String(flightResult);
	}
}
