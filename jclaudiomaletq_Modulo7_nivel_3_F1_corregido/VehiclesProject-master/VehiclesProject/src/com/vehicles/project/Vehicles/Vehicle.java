package com.vehicles.project.Vehicles;


import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import com.vehicles.project.Vehicles.colors;
import com.vehicles.project.Users.Conductor;
import com.vehicles.project.Users.Person;

public abstract class Vehicle {
	protected int id;
	protected plate Plate;
	protected String brand;
	protected String color;
	protected String person_id;       // persona actual propietaria en la lista de registros se puede ver el historico
	protected List<Wheel> wheels = new ArrayList<Wheel>();
	protected List<Conductor> Conductores = new ArrayList<>();                              // lista de person_id de los conductores
	protected static List<Vehicle> lista_ve = new ArrayList<>();
	private static int COUNTER_VEHICLE = 1;
	private static int COUNT_CYCLE_VEHICLE = 0;
// consturctores
	public Vehicle(plate Plate, String brand, String color, String person_id) {
		this.Plate = Plate;
		this.brand = brand;
		this.color = color;
		this.person_id = person_id;
		id = COUNTER_VEHICLE;
		COUNTER_VEHICLE++;
		lista_ve.add(this);
	}
	public Vehicle(String tipo) {
		String vbrand,vcolor;		
		int val;
		boolean vali=false;
		vbrand =null;
		vcolor = null;
		do { Plate= plate.ask_plate(tipo);
		    }
		while (!  plate_valid_n (Plate));
		try {vbrand=JOptionPane.showInputDialog("introudce la marca del vehiculo" +tipo,"Brand "+ tipo);
		      val = vbrand.length();   // para detectar el cancel 
		     }
		  catch (Exception e)
		      {  System.out.println("error no se ha introducido la marca del " +tipo);
		         System.exit(1);
		       }
		
		    do {
		        vcolor=JOptionPane.showInputDialog("introudce el color del vehiculo" +tipo,colors.lista_colores());
		        vali = colors.contains(vcolor);  
		      }  while (!vali);
		this.brand = vbrand;
		this.color = vcolor;
		id = COUNTER_VEHICLE;
		COUNTER_VEHICLE++;
		lista_ve.add(this);
	}
	// metodos
	protected abstract void addConductor(Person pe);
	
	public static boolean vehic_valid (String vehic) {
		boolean valid;
		valid = false;
		if (vehic.equals("CAR")) {
			valid = true;}
		if (vehic.equals("BIKE")) {
			valid = true;}	
		if (vehic.equals("TRUCK")) {
			valid = true;}			
		return valid;
	 }
	public static boolean plate_valid_n (plate n_plate) {		
		return n_plate.Val_long_N_plate() && n_plate.Val_let_N_plate() && n_plate.Val_num_N_plate();
	}
	public  plate getPlate() {
		return Plate;
	}
	public void setPlate(plate plate) {
		Plate = plate;
	}
	public int getId() {
		return id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	public String getPerson_id() {
		return person_id;
	}
	public void setPerson_id(String person_id) {
		this.person_id = person_id;
	}
	public static Vehicle Get_Vehicle(int v_id) {
		Vehicle ve;
		ve= null;
		for (Vehicle v: getLista_ve()) {
			if (v_id == v.getId()) {ve=v;}
		}
		return ve;
	}
	public static String Get_tipo_ve(Vehicle ve){
	String ret= "";
	if(ve.getClass() == Car.class) {ret="CAR";}
	if(ve.getClass() == Bike.class) {ret="BIKE";}
	if(ve.getClass() == Truck.class) {ret="TRUCK";}
	return ret;
	}
	
  public static int Crea_Vehicle( String tipo) {
			//	Vehicle ve=null;
				 int v_id= 0;
				 if (tipo.equals("CAR") ) 
					{v_id=Car.f_crea_Car();} 
				 if (tipo.equals("BIKE") )
					{v_id=Bike.f_creaBike();}
				 if (tipo.equals("TRUCK") ) 
					{v_id=Truck.f_crea_Truck();}
		//		 ve=Vehicle.Get_Vehicle(v_id);
				return v_id;
	  }
  public static void increm_conta_vehic() {
	COUNT_CYCLE_VEHICLE++;
	}
  public static int get_conta_vehic(){
	  int conta=COUNT_CYCLE_VEHICLE;
		return conta;
	}
  public static String Get_Lista_ve() {
	  String ret="";
	  	for (Vehicle v: getLista_ve()) {
	     ret+= "Id= "+v.getId()+" Plate= "+v.getPlate() +" Owner= "+v.getPerson_id()+" Brand= " + v.getBrand() +"\n" ;
	  }
	  return ret;
}
	public static List< Vehicle> getLista_ve() {
		return lista_ve;
}
	
}
