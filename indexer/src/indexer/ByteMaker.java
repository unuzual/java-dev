package indexer;
import java.lang.Math;

public class ByteMaker {

	public static int valueOfBits=8;
	public int sizeInBits(int a){
		
		int size=0;
		
		switch(a){
			case 2:
				size=2*valueOfBits;
				break;
			case 4:
				size=4*valueOfBits;
				break;
			default:
				size=1*valueOfBits;
				break;
			}
		
		return size;
		
	}
	
	public String sanitize(String a,int sizeInBytes){
		
		int targetLength= sizeInBits(sizeInBytes);
		
		int zeroesToAdd=targetLength-a.length();
		
		String zero = new String();
		
		for(int i=0;i<zeroesToAdd;i++)
			zero+='0';
		
		String finalString = zero+a;
		
		return finalString;
	}
	
	//Char Converter
	
	public String binaryCharConverter(char a){
		
		int numToConvert = (int) a;
		
		String converted = Integer.toBinaryString(numToConvert);
		
		String properLenghtString = sanitize(converted,1);
		
		return properLenghtString;
		
	}
	
	//int and long Converter
	
	public String integerConverter(int a){
		
		String properLenghtString=new String();
		int maxMin = (int) Math.pow(2,15);
		
		System.out.println(-maxMin);
		
		if(a< -maxMin||a> maxMin-1){
			String converted = Integer.toBinaryString(a);
			properLenghtString = sanitize(converted,4);
		}
		
		else{	
		
		String converted = Integer.toBinaryString(a);
		
		properLenghtString = sanitize(converted,2);
		
		}
		
		return properLenghtString;
	}
	
	//String Converter
	
	public String stringConverter(String a){
		
		char [] array = a.toCharArray(); 
		String properLenghtString = new String();

		for(int i =0;i<a.length();i++)
		{
		    properLenghtString+=binaryCharConverter(array[i]);
		}
		
		return properLenghtString;
	}
	
	//Boolean Converter
	
	public String booleanConverter(boolean a){
		
		String properLenghtString = sanitize((a?"1":"0"),1);		
		
		
		return properLenghtString;
	}


	
}
