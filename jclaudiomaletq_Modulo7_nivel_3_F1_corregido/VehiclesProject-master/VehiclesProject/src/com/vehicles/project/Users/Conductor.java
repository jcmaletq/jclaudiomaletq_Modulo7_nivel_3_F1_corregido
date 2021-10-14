package com.vehicles.project.Users;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

public class Conductor extends Person  {
protected drive_license doc_driv_licen; 
protected static List<Conductor> lista_co = new ArrayList<>();   // lista de conductores en el sistema acumulativos
//  constructores
public Conductor(String name, String surname, Date birth_date, String person_id, drive_license doc_driv_licen) {
	super(name, surname, birth_date, person_id);
	this.doc_driv_licen = doc_driv_licen;
	lista_co.add(this);
}

public Conductor() throws Exception {
		super("Conductor");
		 drive_license doc_driv_licen = new drive_license(
			this.name+ " " + this.surname, this.person_id) ;
		this.doc_driv_licen = doc_driv_licen;
		lista_co.add(this);
	}
public Conductor(String tipo) throws Exception {
	super(tipo);
	 drive_license doc_driv_licen = new drive_license(
		this.name+ " " + this.surname, this.person_id) ;
	this.doc_driv_licen = doc_driv_licen;
	if (tipo.equals("Conductor")) {	lista_co.add(this);}
}
public Conductor(String tipo, String tipo_v, String type_dl) throws Exception {  // segun tipo de persona, tipo de vehiculo y tipo de licencia
	super(tipo);
	 drive_license doc_driv_licen = new drive_license(
		this.name+ " " + this.surname, this.person_id, type_dl) ;
	this.doc_driv_licen = doc_driv_licen;
	if (tipo.equals("Conductor")) {	lista_co.add(this);}
}

// metodos
public drive_license getDoc_driv_licen() {
		return doc_driv_licen;
	}

public void setDoc_driv_licen(drive_license doc_driv_licen) {
		this.doc_driv_licen = doc_driv_licen;
	}

public static List<Conductor> getLista_co() {
	return lista_co;
}

public static int f_nuevo_conductor() throws Exception {
		int id;
		id = 0;
		Conductor cond = new Conductor();
		id= cond.get_id();
		increm_conta_pers();
		return id;
	   }
public static int f_nuevo_conductor_reg(String tipo, String type_dl) throws Exception {
	int id;
	id = 0;
	Conductor cond = new Conductor("Conductor",tipo,type_dl);
	id= cond.get_id();
	increm_conta_pers();
	return id;
   }

public static void crea_conductor() throws Exception {
	Conductor cond = new Conductor();
	increm_conta_pers();
   }
public static int get_conductor_id (String name, String surname) {
	int id;
	id = -1;
	for (Person p: getLista_co()) {
		if (name.equals(p.getName()) 
				&& surname.equals(p.getSurname())
		   ){id=p.id;}
	}
	return id;
}
public static Conductor Get_Conductor_p_id(String person_id) {
	Conductor pe;
	pe= null;
	for (Conductor p: getLista_co()) {
		if (person_id == p.getPerson_id()) {pe=p;}
	}
	return pe;
}
public static Conductor Get_Conductor(int p_id) {
	Conductor pe;
	pe= null;
	for (Conductor p: getLista_co()) {
		if (p_id == p.get_id()) {pe=p;}
	}
	return pe;
}
public String getType_dl_c() {
	String ret="";
	ret = doc_driv_licen.getType_dl();
	return ret;
}

@Override
public String toString() {
	return "Conductor "+"\n"+"id=" + id + ", name= " + name + ", surname= " + surname+"\n"
			+ ", birth_date= " + new SimpleDateFormat("yyyy-MM-dd").format(birth_date) 
			+ ", person_id=" + person_id 
			+ "\n" + "doc_driv_licen= " + doc_driv_licen+"\n"; 
}
	
}
