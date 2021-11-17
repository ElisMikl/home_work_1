package ru.ema.test_dz.export_xml;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ru.ema.test_dz.Conn_DB;
//import ru.ema.test_dz.export_xml.Arr_of_equipment.Get_clone_arr;

final  class Get_data_for_XML {


	   @SuppressWarnings("unchecked")
	Get_data_for_XML(List<Data_for_XML> arrForExport){
		
		   	List<Well_list> well_list = new ArrayList<>();
	
		      	  Conn_DB conndb = new Conn_DB();
		    	  Connection conn = conndb.conn_sqllite();		        		        	        	
	        	
		        	try (Statement stmt = conn.createStatement()){
                           
		    	        	String  get_list_well = "SELECT ID,NAME FROM WELL";
		            	    ResultSet rs = stmt.executeQuery(get_list_well);
			        			 while(rs.next()) 
			        			     {
			        				  	well_list.add(new Well_list(rs.getInt(1),rs.getString(2)));        		 
				        			 }
			        	         rs.close();
			        	         stmt.close();		 
			        	         
			        	         ArrayList<Array_of_equipment> arrEquipment = new ArrayList<>();
			        	                   	    
			        	    	 try (PreparedStatement  pstmt = conn.prepareStatement
			        	    		 ("SELECT ID,NAME FROM EQUIPMENT WHERE WELL_ID = ?")){
			        	    		    for(Well_list well : well_list) {
			        	    		    	
			        	    			   pstmt.setInt(1, well.get_id_well());

			                     	  		ResultSet rs2 = pstmt.executeQuery();
        	    			    	        arrEquipment.clear();
			        	    			      while(rs2.next())
			        	    			            {
			        	    			    	     arrEquipment.add(new Array_of_equipment(rs2.getInt(1),rs2.getString(2)));
			                                        }
			        	    			      arrForExport.add(new Data_for_XML(well.get_id_well(),well.get_name_well(), (ArrayList) arrEquipment.clone()));
			        	    			     

			        	    		     }
			        	    		   }
			        	    		 
	                 	  } catch (SQLException e) {
		        	  // TODO Auto-generated catch block
		        	  e.printStackTrace();
		        	 }	

	  }
		  
}
 final class Well_list{
	  int id_well = 0;
	  String name_well = null;
	  
	    Well_list(int id_well, String name_well){
	    	 this.id_well = id_well;
	    	 this.name_well = name_well;
	 }
/*	 void set_id_well(int id_well){
		 this.id_well = id_well;
	 }
	 void set_name_well(String name_well){
		 this.name_well = name_well;
	 }
*/
	 int get_id_well(){
		return id_well;
	 }
	 String get_name_well(){
		return name_well;
	 }
 }




