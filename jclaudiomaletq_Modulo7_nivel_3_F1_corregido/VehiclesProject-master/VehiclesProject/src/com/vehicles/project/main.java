package com.vehicles.project;

//import java.util.List;
import javax.swing.*;
import com.vehicles.project.Users.Conductor;
import com.vehicles.project.Users.Person;
import com.vehicles.project.Users.Titular;
import com.vehicles.project.Users.drive_license;
//import com.vehicles.project.Vehicles.Bike;
//import com.vehicles.project.Vehicles.Car;
import com.vehicles.project.Vehicles.Reg_Conduc;
import com.vehicles.project.Vehicles.Reg_Propi;
//import com.vehicles.project.Vehicles.Truck;
import com.vehicles.project.Vehicles.Vehicle;

/*
* el dialogo es por pantalla y uso la consola para el log y los resultados.
* Nivel 1 F1
	 * Volem fer un software per un taller de vehicles, que en aquest moment té motos i cotxes. 
	 * Els cotxes sempre tindran quatre rodes i les motos dues.  
	 * Ens demanen crear una classe Main que realitzi els següents passos: 
	 * Demanar a l’usuari la matrícula del cotxe, la marca i el seu color. 
	 * Crear el cotxe amb les dades anteriors.  
	 * Afegir-li dues rodes traseres demanant a l’usuari la marca i el diametre. 
	 * Afegir-li dues rodes davanteres demanant a l’usuari la marca i el diametre. 
* F2
	* Millorar el codi anterior comprovant la informació necesaria alhora de crear els objectes. S’ha de tenir en compte: 
	* Una matrícula ha de tenir 4 números i dues o tres lletres. 
	* Un diametre de la roda ha de ser superior a 0.4 i inferior a 4
* F3 
	* Modifica el projecte anterior afegint els mètodes necessaris a Bike, de manera que es pugui afegir rodes davanteres 
	* i traseres.  
 	* Modificar el Main anterior, afegint la opció de Bike o Car: 
	* Preguntar a l’usuari si vol crear un cotxe o una moto.  
	* Demanar a l’usuari la matrícula, la marca i el seu color.
	* Crear el vehícle amb les dades anteriors. 
	* Afegir-li les rodes traseres corresponents, demanant a l’usuari la marca i el diametre
	* Afegir-li les rodes davanteres corresponents, demanant a l’usuari la marca i el diametre.
* Nivel 2 F1
 	* Modifica l’exercici per afegir camió com a vehicle disponible. 
* Nivel 2 F2
 	* Crea dos classes: Titular de Vehicle i Conductor (també fes una classe Persona com a herència). 
 	* El conductor ha de tenir, nom, cognoms, data de naixement i llicencia de conduir. Aquest ultima també serà una 
 	* classe a part que tindrà: ID, tipus de llicència, nom complet i data de caducitat. 
 	* El Titular ha de tenir els mateixos valors que el conductor, però també s'ha de registrar si té assegurança i 
 	* garatge propi. 
* Nivel 2 F3
 	*Abans de seleccionar el vehicle has de crear l'usuari (tipus Titular) amb totes les dades ja emplenades. 
 	*Per poder crear un vehicle has de tenir la llicència adequada, de no tenir-la t'ha d'avisar amb una excepció. 
 	*A l'acabar de crear el vehicle, ha de demanar si el titular també serà el conductor. 
 	*De no ser així has de crear un nou usuari. En fer-ho hi ha de comprovar si la llicència del conductor li permet 
 	*conduir el vehicle creat. 
 * Nivel 3 F1	 
	* En aquesta fase modificaràs l’exercici per que es registri la quantitat de Persones y vehicles que es creen. 
	* L’aplicació ha d’acabar nomes quan s’indiqui que s’acabi, per tan pots crear tants vehicles i persones com vulguis. 
	* Has de tenir 2 menus separats, un per crear usuaris i un altre per crear vehicles.  
	* Modifica el main per tenir la llista de persones i vehicles. 
	* Modifica la clase vehicle, afegeix dos camps, un camp tipus Titular per assignar-li un titular al vehicle i 
	* una llista de Persones (que seran els conductors, el titular pot ser conductor). 
	* Al crear un vehicle s'ha d'assignar un titular al vehicle i donar la possibilitat d'afegir conductors. 
	* Tots ells han de tenir la llicència adequada. 
	* Has de poder crear múltiples persones (conductors o titulars) i múltiples vehicles fins que decideixis 
	* acabar el programa. 
*/
/*
 *     ARBOLES DE MENUS
 *     					  1  para Menu de usaurios"			menu_usuarios();
								  1 para Gestionar Titular"
												si asigan vehiculo busca_vehiculo_m o crea_vehiculos_m
												Reg_Propi.add_reg_pro(ve, tit)
								  2 para Gestionar Conductor"
												si asigan vehiculo busca_vehiculo_m o crea_vehiculos_m
												Reg_Conduc.add_reg_cond (ve, co)
								  0 para Salir"				
 					      2  para Menu de vehiculos"		menu_vehiculos();
									   1 para motos"
									   2 para coches"
									   3 para camiones"
									   0 para Salir"		
												menu_titular(vehic)
													crea_titular_m  o busca_titular_m	
														f_nuevo_titular_reg
														
													crea_vehiculo(ti, vehic)
														Reg_Propi.add_reg_pro(ve, tit)
													menu_conductor(vehic)
														crea_conductor_m  o busca_conductor_m
															f_nuevo_conductor_reg, 
 					  0  para Salir"
 * 
 */
public class main {

	public static void main(String[] args) throws Local_exceptions {
		opera_datos.datos_historicos();	   // carga datos para comprobar constructores para historicos y listas
		//variables locales
 		String choi;
 		boolean ask_end = false;
 		// menu para consultar que se desea 
 		ask_end = false;
 		while (!ask_end) {
 			choi=JOptionPane.showInputDialog("Seleccion de menu"
 					+"\n"+"   1  para Menu de usaurios"
 					+"\n"+"   2  para Menu de vehiculos"
 					+"\n"+"   0  para Salir"
 		         ,"1");
 			switch (choi) {
 			case "1" :
 				menu_usuarios();
 				break;			
 			case "2" :
				menu_vehiculos();
				break;					
 			case "0" :
				ask_end= true;
				break; 				
			default:
			JOptionPane.showMessageDialog(null,"opcion no valida");
 			}
 		}
	     resultado_resumen();
	     resultado_total();
	}
  public static void menu_vehiculos() {
		//variables locales
		String choi,vehic= "";
		Titular ti;
		Conductor co;
		Vehicle ve;
		boolean ask_end = false;
		// menu para consultar que se desea 
		ask_end = false;
 		while (!ask_end) {
 			choi=JOptionPane.showInputDialog("menu vehiculos ¿que se desea gestionar?"
 					+"\n"+"   1 para motos"
 					+"\n"+"   2 para coches"
 					+"\n"+"   3 para camiones"
 					+"\n"+"   0 para Salir"
 		         ,"1");
 			switch (choi) {
 			case "1" :
 				vehic = "BIKE";
 				break;
 			case "2" :
 				vehic = "CAR";
				break;	
 			case "3" :
 				vehic ="TRUC";
				break;					
 			case "0" :
				ask_end= true;
				break; 				
			default:
			JOptionPane.showMessageDialog(null,"opcion no valida");
 			}
		if (vehic != "") {ti = menu_titular(vehic);
							if (ti != null) {ve=crea_asign_vehiculo(ti, vehic);
							                 co = menu_conductor(vehic);
							                 if (co!=null) 
							                 { Reg_Conduc.add_reg_cond(ve, co);}
							                }
							ask_end = true;
							}	
 		}
  }
  public static void menu_usuarios() {  
		//variables locales
		String vehic= "";
		String res = "";
		String choi= "";
		String asig = "";
		Titular ti;
		Conductor co;
		Vehicle ve = null;
		boolean ask_end = false;
		// menu para consultar que se desea 
		boolean ask_end1 = false;
		while (!ask_end) {
			choi=JOptionPane.showInputDialog("Seleccion de menu"
					+"\n"+"   1 para Gestionar Titular"
					+"\n"+"   2 para Gestionar Conductor"
					+"\n"+"   0 para Salir"
		         ,"1").toUpperCase();
			if (choi != "0" ) {
				asig=JOptionPane.showInputDialog("se quiere asiganar a un vehiculo","si").toUpperCase();
				if (asig.equals("SI")) {
					ve =  menu_vehiculo();
		 			    	if(ve == null) {JOptionPane.showMessageDialog(null,"vehiculo no seleccionado o creado");  choi = "0";}     //  no creado o encontrado, por lo que no gestiona personas
		 				}                                               
				}		
 			switch (choi) {
 			case "1" :
 				ti = menu_titular(vehic);                                          // gestiona titular
 				if (asig.equals("SI")&&ti!=null){Reg_Propi.add_reg_pro (ve, ti);}
 				ask_end= true;
 				break;
 			case "2" :
 				co = menu_conductor(vehic);                                        // gestiona conductor     
 				if (asig.equals("SI")&&co!=null){Reg_Conduc.add_reg_cond (ve, co);}
 				ask_end= true;
				break;						
 			case "0" :
				ask_end= true;
				break; 				
			default:
			JOptionPane.showMessageDialog(null,"opcion no valida");
 			}
	 }
  }  

  //   metodos para menus
  public static Titular menu_titular(String tipo) {     // tipo indica el tipo de vehiculo
	Titular tit= null;
	String res="";
	boolean ask_end = false;
	while (!ask_end) {	
		 res = (JOptionPane.showInputDialog(
				 " n para crear uno nuevo titular "+"\n"
				 +" 0 para salir "+"\n"
				 + drive_license.lista_regis_Conducir()  +"\n"
			     +"¿el titular existe y tiene registro para el tipo de vehiculo " //+tipo

			     + "? indica el número ").toUpperCase());
		 if (res.equals("N")) {								// crea nuevo titular
			 	tit=crea_tiutlar_m(tipo);	    // tipo indica el tipo de vehiculo
		   			}
			 else {	 if (!(res.equals("0"))) {	tit= busca_titular_m(res);  }				  // busca titular 
			 if (res.equals("0")) {	ask_end = true;}
			 }
		 if(tit == null ) {}     //  no creado
		 else { ask_end = true;}
	}
	return tit;
  }
  public static Conductor menu_conductor(String tipo) {     // tipo indica el tipo de vehiculo
	Conductor con= null;
	String res="";
	boolean ask_end = false;
	while (!ask_end) {	
	 res = (JOptionPane.showInputDialog(
			 " n para crear uno nuevo conductor "+"\n"
					 +" 0 para salir "+"\n"
					 + drive_license.lista_regis_Conducir()  +"\n"
		     +"¿el conductor existe y tiene registro para el tipo de vehiculo " //+tipo
		     + "? indica el número ").toUpperCase());
	     if (res.equals("N")) {													// crea nuevo conductor
		    con = crea_conductor_m(tipo); }							 // tipo indica el tipo de vehiculo
	    else {	 if (!res.equalsIgnoreCase("0")) {	con= busca_conductor_m(res);  }				  // busca titular 
		  if (res.equals("0")) {	ask_end = true;}
	    	 }
    	if(con == null) {}     //  no creado
			 else {ask_end = true;}
	}
 return con;
  } 
  public static Vehicle menu_vehiculo() {
	 Vehicle ve= null; 
	 boolean ask_end1 = false;
	 String res,vehic;
		while (!ask_end1) {	                                    // seleccion vehiculo a asignar 
			 res = (JOptionPane.showInputDialog(
					 " n para crear uno nuevo vehiculo "+"\n"
							 +" 0 para salir "+"\n"
							 + Vehicle.Get_Lista_ve() +"\n"
				     +"¿el vehiculo existe  " //
				     + "? indica el número ").toUpperCase());
			     if (res.equals("N")) {												 // crea nuevo vehiculo  segun tipo
			    	  vehic = pide_tipo_vehiculo();
			    	  ve=crea_vehiculos_m(vehic);                                                     
					  ask_end1 = true;
				     }					
			       else { if (!res.equalsIgnoreCase("0")) {	ve=busca_vehiculo_m(Integer.parseInt(res));     // busca vehiculo en los existentes
			                                                 vehic = Vehicle.Get_tipo_ve(ve); 
			                                            	ask_end1 = true;}
			             }
				 if (res.equals("0")) {	ask_end1 = true;}
			    }	
	return ve;	
  }
  public static String pide_tipo_vehiculo() {
	  String vehic="";
		do{	
			try {vehic=JOptionPane.showInputDialog("introduce para que vehiculo se quiere gestionar coche, moto o camion","bike/car/truck").toUpperCase();
			      }
			  catch (Exception e)
			       {  System.out.println("error no se ha introducido vehiculo");
		//	         throw  new Local_exceptions("tipo vehiculo desconocido"); 
			         //System.exit(0);
			         }
			} while (! Vehicle.vehic_valid(vehic));
		return vehic;
  }
  public static Conductor crea_conductor_m(String tipo ){    // tipo indica el tipo de vehiculo
	  Conductor con=null;
	  int con_id=0;
	  String type_dl = "";
	  type_dl = (JOptionPane.showInputDialog(
			             drive_license.lista_tipos_Conducir()  +"\n"
		                 +"¿que tipo de licencia tiene"
		                + "? indica todos separados por coma ", "A,B")).toUpperCase();
        if(drive_license.val_Type_dl(type_dl, tipo )) {
                  try {con_id = Conductor.f_nuevo_conductor_reg(tipo,type_dl); }
	                           catch (Exception e) {} // {throw new Local_exceptions("no se ha creado el conductor");}
 	                           con = Conductor.Get_Conductor(con_id);
           } else {JOptionPane.showMessageDialog(null," Licencia no valida para vehiculo ");  // licencia no valida								 
	 		}	
    return con;
  }
  
  
  public static Titular crea_tiutlar_m(String tipo) {    // tipo indica el tipo de vehiculo
	Titular tit=null;
	int tit_id=0;
	String type_dl="";
	  type_dl = (JOptionPane.showInputDialog(
						  drive_license.lista_tipos_Conducir()  +"\n"
					     +"¿que tipo de licencia tiene"
					     + "? indica todos separados por coma ", "A,B").toUpperCase());
	  if(drive_license.val_Type_dl(type_dl, tipo )) {
			 try {tit_id = Titular.f_nuevo_titular_reg(tipo,type_dl); }
				catch (Exception e) {} // {throw new Local_exceptions("no se ha creado el titular");}
				tit = Titular.Get_Titular(tit_id);
		 } else {	JOptionPane.showMessageDialog(null," Licencia no valida para vehiculo ");  // licencia no valida								 
		 		}				
	  return tit;
  }
  public static Titular busca_titular_m(String res) {
	  Titular tit=null;
	  int id=0;
	  try {id = Integer.parseInt(res);} catch (NumberFormatException e) {id= 0;}
	  String person_id= drive_license.Get_Person_id_lic(id);
	  tit = Titular.Get_Titular_p_id(person_id);
	  return tit;
  }
  public static Conductor busca_conductor_m(String res) {
	  Conductor con=null;
	  int id=0;
	  try {id = Integer.parseInt(res);} catch (NumberFormatException e) {id= 0;}
	  String person_id= drive_license.Get_Person_id_lic(id);
	  con = Conductor.Get_Conductor_p_id(person_id);
	  return con;
  }
  public static Vehicle busca_vehiculo_m(int id) {                     
	  Vehicle ve=null;
	  ve = Vehicle.Get_Vehicle(id);
	  return ve;
  }
  
  public static Vehicle crea_asign_vehiculo( Titular tit, String tipo) {
	Vehicle ve=null;
	 ve=crea_vehiculos_m(tipo);
	 ve.setPerson_id(tit.getPerson_id());
	 Reg_Propi.add_reg_pro(ve, tit);
	return ve;
  }
  
  public static Vehicle crea_vehiculos_m( String tipo) {
		Vehicle ve=null;
		 int v_id= 0;
		 v_id = Vehicle.Crea_Vehicle(tipo);
		 ve=Vehicle.Get_Vehicle(v_id);
		return ve;
	  }	  

  public static void resultado_resumen() {


	     System.out.println("Personas creadas= "+Person.get_conta_pers());
	     System.out.println("Vehiculos creados = "+ Vehicle.get_conta_vehic());
//	     System.out.println(Reg_Propi.getLista_re_pro());
//	     System.out.println(Reg_Conduc.getLista_re_con());
	     JOptionPane.showMessageDialog(null,"Personas creadas= "+Person.get_conta_pers()+"\n"+
	    		 "Vehiculos creados = "+ Vehicle.get_conta_vehic());

}

  
  public static void resultado_total() {
	     System.out.print("People   ******"+"\n");
	     System.out.println(Person.getLista_pe());
	     System.out.print("Vehicles   ******"+"\n");
	     System.out.println(Vehicle.getLista_ve());
	     System.out.print("Owners History  ******"+"\n");
	     System.out.println(Reg_Propi.getLista_re_pro());
	     System.out.print("Drivers   ******"+"\n");
	     System.out.println(Reg_Conduc.getLista_re_con());
	     JOptionPane.showMessageDialog(null,
	    		 "People   ******"+"\n"+
	    		 Person.getLista_pe().toString()+
	    		 "Vehicles   ******"+"\n"+
	    		 Vehicle.getLista_ve()+
	    		 "Owners History  ******"+"\n"+
	    		 Reg_Propi.getLista_re_pro()+
	    		 "Drivers   ******"+"\n"+
	    		 Reg_Conduc.getLista_re_con());

  }
}
