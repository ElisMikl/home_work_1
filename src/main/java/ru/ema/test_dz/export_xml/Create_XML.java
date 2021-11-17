package ru.ema.test_dz.export_xml;

import org.jdom2.Content;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

final class Create_XML {

	  Create_XML(String xml_file_name, List<Data_for_XML> arrForExport) {

          
          Document doc = new Document();
          Element root = new Element("dbinfo");
          
          List<Content> arr_well      = new ArrayList<Content>();
          List<Content> arr_equipment = new ArrayList<Content>();
          
          Element elem_well = new Element("well");
          Element elem_equipment = new Element("equipment");
          
          for(Data_for_XML data : arrForExport) {
        	  // Create <well name="ÀÀÀÀ" id="123"></row>
        	  elem_well.setAttribute("name", data.get_name_well());
        	  elem_well.setAttribute("id",  Integer.toString(data.get_id_well()));
        	   if (!data.arrEquipment.isEmpty()) {
                  for(Array_of_equipment data_arr : data.arrEquipment) {
                	  
                	  elem_equipment.setAttribute("name", data_arr.get_name_equipment());
                	  elem_equipment.setAttribute("id", Integer.toString(data_arr.get_id_equipment()));
                	    arr_equipment.add(elem_equipment.clone());                 	                   	   
                	    
                	     } 
        	       }
                     elem_well.addContent(arr_equipment);
                     arr_well.add(elem_well.clone());                     
                     arr_equipment.clear();
                     elem_well.removeContent();                     

                   }
            root.addContent(arr_well);
            doc.addContent(root);
            
            
          /*  XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());
            try {
                outputter.output(doc, System.out);
            } catch (Exception e) {
                e.printStackTrace();
            }
            */
            XMLOutputter xmlOutput = new XMLOutputter(Format.getPrettyFormat());
            try {
				xmlOutput.output(doc, new FileOutputStream(new File(xml_file_name+".xml")));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
         
	}

}
