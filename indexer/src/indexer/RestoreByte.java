package indexer;

public class RestoreByte extends ByteMaker {

	public char restoreChar(String a){ 
		
		char properChar = (char) Integer.parseInt(a,2);
		
		return properChar;
	}
	
	public String restoreString(String a){
		
		String properString=new String();
		
		for(int i=0,j=0;i<a.length();i++)
		{
			if(i==7){
				String temp = a.substring(0, i+1);
				properString+=restoreChar(temp);
				j+=2;
			}
			
			else if(i==j*8-1)
			{
				String temp = a.substring((j-1)*8, i+1);
				properString+=restoreChar(temp);
				j++;
			}	
			
		}
		
		return properString;
	}
	
	
	
public static void main(String[] args) {
	
	RestoreByte test = new RestoreByte();
	String example = test.binaryCharConverter('8');
	String example2 = test.stringConverter("Frase Teste Espero que Funcione");
	
	//System.out.println(test.restoreChar(example));
	//System.out.println(test.integerConverter(20000));
	//System.out.println(test.stringConverter("ab200000"));
	//System.out.println(test.booleanConverter(false));
	System.out.println(example2);
	System.out.println(test.restoreString(example2));
	
	
}	
	
}
