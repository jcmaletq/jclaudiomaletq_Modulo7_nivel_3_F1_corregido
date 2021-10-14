package com.vehicles.project.Vehicles;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;

import com.vehicles.project.Users.Conductor;
import com.vehicles.project.Users.Person;
import com.vehicles.project.Users.drive_license;

public class Car extends Vehicle {


// constructores
	public Car(plate Plate, String brand, String color,String person_id) {
		super(Plate, brand, color,person_id);
	}
	public Car(String tipo) {
		super(tipo);
	}
// metodos	
	public static void crea_Car() {
			Car coche = new Car ("Coche");
			List<Wheel_car> frontWheels =new ArrayList<>();
			frontWheels = Wheel_car.pide_datos_rueda_car ("Back");
			List<Wheel_car> backWheels =new ArrayList<>();
			backWheels = Wheel_car.pide_datos_rueda_car ("Front");
			try {
			 coche.addWheels(frontWheels,backWheels);
			 }
			catch (Exception e)
			{  System.out.println("error en las ruedas"+ "");
			} 
			System.out.println(coche.toString());
			JOptionPane.showMessageDialog(null,coche.toString());
			increm_conta_vehic();
		   } 
	public static int f_crea_Car() {
		Car coche = new Car ("Coche");
		List<Wheel_car> frontWheels =new ArrayList<>();
		frontWheels = Wheel_car.pide_datos_rueda_car ("Back");
		List<Wheel_car> backWheels =new ArrayList<>();
		backWheels = Wheel_car.pide_datos_rueda_car ("Front");
		try {
		 coche.addWheels(frontWheels,backWheels);
		 }
		catch (Exception e)
		{  System.out.println("error en las ruedas"+ "");
		} 
		increm_conta_vehic();
		return coche.getId();
	   } 
	public void addWheels(List<Wheel_car> frontWheels, List<Wheel_car> backWheels) throws Exception {
		addTwoWheels(frontWheels);
		addTwoWheels(backWheels);
	}
	public void addTwoWheels(List<Wheel_car> wheels) throws Exception {
		if (wheels.size() != 2)
			throw new Exception();
		Wheel rightWheel = wheels.get(0);
		Wheel leftWheel = wheels.get(1);
		if (!rightWheel.toString().equals(leftWheel.toString()))
			throw new Exception();
		this.wheels.add(leftWheel);
		this.wheels.add(rightWheel);
	}		
	public void addConductor(Person pe)  {
		Conductor con=null;
		int p_id = pe.get_id();
		con = Conductor.Get_Conductor(p_id);
		if (drive_license.val_Type_dl(con.getType_dl_c(),"CAR"))
		{		this.Conductores.add(con);}
	}
	@Override
	public String toString() {
		return "This Car has "+ " \n" 
	            + Plate  + " Owner= "+person_id + ", brand= " + brand 
				+ ", color= " + color + " \n"  
				+ ", Ruedas " + wheels+ " \n" 
				+" Conductores "+ Conductores;
				
	}	
	
	
}
