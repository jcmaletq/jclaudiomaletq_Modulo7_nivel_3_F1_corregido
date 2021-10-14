package com.vehicles.project.Users;
import java.text.*;
import java.util.*;
import javax.swing.*;

public abstract class Person {
	protected int id;
	protected String name;
	protected String surname;
	protected Date birth_date;
	protected String person_id;
	private static int COUNTER_PERSON = 1;
	private static int COUNT_CYCLE_PERSON = 0;
	protected static List<Person> lista_pe = new ArrayList<>();
// constructor	
public Person(String name, String surname, Date birth_date, String person_id) {
	this.name = name;
	this.surname = surname;
	this.birth_date = birth_date;
	this.person_id = person_id;
	id = COUNTER_PERSON;
	COUNTER_PERSON++;
	lista_pe.add(this);
}
public Person(String name, String surname) {
	this.name = name;
	this.surname = surname;
	id = COUNTER_PERSON;
	COUNTER_PERSON++;
	lista_pe.add(this);
}

public Person(String tipo) throws Exception {  // tipo conductor o titular
	String name;
	String surname, person_id;
	String b_d;
	name = JOptionPane.showInputDialog("introudce el nombre del "+tipo,"nombre"+tipo);
			if (name.equals(""))
				throw new Exception("Nombre vacio");
	surname = JOptionPane.showInputDialog("introudce apellido  "+name+" "+tipo ,"apellido"+tipo);			
			if (surname.equals(""))
				throw new Exception("Apellido vacio");
	b_d = JOptionPane.showInputDialog("introudce fecha nacimiento "+name +" "+tipo,"2021/12/31");			
			if (b_d.equals(""))
				throw new Exception("Fecha vacia");
	Date dat;
	dat = null;
	try {		
	  dat = new SimpleDateFormat("yyyy/MM/dd").parse(b_d);
	} catch (Exception e)
		    {  System.out.println("error en la fecha");
		    System.exit(0);
		     }
	person_id = JOptionPane.showInputDialog("introudce el documento personal  "+name+" "+tipo ,"DNI"+tipo);			
	if (surname.equals(""))
		throw new Exception("Documento vacio vacio");
	if (get_person_id (name, surname)==-1) {
		this.name = name;
		this.surname = surname;
	    this.birth_date = dat;
	    this.person_id = person_id;
		id = COUNTER_PERSON;
		COUNTER_PERSON++;
		lista_pe.add(this);
	    }
   }
// metodos
public static void increm_conta_pers() {
	COUNT_CYCLE_PERSON++;
	}
public static int get_conta_pers(){
	  int conta=COUNT_CYCLE_PERSON;
		return conta;
	}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getSurname() {
	return surname;
}
public void setSurname(String surname) {
	this.surname = surname;
}
public Date getBirth_date() {
	return birth_date;
}
public void setBirth_date(Date birth_date) {
	this.birth_date = birth_date;
}
public String getPerson_id() {
	return person_id;
}
public int get_id() {
	return id;
}
public void setPerson_id(String person_id) {
	this.person_id = person_id;
}
public String fullSurname() {
	return surname+" "+name;
}
public static int get_person_id (String name, String surname) {
	int id;
	id = -1;
	for (Person p: getLista_pe()) {
		if (name.equals(p.getName()) && surname.equals(p.getSurname())) {id=p.id;}
	}
	return id;
}
public static Person Get_Person(int p_id) {
	Person pe;
	pe= null;
	for (Person p: getLista_pe()) {
		if (p_id == p.get_id()) {pe=p;}
	}
	return pe;
}

public static List<Person> getLista_pe() {
	return lista_pe;
}
public static void setLista_pe(List<Person> lista_pe) {
	Person.lista_pe = lista_pe;
}
public String toString() {
	return "Conductor "+"\n"+"id=" + id + ", name= " + name + ", surname= " + surname+"\n"
			+ ", birth_date= " + new SimpleDateFormat("yyyy-MM-dd").format(birth_date) 
			+ ", person_id=" + person_id ;   //+"\n"; 
}

}
