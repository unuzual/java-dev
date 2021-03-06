package indexer;

public class Converter {
	
	public static byte[] converterChar(char a){
		
		byte[] converter = new byte[2];
		
			for(int i=0;i<converter.length;i++){
				int shift= (8*converter.length)-(8*(i+1));
				converter[i]= (byte) ((a >> shift) & 0xFF); 
			}
		
		return converter;
	}
	
	public static byte[] converterInt(int a){
			
			byte[] converter = new byte[4];
			
				for(int i=0;i<converter.length;i++){
					int shift= (8*converter.length)-(8*(i+1));
					converter[i]= (byte) ((a >> shift) & 0xFF); 
				}
			
			return converter;
	}
	
	public static byte[] converterLong(long a){
		
		byte[] converter = new byte[8];
		
			for(int i=0;i<converter.length;i++){
				int shift= (8*converter.length)-(8*(i+1));
				converter[i]= (byte) ((a >> shift) & 0xFF); 
			}
		
		return converter;
}

	public static byte[] converterFloat(float a){
		
		byte[] converter;
		
		int base = Float.floatToIntBits(a);
		
		converter = converterInt(base);
		
		return converter;
	}
	
	public static byte[] converterDouble(double a){
		
		byte[] converter;
		
		long base = Double.doubleToLongBits(a);
		
		converter = converterLong(base);
		
		return converter;
	}
	
	public static double restoreDouble(byte[] a){
		
		double restored=0;
		
		long base = restoreLong(a);
		
		restored = Double.longBitsToDouble(base);
		
		return restored;
	}
	
	public static float restoreFloat(byte[] a){
		
		float restored=0;
		
		int base = restoreInt(a);
		
		restored = Float.intBitsToFloat(base);
		
		return restored;
	}	


	public static int restoreInt(byte[] a){
		
		int restored=0;
		
		for(int i=0;i<a.length;i++){
			int shift = (8*a.length)-(8*(i+1));
			restored += (a[i] & 0x000000FF) << shift;
		}
		
		return restored;
	}
	
	public static long restoreLong(byte[] a){
		
		long restored=0;
		
		for(int i=0;i<a.length;i++){
			int shift = (8*a.length)-(8*(i+1));
			restored += (a[i] & 0x00000000000000FF) << shift;
		}
		
		return restored;
	}

	public static char restoreChar(byte[] a){
	
		char restored=0;
		
		for(int i=0;i<a.length;i++){
			int shift = (8*a.length)-(8*(i+1));
			restored += (a[i] & 0x00FF) << shift;
		}
		
		return restored;
	}	
	
	public static void main(String[] args) {		
		byte[] a = new byte[2];
		a = converterLong(19191199L);
		System.out.println(restoreLong(a));
		
	}
}
