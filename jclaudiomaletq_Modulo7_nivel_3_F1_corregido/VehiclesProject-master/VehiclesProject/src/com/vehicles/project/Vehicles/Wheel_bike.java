package com.vehicles.project.Vehicles;

import java.util.ArrayList;
import java.util.List;
/*
 * separo el tratamiento de las ruedas de moto o coche de el concepto de rueda puro
 */
public class Wheel_bike extends Wheel {
	private String brand;
	private double diameter;

	public Wheel_bike(String brand, double diameter) {
		super (brand,diameter);
	}


	public static List<Wheel_bike> pide_datos_rueda_bike (String posi) {
		String brand;
		double diameter;
		brand = null;
		brand = Wheel.pide_datos_brand(posi);		
		diameter = Wheel.pide_datos_diameter(posi);
		Wheel_bike Wheel =new Wheel_bike (brand,diameter);
		List<Wheel_bike> lista = new ArrayList<>();
		lista.add(Wheel);
		return lista; 
	   }
	
}
