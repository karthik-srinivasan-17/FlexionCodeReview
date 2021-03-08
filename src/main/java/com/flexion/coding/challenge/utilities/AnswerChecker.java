package com.flexion.coding.challenge.utilities;

public class AnswerChecker {
	
	 public static boolean checkTemperature(String fromUnit, String toUnit, double askedValue, double studentResponse) {
		
		 String constString = fromUnit+"_to_"+toUnit;
		 double additional = 0.0;
		 try {
			 additional = Constants.getValue(constString) - 1.0;
		} catch (ReflectiveOperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 double result = askedValue + additional;
		/* System.out.println("result : "+ result);
		 System.out.println("Math.round(result * 10) : "+ Math.round(result * 10));
		 System.out.println("Math.round(studentResponse * 10) : "+ Math.round(studentResponse * 10));*/
		 return Math.round(result * 10) == Math.round(studentResponse * 10);	    
	   }
	 
	 public static boolean checkVolume(String fromUnit, String toUnit, double askedValue, double studentResponse) {
			
		 String constString = fromUnit+"_to_"+toUnit;
		 double multiplier = 1;
		 try {
			 multiplier = Constants.getValue(constString);
		} catch (ReflectiveOperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 double result = askedValue * multiplier;
//		 System.out.println("result : "+ result);
//		 System.out.println("Math.round(result * 10) : "+ Math.round(result * 10));
//		 System.out.println("Math.round(studentResponse * 10) : "+ Math.round(studentResponse * 10));
		 return Math.round(result * 10) == Math.round(studentResponse * 10);	    
	   }

}
