package ru.ema.test_dz;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

final class Get_info_of_equipment {
	        Get_info_of_equipment(String name_well){
	          String  wordStr = null;	
	      	  Conn_DB conndb = new Conn_DB();
	    	  Connection conn = conndb.conn_sqllite();
	        		        	        	
	        	String text = name_well;
	        	String[] words = text.split("\\s*(\\s|,)\\s*");
        	
	        	try (Statement stmt = conn.createStatement()){
	        		for(String word : words) {
	        			wordStr = word;
	    	        	String  query_well_sumEquipment = 
	    	        			"SELECT well.name,count(equipment.id)  FROM  equipment\r\n" + 
	    	        			"LEFT  JOIN well\r\n" + 
	    	        			"on well.id = equipment.Well_id\r\n" + 
	    	        			"WHERE well.name =  ('"+wordStr+"')\r\n" + 
	    	        			"group by well.name";
	            	    ResultSet rs = stmt.executeQuery(query_well_sumEquipment);
	            	      if(rs.next()==false) {
	            	    	  System.out.println("Нет данных по  скважине "+wordStr); }
	            	      else {
		        			 do{	        			 
			        			   System.out.println("Скважина-" + rs.getString(1) +" | кол-во оборудования-"+rs.getInt(2));        		 
			        		   }
		        			 while (rs.next());}
	        	    	       }
                 	  } catch (SQLException e) {
	        	  // TODO Auto-generated catch block
	        	  e.printStackTrace();
	        	 }	

  }
}




