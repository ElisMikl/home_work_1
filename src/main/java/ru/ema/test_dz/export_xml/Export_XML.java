package ru.ema.test_dz.export_xml;

import java.util.ArrayList;
import java.util.List;

public final class Export_XML {
	 
	 private   List <Data_for_XML> arrForExport = new ArrayList <Data_for_XML>();
	public Export_XML (String xml_file_name ){
		
			
		new  Get_data_for_XML(arrForExport);
		if(!arrForExport.isEmpty()) {
		   new  Create_XML(xml_file_name,arrForExport);}
		else {
		   System.out.println("Нет данных для экспорта в XML");}
	}

}
