package com.vehicles.project;

import java.text.SimpleDateFormat;
import java.util.Date;
import com.vehicles.project.Users.Conductor;
import com.vehicles.project.Users.Titular;
import com.vehicles.project.Users.drive_license;
import com.vehicles.project.Vehicles.Bike;
import com.vehicles.project.Vehicles.Car;
import com.vehicles.project.Vehicles.Reg_Conduc;
import com.vehicles.project.Vehicles.Reg_Propi;
import com.vehicles.project.Vehicles.plate;

//import com.vehicles.project.Vehicle.plate;

public class opera_datos {
public opera_datos() {
}
public static void datos_historicos() {
  // datos titulares
	// previos
	try {
	drive_license dl1 = new drive_license("A", "name1 surname1", "X123456X", 
			new SimpleDateFormat("yyyy/MM/dd").parse("2030/05/05"),
			"X123456X");
	drive_license dl2 = new drive_license("B", "name2 surname2", "Y123456Y", 
			new SimpleDateFormat("yyyy/MM/dd").parse("2030/05/05"),
			"Y123456Y");	
	Titular tit1 = new Titular("name1", "surname1", 
			new SimpleDateFormat("yyyy/MM/dd").parse("2000/05/05"), 
			"X123456X",dl1,"axa123", true);
	Titular tit2 = new Titular("name2", "surname2", 
			new SimpleDateFormat("yyyy/MM/dd").parse("1999/05/05"), 
			"Y123456Y",dl2,"axa456", true);
	plate pl1 =new plate("1234ABC");
	Bike bi1 = new Bike(pl1, "Honda", "Rojo","X123456X");
	Reg_Propi pr1 = new Reg_Propi(pl1, tit1.getPerson_id());	
	plate pl2 =new plate("5678DEF");
	Car ca2 =  new Car(pl2,"Seat","Blanco","Y123456Y");
	Reg_Propi pr2 = new Reg_Propi(ca2.getPlate(), tit2.getPerson_id());
	drive_license dl3 = new drive_license("C", "name3 surname3", "Z123456Z", 
			new SimpleDateFormat("yyyy/MM/dd").parse("2030/05/05"),
			"Z123456Z");
	Conductor con3 = new Conductor("name3", "surname3", 
			new SimpleDateFormat("yyyy/MM/dd").parse("1999/05/05"), 
			"Z123456Z",dl3);
	Reg_Conduc pr3 = new Reg_Conduc(ca2.getPlate(), con3.getPerson_id());
	} catch (Exception e){System.out.println("error en la entrada datos historico");}
}
}
