package com.vehicles.project.Vehicles;

import java.util.ArrayList;
import java.util.List;

import com.vehicles.project.Users.Conductor;
import com.vehicles.project.Users.Person;

public class Reg_Conduc extends Reg_Vehi {
	protected static List<Reg_Conduc> lista_re_con = new ArrayList<>();  // lista de conductores y vehiculos en el sistema acumulativos  
	                                                                           // este registro historico solo acumula, falta implementar estados de los mismos
// constructores
	public Reg_Conduc(plate plate, String person_id) {
		super(plate, person_id);

		// TODO Auto-generated constructor stub
		lista_re_con.add(this);
	}
//metodos	
	public static List<Reg_Conduc> getLista_re_con() {
		return lista_re_con;
	}
	public static void add_reg_cond (Vehicle ve,Person pe) {
		plate plate;
		String person_id;
		plate = ve.getPlate();
		person_id = pe.getPerson_id();
		ve.addConductor(pe);
		Reg_Conduc rc = new Reg_Conduc(plate,person_id);  
	}
	@Override
	public String toString() {
		return "vehicle driver id= " + id + ", Plate= " + Plate 
				+ ", person_id= " + person_id +"\n";
	}	
}
