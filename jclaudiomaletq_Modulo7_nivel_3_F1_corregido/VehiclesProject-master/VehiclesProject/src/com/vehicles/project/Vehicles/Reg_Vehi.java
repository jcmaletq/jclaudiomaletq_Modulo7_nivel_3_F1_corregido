package com.vehicles.project.Vehicles;

import java.util.ArrayList;
import java.util.List;


public abstract class Reg_Vehi {
	protected int id;	
	protected plate Plate;
	protected String person_id;
	private static int COUNTER_REG_VEH = 1;
	protected static List<Reg_Vehi> lista_re_veh = new ArrayList<>();   // lista de registros de vehiculos en el sistema acumulativos  
                                                  // este registro historico solo acumula, falta implementar estados de los mismos
//  constructor	
public Reg_Vehi(plate plate, String person_id) {
		Plate = plate;
		this.person_id = person_id;
		id = COUNTER_REG_VEH;
		COUNTER_REG_VEH++;
		lista_re_veh.add(this);		
	}
//  metodos
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public plate getPlate() {
	return Plate;
}
public void setPlate(plate plate) {
	Plate = plate;
}
public String getPerson_id() {
	return person_id;
}
public void setPerson_id(String person_id) {
	this.person_id = person_id;
}
public static List<Reg_Vehi> getLista_re_veh() {
	return lista_re_veh;
}
public static void setLista_re_pro(List<Reg_Vehi> lista_re_pro) {
	Reg_Vehi.lista_re_veh = lista_re_veh;
}
public static boolean existe_registro (plate plate, String person_id) {
  boolean val=false;
	for (Reg_Vehi r: lista_re_veh) {
		if (plate.equals(r.getPlate()) && person_id.equals(r.getPerson_id())) {val=true;}
	}
  return val;
}
public static int id_registro (plate plate, String person_id) {
	int id;
	id = -1;
	for (Reg_Vehi r: lista_re_veh) {
			if (plate.equals(r.getPlate()) && person_id.equals(r.getPerson_id())) {id=r.id;}
		}
	  return id;
	}
@Override
public String toString() {
	return "Reg_Vehic id= " + id + ", Plate= " + Plate 
			+ ", person_id= " + person_id +"\n";
}
}
