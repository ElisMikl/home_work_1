package ru.ema.test_dz;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

final class Add_equipment_to_DB {
	
	 private  Connection conn = new Conn_DB().conn_sqllite();
	  
	  Add_equipment_to_DB(int quantity_equipment, String name_well){
		  
		if(check_name_well_on_table(name_well))
	       	{
			  add_equipment(quantity_equipment,get_well_id(name_well));
	    	}
		else 
		   {
			  add_well(name_well);
			  add_equipment(quantity_equipment,get_well_id(name_well));	
		   }
	   }
	
    boolean check_name_well_on_table(String name_well) {
    	String check_name_well_on_table = "SELECT COUNT(*) NAME FROM  WELL WHERE name = '" + name_well +"'";
    	
        try (Statement stmt = conn.createStatement()){
        	 ResultSet rs = stmt.executeQuery(check_name_well_on_table); 
        	
	       	    if (rs.next()) 
	       	        {
	       	        if(rs.getInt(1)>0)      	             
	       	            return true;      
	       	     System.out.println("!!!"+rs.getInt(1));
	       		    }		 
	          }
           catch (SQLException e) {
		     // TODO Auto-generated catch block
  			   e.printStackTrace();
        	 //For Example
        	  System.out.println("Невозможно выполнить запрос");
		      }
        return false;       
       }
    
     int get_well_id(String name_well) {
    	int well_id = 0;
    	String get_well_id = "SELECT ID FROM  WELL WHERE name = '" + name_well +"'";
    	
    	 try (Statement stmt = conn.createStatement()){
        	 ResultSet rs = stmt.executeQuery(get_well_id); 
	       	    if (rs.next()) {
	       	    	well_id = rs.getInt(1);
	       		   }		 
	          }    	   
           catch (SQLException e) {
		     // TODO Auto-generated catch block
  			   e.printStackTrace();
        	 //For Example
        	  System.out.println("Невозможно выполнить запрос");
		      }
    	    return well_id;
         }
 
     void  add_well(String new_name_well) {
     	String query_add_new_name_well = "INSERT INTO WELL (name) VALUES('"+new_name_well+"')";
         try (Statement pstmt = conn.createStatement()){
        	 
        	 pstmt.executeUpdate(query_add_new_name_well); 
     	
             } catch (SQLException e) {
 		     // TODO Auto-generated catch block
 		     e.printStackTrace();
 	        } 	
       }
     
    void  add_equipment(int quantity_equipment, int well_id) {
    	boolean exist = false;
        String query_check_name_Equipment = "SELECT ID FROM Equipment WHERE NAME ='?'";
    	
    	String query_add_well = "INSERT INTO Equipment (name,Well_id) VALUES(?,?)";
    	
    	String new_name_equipment = null;
    	while(!exist) {
     try (PreparedStatement pstmt_check = conn.prepareStatement(query_check_name_Equipment)){ 
    	  new_name_equipment = new Gen_name().gen_new_name();
    	  //pstmt_check.executeUpdate();
    	  System.out.println(new_name_equipment);
    	  pstmt_check.setString(1,  new_name_equipment);
    	  ResultSet rs_check = pstmt_check.executeQuery();
    	  
      	  if(rs_check.next()==false) {
    		//Add Equipment
    	        try (PreparedStatement pstmt_add = conn.prepareStatement(query_add_well)){
    	        	 for(int i=0;i<quantity_equipment;i++) {   	        		 
    	        		 
    	        		 pstmt_add.setString     (1,  new_name_equipment);        		 
    	        		 pstmt_add.setBigDecimal (2,  new BigDecimal(well_id));
    	        		 pstmt_add.executeUpdate();
    	        		 exist = true;
    	        	 }
    	    	    	           
    	      }}}
	         	
        //End add Equipment
        catch (SQLException e) {
		  // TODO Auto-generated catch block
		  e.printStackTrace();
	     }	
       }}
}
