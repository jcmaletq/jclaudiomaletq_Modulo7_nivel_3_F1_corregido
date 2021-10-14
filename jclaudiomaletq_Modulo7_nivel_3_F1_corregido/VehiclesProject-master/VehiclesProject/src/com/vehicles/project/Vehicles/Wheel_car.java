package com.vehicles.project.Vehicles;

import java.util.ArrayList;
import java.util.List;
/*
 * separo el tratamiento de las ruedas de moto o coche de el concepto de rueda puro
 */
public class Wheel_car extends Wheel {
	private String brand;
	private double diameter;

	public Wheel_car(String brand, double diameter) {
		super (brand,diameter);
	}


	public static List<Wheel_car> pide_datos_rueda_car (String posi) {
		String brand;
		double diameter;
		brand = null;
		brand = Wheel.pide_datos_brand(posi);		
		diameter = Wheel.pide_datos_diameter(posi);
		Wheel_car r_Wheel =new Wheel_car (brand,diameter);
		Wheel_car l_Wheel =new Wheel_car (brand,diameter);
		List<Wheel_car> lista = new ArrayList<>();
		lista.add(r_Wheel);
		lista.add(l_Wheel);
		return lista; 
	   }
	
	
}
