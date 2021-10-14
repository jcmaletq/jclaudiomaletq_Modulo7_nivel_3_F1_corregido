package com.vehicles.project.Vehicles;

import javax.swing.JOptionPane;
/*
 * propidades de rueda independiente del vehiculo
 */
public class Wheel {
	private String brand;
	private double diameter;

	public Wheel(String brand, double diameter) {
		this.brand = brand;
		this.diameter = diameter;
	}

	public static double  pide_datos_diameter(String posi){
		int val;
		double diameter;
		String diamet;
		diamet = null;
		do {
			try {
			diamet=(JOptionPane.showInputDialog("introudce el diametro de la rueda "+posi,2.2));
			val = diamet.length();   // para detectar el cancel
			}
			   catch (Exception e)
		       { System.out.println("error no se ha introducido el diametro " + posi);
		        System.exit(0);
		      }
			diameter=Double.parseDouble(diamet);	
		}
		while   (! diameter_valid(diameter));
		return diameter;
	}
	public static String pide_datos_brand(String posi){
		String brand;
		int val;
		brand = null;
		try {brand=JOptionPane.showInputDialog("introudce la marca de la rueda "+posi,"Brand Wheel");
		  val = brand.length();   // para detectar el cancel
	    }
	   catch (Exception e)
	       { System.out.println("error no se ha introducido la marca de la rueda " + posi);
	        System.exit(0);
	      }
		return brand;
	}	
	/*
	 * no separo la validación del diametro por no estar en los requerimientos, lo lógico es que no sea la misma.
	 */
	public static boolean diameter_valid (double diam) {
		boolean valid;
		valid = false;
		if (diam >= 0.4 && diam <= 4) {
			valid = true;}
		else {System.out.println("el diametro introducido " +diam +" ha de estar entre 0.4 y 4");}
		return valid;
	}	
	@Override
	public String toString() {
		return "Wheel brand= " + brand   
				+ ", diameter= " + diameter 
				+ " \n";
	}
}
