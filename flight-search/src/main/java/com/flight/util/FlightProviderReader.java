package com.flight.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.flight.beans.FlightsProviderDetails;

/**
 * @author Pranab Kumar Sahoo
 *
 */
@Component
public class FlightProviderReader {


	public ArrayList<FlightsProviderDetails> getFlightProviders() {
		ArrayList<FlightsProviderDetails> flightProviderList = new ArrayList<>();
		String line;
		try (BufferedReader br = new BufferedReader(new FileReader(loadFile("provider.txt")))) {
			while ((line = br.readLine()) != null) {
				if (line != null && line.contains("Provider") || line.contains("----") || line.contains("Origin")) {

				}else{
					splitByDelimiter(flightProviderList, line);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return flightProviderList;
	}


	public void sortByPriceAndDepartureTime(List<FlightsProviderDetails> flightProviderList) {
		Comparator<FlightsProviderDetails> sortByPriceAndDepartureTime = Comparator.comparing(FlightsProviderDetails::getPrice).thenComparing(FlightsProviderDetails::getDepartureTime);
		flightProviderList.sort(sortByPriceAndDepartureTime);
	}


	public  void splitByDelimiter(ArrayList<FlightsProviderDetails> flightProviderList, String line) {
		String[] split;
		if(line.contains(",")){
			split = line.split(",");
			flightProviderList.add(new FlightsProviderDetails(split[0], DateUtils.parseDateByString(split[1]), split[2], split[3], Float.parseFloat(split[4].substring(1))));
		}
		else if(line.contains("|")){
			split = line.split("\\|");
			flightProviderList.add(new FlightsProviderDetails(split[0],DateUtils.parseDateByString(split[1]), split[2], split[3], Float.parseFloat(split[4].substring(1))));
		}
	}

	private  File loadFile(String fileName) {
		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		File file = new File(classLoader.getResource(fileName).getFile());
		return file;
	}

}
