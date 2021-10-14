package com.vehicles.project.Users;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

public class Titular extends Conductor {
	protected String insurance;
	protected boolean garage;
	protected static List<Titular> lista_ti = new ArrayList<>();   // lista de titulares en el sistema acumulativos
// constructores	
public Titular(String name, String surname, Date birth_date, String person_id, 
			        drive_license doc_driv_licen,
			String insurance, boolean garage) {
		super(name, surname, birth_date, person_id, 
				   doc_driv_licen);
		this.insurance = insurance;
		this.garage = garage;
		lista_ti.add(this);
	}
public Titular() throws Exception {
  super("Titular");
   String insurance = JOptionPane.showInputDialog("introudce el seguro","seg_");
	boolean garage;
	if("SI".equals(JOptionPane.showInputDialog("introudce si si tiene garage ","SI")))
			{ garage = true;} else {garage = false;}
  this.insurance = insurance;
  this.garage = garage;
  lista_ti.add(this);
}
public Titular(String tipo) throws Exception {  // tipo titular
	  super(tipo);
	String insurance = JOptionPane.showInputDialog("introduce el seguro","seg_");
	boolean garage;
	if("SI".equals(JOptionPane.showInputDialog("introduce si si tiene garage ","SI")))
			{ garage = true;} else {garage = false;}		
	this.insurance = insurance;
	this.garage = garage;
	lista_ti.add(this);
}

public Titular(String tipo, String type_dl) throws Exception {  // tipo vehiculo  type_dl tipo carnet
	  super("Titular",tipo, type_dl);
	String insurance = JOptionPane.showInputDialog("introduce el seguro","seg_");
	boolean garage;
	if("SI".equals(JOptionPane.showInputDialog("introduce si si tiene garage ","SI")))
			{ garage = true;} else {garage = false;}		
	this.insurance = insurance;
	this.garage = garage;
	lista_ti.add(this);
}

// metodos
public String getInsurance() {
	return insurance;
}
public void setInsurance(String insurance) {
	this.insurance = insurance;
}
public boolean isGarage() {
	return garage;
}
public void setGarage(boolean garage) {
	this.garage = garage;
}

public static List<Titular> getLista_ti() {
	return lista_ti;
}
public static int f_nuevo_titular() throws Exception {
	int id;
	id = 0;
	Titular tit = new Titular();
	id= tit.get_id();
	increm_conta_pers();
	return id;
   }
public static int f_nuevo_titular_reg(String tipo, String type_dl) throws Exception {  // tipo vehiculo type_dl tipo registro
	int id;
	id = 0;
	Titular tit = new Titular(tipo, type_dl);
	id= tit.get_id();
	increm_conta_pers();
	return id;
   }

public static void crea_titular() throws Exception {
  Titular tit = new Titular();
  increm_conta_pers();
}
public String getPerson_id() {
	return person_id;
}
public static int get_titular_id (String name, String surname) {
	int id;
	id = -1;
	for (Titular p: getLista_ti()) {
		if (name.equals(p.getName()) 
				&& surname.equals(p.getSurname())
		   ){id=p.id;}
	}
	return id;
}
public static Titular Get_Titular(int p_id) {
	Titular pe;
	pe= null;
	for (Titular p: getLista_ti()) {
		if (p_id == p.get_id()) {pe=p;}
	}
	return pe;
}
public static Titular Get_Titular_p_id(String person_id) {
	Titular pe;
	pe= null;
	for (Titular p: getLista_ti()) {
		if (person_id == p.getPerson_id()) {pe=p;}
	}
	return pe;
}
public String getType_dl_t() {
	String typ;
	typ = doc_driv_licen.getType_dl();
	return typ;
}
@Override
public String toString() {
	return "vehicle holder "+"\n"+"id=" + id + ", name= " + name + ", surname= " + surname+"\n"
			+ ", birth_date= " + new SimpleDateFormat("yyyy-MM-dd").format(birth_date) 
			+ ", person_id=" + person_id 
			+ "\n" + "doc_driv_licen= " + doc_driv_licen			
			+", insurance= " + insurance + ", garage= " + garage+"\n"; 
}

}
