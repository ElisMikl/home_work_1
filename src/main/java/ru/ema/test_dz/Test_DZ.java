package ru.ema.test_dz;

import java.util.Scanner;
import ru.ema.test_dz.export_xml.*;

final class Test_DZ {
    private static boolean run_program = true;
	public static void main(String[] args) {
	while(run_program)	{
		System.out.println("Программа учета оборудования v0.1"+"\n"
				+ "введите 1 и нажмите Enter если хотите добавить оборудование"+"\n"
				+ "введите 2 и нажмите Enter если хотите получить информацию по оборудованию"+"\n"
				+ "введите 3 и нажмите Enter если хотите выгрузить данные в XML"+"\n"
				+ "введите 0 и нажмите Enter для выхода из программы");
		@SuppressWarnings("resource")
		Scanner console = new Scanner(System.in);
        String str = console.nextLine();
        
           switch(str)  {
             case  ("1"):
         		System.out.println("введите название скважины");
                String str_name_well = console.nextLine();
                System.out.println("введите количество оборудования");
                String str_num_equipment_well = console.nextLine();
                int num_equipment_well = 0;
                try {
                	num_equipment_well = Integer.parseInt(str_num_equipment_well);
                    if(num_equipment_well>0){
                   	    new Add_equipment_to_DB(num_equipment_well, str_name_well);
                   	    }
                    else{
                    	    System.out.println("ошибка, введите кол-во цифрами и больше 0");
                    	 }
                	}
                	catch (NumberFormatException e){
                		 System.out.println("ошибка, введите кол-во используя только цифры и больше 0");
                	}

               
               break;

             case ("2"):
            	 System.out.println("введите названия скважин разделенных пробелами или запятыми");
            	 String name_well_list = console.nextLine();
                  if(name_well_list.length()<1) {
                	  System.out.println("ошибка, введите название скважины");
                       }
                  else {
                	    new Get_info_of_equipment(name_well_list);
                       }
                  
               break;

             case ("3"):
            	 System.out.println("введите название файла для экспорта без расширения");
                 String name_file_export = console.nextLine();
                 if(name_file_export.length()<1) {
               	  System.out.println("ошибка, введите название файла");
                      }
                 else {
                	   new Export_XML(name_file_export);
                      }
               break;
             case ("0"):
            	      run_program = false;
               break;
       }
	}
  }
}
