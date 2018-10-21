package com.flight.beans;

import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;


/**
 * @author Pranab Kumar Sahoo
 *
 */
public class FlightsProviderDetails {

	private String origin;
	private Date departureTime;
	private String destination;
	private String destinationTime;
	private float price;

	/**
	 * @param origin
	 * @param date
	 * @param destination
	 * @param destinationTime
	 * @param price
	 */
	public FlightsProviderDetails(String origin, Date date, String destination, String destinationTime,
			float price) {
		this.origin = origin;
		this.departureTime = date;
		this.destination = destination;
		this.destinationTime = destinationTime;
		this.price = price;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public Date getDepartureTime() {
		return new Date(departureTime.getTime());
	}

	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDestinationTime() {
		return destinationTime;
	}

	public void setDestinationTime(String destinationTime) {
		this.destinationTime = destinationTime;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public boolean equals(Object object) {
		if (object == this)
			return true;
		if (!(object instanceof FlightsProviderDetails)) {
			return false;
		}
		FlightsProviderDetails flightBean = (FlightsProviderDetails) object;
		return new EqualsBuilder()
				.append(origin, flightBean.origin)
				.append(departureTime, flightBean.departureTime)
				.append(destination, flightBean.destination)
				.append(destinationTime, flightBean.destinationTime)
				.append(price, flightBean.price)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37)
				.append(origin)
				.append(departureTime)
				.append(destination)
				.append(destinationTime)
				.append(price)
				.toHashCode();
	}
	
	@Override
	public String toString() {
		return "FlightsProviderDetails [origin=" + origin + ", departureTime=" + departureTime + ", destination="
				+ destination + ", destinationTime=" + destinationTime + ", price=" + price + "]";
	}

}
