package com.vehicles.project.Users;
import java.text.*;
import java.util.*;

import javax.swing.JOptionPane;

public class drive_license {
	protected String type_dl;
	protected String fullname;
	protected String person_id;
	protected Date exp_date;
	protected String cd_drive_license;
	protected int id;
	private static int COUNTER_LICE = 1;
	protected static List<drive_license> lista_dl = new ArrayList<>();
	private static List<String> type_ca = Arrays.asList ("A","B","C","D","BTP");
	private static List<String> type_bike = Arrays.asList ("A","B","C","D");
	private static List<String> type_car = Arrays.asList ("B","C","D");
	private static List<String> type_truck = Arrays.asList ("C","D","BTP");
// constructor	
	public drive_license(String type_dl, String fullname,  String person_id, Date exp_date,
			String cd_drive_license) {
	//	super();
		this.type_dl = type_dl;
		this.fullname = fullname;
		this.person_id = person_id;
		this.exp_date = exp_date;
		this.cd_drive_license = cd_drive_license;
		id = COUNTER_LICE;
		COUNTER_LICE++;
		lista_dl.add(this);
	}
	public drive_license( String fullname, String person_id) 
			throws Exception{
		//super();
		String type_dl ="";
		String e_d;
		String type_d = (JOptionPane.showInputDialog("introudce el maximo tipo de licencia","A..btp")).toUpperCase();
		type_dl=clean_Type_dl(type_d);
		type_dl= type_dl.substring(0,type_dl.length()-1);
/*		for (String s: type_ca) {
		   if(type_d.contains(s )) {
			   type_dl= type_d; }
		 }*/
		 
		e_d = JOptionPane.showInputDialog("introudce fecha expiracion ","2030/12/30");			
		if (e_d.equals(""))
			throw new Exception("Fecha expiracion vacia");
		this.type_dl = type_dl;
		this.fullname = fullname;
		this.person_id = person_id;
		this.exp_date = new SimpleDateFormat("yyyy/MM/dd").parse(e_d);
		this.cd_drive_license = JOptionPane.showInputDialog("introudce el codigo de licencia",person_id);
		id = COUNTER_LICE;
		COUNTER_LICE++;
		lista_dl.add(this);
	}
	public drive_license( String fullname, String person_id, String type_dl) 
			throws Exception{
		//super();
		String e_d;	 
		e_d = JOptionPane.showInputDialog("introudce fecha expiracion ","2030/12/30");			
		if (e_d.equals(""))
			throw new Exception("Fecha expiracion vacia");
		this.type_dl = type_dl;
		this.fullname = fullname;
		this.person_id = person_id;
		this.exp_date = new SimpleDateFormat("yyyy/MM/dd").parse(e_d);
		this.cd_drive_license = JOptionPane.showInputDialog("introudce el codigo de licencia",person_id);
		id = COUNTER_LICE;
		COUNTER_LICE++;
		lista_dl.add(this);
	}
	
// metodos	
public static boolean val_Type_dl(String types, String vehic ) {
		boolean val=false;
		List<String> type_v; 
		type_v=null;
		if (vehic.equals("CAR")) {type_v=type_car;} 
		if (vehic.equals("BIKE")) {type_v=type_bike;}
		if (vehic.equals("TRUCK")) {type_v=type_truck;}
		String str_t[] = types.split(",");	
		for (String sl: str_t){
			for (String s: type_v) {
				   if(sl.equals(s )) {
					   val= true; }
		    }
		}
		return val;
	}
public String clean_Type_dl(String types) {
	String val="";
	String str_t[] = types.split(",");	
	for (String sl: type_ca){
		for (String s: str_t) {
			   if(sl.equals(s )) {
				   val= val+s+","; }
	    }
	}
	return val;
}
public String getType_dl() {
	String typ;
	typ = type_dl;
return typ;
	}

public String getPerson_id() {
	return person_id;
}
public void setPerson_id(String person_id) {
	this.person_id = person_id;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public void setType_dl(String type_dl) {
		this.type_dl = type_dl;
	}
public static String lista_regis_Conducir() {
    String ret="";
	for (drive_license s: lista_dl ) {
	   ret+= s.id + " tipo = " + s.type_dl + " person_id= " + s.person_id+ " fullname= " + s.fullname + "\n";}
	return ret;
}
public static String Get_Person_id_lic(int id) {
    String ret="";
	for (drive_license s: lista_dl ) {
	  if(id==s.getId()) {ret = s.getPerson_id();}
	}
	return ret;
}
public static String lista_tipos_Conducir() {
    String ret="";
	for (String  l: type_ca ) {
	   ret+= l + "\n";}
	return ret;
}
@Override
public String toString() {
		return "drive_license" +"\n"+" type_dl= " + type_dl + ", fullname= " + fullname + "\n"+
				", person_id= " + person_id+"\n"+
				 ", exp_date= " + new SimpleDateFormat("yyyy-MM-dd").format(exp_date) + ", cd_drive_license= " + 
				cd_drive_license + ", id= " + id+"\n" ;
	}
	
}
