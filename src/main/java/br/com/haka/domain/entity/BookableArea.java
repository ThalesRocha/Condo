/**
 * Created with Eclipse IDE.
 * User: Gustavo Daneluti
 * Date: 27 de dez de 2016
 */
package br.com.haka.domain.entity;

/**
 * Created with Eclipse IDE.
 * User: Gustavo Daneluti
 * Date: 27 de dez de 2016
 */
public class BookableArea {

	private String name;
	private Integer Capacity;
	private boolean booked;
	
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getCapacity() {
		return Capacity;
	}
	
	public void setCapacity(Integer capacity) {
		Capacity = capacity;
	}
	
	public boolean isBooked() {
		return booked;
	}
	
	public void setBooked(boolean booked) {
		this.booked = booked;
	}
}