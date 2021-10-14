package com.vehicles.project.Vehicles;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;

import com.vehicles.project.Users.Conductor;
import com.vehicles.project.Users.Person;
import com.vehicles.project.Users.drive_license;

public class Bike extends Vehicle {

// constructores
	public Bike(plate Plate, String brand, String color, String person_id) {
		super(Plate, brand, color, person_id);
	}
	public Bike(String tipo) {
		super(tipo);
	}
// metodos
	public static void creaBike() {
		Bike moto = new Bike(" moto ") ;
		List<Wheel_bike> frontWheels =new ArrayList<>();
		frontWheels = Wheel_bike.pide_datos_rueda_bike ("Back");
		List<Wheel_bike> backWheels =new ArrayList<>();
		backWheels = Wheel_bike.pide_datos_rueda_bike ("Front");
		try {
		 moto.addWheels(frontWheels,backWheels);
		 }
		catch (Exception e)
		{  System.out.println("error en las ruedas"+ "");
		}
		System.out.println(moto.toString());
		JOptionPane.showMessageDialog(null,moto.toString());
		increm_conta_vehic();
	   } 
	public static int f_creaBike() {
		Bike moto = new Bike(" moto ") ;
		List<Wheel_bike> frontWheels =new ArrayList<>();
		frontWheels = Wheel_bike.pide_datos_rueda_bike ("Back");
		List<Wheel_bike> backWheels =new ArrayList<>();
		backWheels = Wheel_bike.pide_datos_rueda_bike ("Front");
		try {
		 moto.addWheels(frontWheels,backWheels);
		 }
		catch (Exception e)
		{  System.out.println("error en las ruedas"+ "");
		}
		increm_conta_vehic();
		return moto.getId();
	   } 
	public void addWheels(List<Wheel_bike> frontWheels, List<Wheel_bike> backWheels) throws Exception {
		addWheels(frontWheels);
		addWheels(backWheels);
	}
	public void addWheels(List<Wheel_bike> wheels) throws Exception {
		if (wheels.size() != 1)
			throw new Exception();
		Wheel Wheel = wheels.get(0);
		this.wheels.add(Wheel);
	}
	public void addConductor(Person pe)  {
		Conductor con=null;
		int p_id = pe.get_id();
		con = Conductor.Get_Conductor(p_id);
		if (drive_license.val_Type_dl(con.getType_dl_c(),"BIKE"))
		{		this.Conductores.add(con);}
	}
	@Override
	public String toString() {
		return "This Bike has "+ " \n"  
	         + Plate + " Owner= "+person_id + ", brand= " + brand 
				+ ", color= " + color + " \n"  
			+ ", Ruedas " + wheels+ " \n" 
			+" Conductores "+ Conductores;
	}	
}




