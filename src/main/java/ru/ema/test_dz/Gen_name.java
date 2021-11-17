package ru.ema.test_dz;

import java.util.Random;

final class Gen_name  {	
	private  String new_name = null;
	   
	 String gen_new_name(){		
	    String random_num = genIntRandom(1000);
	    //return genStringRandom(2)+random_num;
	     switch(random_num.length()) {
	       case (1):
             random_num = "000"+random_num;
             break;
	       case (2):
	         random_num = "00"+random_num;
	         break;
	       case (3):
	         random_num = "0"+random_num;
	         break;
	     }
	     new_name = genStringRandom(3) + random_num ;
	     return new_name;
	   }
	
    String genStringRandom(int length){
       Random rand=new Random();
 	   String possibleLetters = "QWERTYUIOPASDFGHJKLZXCVBNM";   
 	   StringBuilder sb = new StringBuilder(length);
 	   for(int i = 0; i < length; i++) 
 	      sb.append(possibleLetters.charAt(rand.nextInt(possibleLetters.length()))); 	   
 	   return sb.toString();
 	  }
    
    String genIntRandom(int max_number) {
    	int    gen_random_num = 1 + (int) (Math.random() * max_number);    	
    	return new Integer(gen_random_num).toString();
      }

}
