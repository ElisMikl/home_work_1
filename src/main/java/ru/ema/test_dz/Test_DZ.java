package ru.ema.test_dz;

import java.util.Scanner;
import ru.ema.test_dz.export_xml.*;

final class Test_DZ {
    private static boolean run_program = true;
	public static void main(String[] args) {
	while(run_program)	{
		System.out.println("��������� ����� ������������ v0.1"+"\n"
				+ "������� 1 � ������� Enter ���� ������ �������� ������������"+"\n"
				+ "������� 2 � ������� Enter ���� ������ �������� ���������� �� ������������"+"\n"
				+ "������� 3 � ������� Enter ���� ������ ��������� ������ � XML"+"\n"
				+ "������� 0 � ������� Enter ��� ������ �� ���������");
		@SuppressWarnings("resource")
		Scanner console = new Scanner(System.in);
        String str = console.nextLine();
        
           switch(str)  {
             case  ("1"):
         		System.out.println("������� �������� ��������");
                String str_name_well = console.nextLine();
                System.out.println("������� ���������� ������������");
                String str_num_equipment_well = console.nextLine();
                int num_equipment_well = 0;
                try {
                	num_equipment_well = Integer.parseInt(str_num_equipment_well);
                    if(num_equipment_well>0){
                   	    new Add_equipment_to_DB(num_equipment_well, str_name_well);
                   	    }
                    else{
                    	    System.out.println("������, ������� ���-�� ������� � ������ 0");
                    	 }
                	}
                	catch (NumberFormatException e){
                		 System.out.println("������, ������� ���-�� ��������� ������ ����� � ������ 0");
                	}

               
               break;

             case ("2"):
            	 System.out.println("������� �������� ������� ����������� ��������� ��� ��������");
            	 String name_well_list = console.nextLine();
                  if(name_well_list.length()<1) {
                	  System.out.println("������, ������� �������� ��������");
                       }
                  else {
                	    new Get_info_of_equipment(name_well_list);
                       }
                  
               break;

             case ("3"):
            	 System.out.println("������� �������� ����� ��� �������� ��� ����������");
                 String name_file_export = console.nextLine();
                 if(name_file_export.length()<1) {
               	  System.out.println("������, ������� �������� �����");
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
