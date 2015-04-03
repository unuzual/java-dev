package indexer;

public class ByteMaker {

	public static int numberOfBits=8;
	
	public int charConverter(char a){
		
		int code = (int) a;
	
		return code;
	}
	
	public String integerConverter(int a){
		
		String converted = Integer.toBinaryString(a);
		
		String properLenghtString = sanitize(converted,4);
		
		return properLenghtString;
	}
	
	public String binaryCharConverter(char a){
		
		int numToConvert = charConverter('a');
		
		String converted = Integer.toBinaryString(numToConvert);
		
		String properLenghtString = sanitize(converted,1);
		
		return properLenghtString;
		
	}
	
	public int sizeInBits(int a){
		
		int size=0;
		
		switch(a){
			case 2:
				size=2*numberOfBits;
				break;
			case 4:
				size=4*numberOfBits;
				break;
			default:
				size=1*numberOfBits;
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
	
	
	
public static void main(String[] args) {
	
	ByteMaker test = new ByteMaker();
	
	System.out.println(test.binaryCharConverter('x'));
	System.out.println(test.integerConverter(8));

	
}	
	
}