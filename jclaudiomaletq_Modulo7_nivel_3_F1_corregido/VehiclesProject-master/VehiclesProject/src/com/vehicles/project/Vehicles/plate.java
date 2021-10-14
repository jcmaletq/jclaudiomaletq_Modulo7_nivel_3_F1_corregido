package com.vehicles.project.Vehicles;

import javax.swing.JOptionPane;

import com.vehicles.project.Users.Person;

public class plate {

//  ***************************************
//  matricula  sub clase de vehiculo 
	protected String n_plate;
//constructor	
public plate() {
	this.n_plate = "";
}
public plate(String plate) {
	this.n_plate = plate;
}
//metodos
public  String getN_plate() {
	return n_plate;
}

public void setN_plate(String nplate) {
	n_plate = nplate.toUpperCase();
}

public static plate ask_plate(String tipo) {    // pide matricula por pantalla
	String tplate;
	tplate="";
		try {tplate =JOptionPane.showInputDialog("introudce la matricula del vehiculo " +tipo,"1234ab");
		}
		catch (Exception e)
		 {  System.out.println("error no se ha introducido matricula del " +tipo);
		 System.exit(0);}
	return new plate(tplate.toUpperCase());	
}
//asigna vehiculo a personas
public void add_reg_propi (Vehicle ve, Person pe) {
  plate pl = ve.getPlate();
  String per = pe.getPerson_id();
  ve.setPerson_id(per); 
  new Reg_Propi (pl,per);
}
//validaciones de la matricula
public  boolean Val_long_N_plate() {    // valida longitud total de la matricula
	boolean valid = false;
	if (n_plate.length()>=6 && n_plate.length()<=7) {
		valid = true;}
	else {System.out.println("la matricula " +n_plate +" es corta 4 numeros y 2 o 3 letras");
	   JOptionPane.showMessageDialog(null,"la matricula " +n_plate +" es corta 4 numeros y 2 o 3 letras");}
	return valid;
}
public  boolean Val_let_N_plate() {     // valida no haya numeros a partir del 4 digito de la matricula
	boolean valid = false;
	if (! n_plate.substring(4).matches(".*[0-9].*")) {
		valid = true;}
	else {System.out.println("la matricula " +n_plate +" ha de tener 4 numeros");
	   JOptionPane.showMessageDialog(null,"la matricula " +n_plate +" ha de tener 4 numeros");}
	return valid;
}
public boolean Val_num_N_plate() {     // valida no haya letras en los primeros 4 digitos de la matricula
	boolean valid = false;
	if (! n_plate.substring(0,4).matches(".*[A-Z].*")) {
		valid = true;}
	else {System.out.println("la matricula " +n_plate +" con letras incorrectas, 2 o 3 letras");
	JOptionPane.showMessageDialog(null,"la matricula " +n_plate +" con letras incorrectas, 2 o 3 letras");}
	return valid;
}
@Override
public String toString() {
	return "plate= "+n_plate;
}

}

