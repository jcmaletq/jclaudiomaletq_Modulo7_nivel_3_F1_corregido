package com.vehicles.project.Vehicles;

public enum colors {
	   rojo,
	   blanco,
	   azul,
	   gris,
	   negro;
	public static boolean contains(String col) {
		for (colors color : colors.values()) {
			if(color.name().equalsIgnoreCase(col)) { return true;}
		}
	return false;
	}
	public static String lista_colores() {
		String text="";
		for (colors x : colors.values()) {
			text+=x.name()+" , ";
		}
	return text;
	}
}
