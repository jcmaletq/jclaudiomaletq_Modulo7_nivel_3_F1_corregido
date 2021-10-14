package com.vehicles.project.Vehicles;

import java.util.ArrayList;
import java.util.List;
import com.vehicles.project.Users.Person;


public class Reg_Propi extends Reg_Vehi {
	protected static List<Reg_Propi> lista_re_pro = new ArrayList<>();   // lista de propietarios y vehiculos en el sistema acumulativos  
    //                                                                 este registro historico solo acumula, falta implementar estados de los mismos
// constructoroes
	public Reg_Propi(plate plate, String person_id) {
		super(plate, person_id);
		// TODO Auto-generated constructor stub
		lista_re_pro.add(this);
	}
// metodos	
	public static List<Reg_Propi> getLista_re_pro() {
		return lista_re_pro;
	}
	public static void add_reg_pro (Vehicle ve,Person pe) {
		plate plate;
		String person_id;
		plate = ve.getPlate();
		person_id = pe.getPerson_id();
		ve.setPerson_id(person_id);
		Reg_Propi rc = new Reg_Propi(plate,person_id);  
	}
	@Override
	public String toString() {
		return "vehicle owner id= " + id + ", Plate= " + Plate 
				+ ", person_id= " + person_id +"\n";
	}	
}