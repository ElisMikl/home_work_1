package ru.ema.test_dz.export_xml;
import java.util.ArrayList;

final class Data_for_XML {
	private int id_well = 0;
	private String name_well = null;
	 ArrayList<Array_of_equipment> arrEquipment = null;
	 
	   Data_for_XML(int id_well, String name_well, ArrayList<Array_of_equipment> arrEquipment){
	    	 this.id_well = id_well;
	    	 this.name_well = name_well;
	    	 this.arrEquipment = arrEquipment;
	   }

	int get_id_well() {		
		   return id_well;}
	   String get_name_well() {		
		   return name_well;   }
	   ArrayList<Array_of_equipment> get_arrEquipment(){
		   return arrEquipment;
	   }
   
}
final  class Array_of_equipment {
	    int id_equipment = 0;
	    String name_equipment = null;
	    	    
	Array_of_equipment(int id_equipment,String name_equipment){
	    this.id_equipment = id_equipment;
	    this.name_equipment = name_equipment;

	}
	void set_id_equipment(int id_equipment) {		
		this.id_equipment = id_equipment;   }
	void set_name_equipment(String name_equipment) {		
		this.name_equipment = name_equipment;      }
	int get_id_equipment() {		
	   return id_equipment;}
	String get_name_equipment() {		
	   return name_equipment;   }
}

	  