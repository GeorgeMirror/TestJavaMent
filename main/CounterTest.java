package main;
import java.util.HashMap;

public class CounterTest {
	String str1;
	String str2;
	int a=0;
	int b=0;
	int test=0; //0 - error, 1 - arab, 2 - roman
	String error;

	HashMap<String, Integer> roma = new HashMap<String, Integer>();
	
	public CounterTest(String string, String string2) {
		createMap();
		str1 = string;
		str2 = string2;
		Test();
	}
	
	public CounterTest() {
		createMap();
	}

	private void createMap() {
		roma.put("I", 1);
		roma.put("II", 2);
		roma.put("III", 3);
		roma.put("IV", 4);
		roma.put("V", 5);
		roma.put("VI", 6);
		roma.put("VII", 7);
		roma.put("VIII", 8);
		roma.put("IX", 9);
		roma.put("X", 10);
	}

	/**
	 * 
	 */
	public void Test() {
		test = 0;
		try{
			a = Integer.parseInt(str1);
			if ((a>0)&&(a<=10)) 
					test = 1;
			else {
				error ="Operands must be in [1, 10] interval";
				test = 0;
			}
		}catch(Exception e){
			if (roma.containsKey(str1)){
				a = roma.get(str1);
				test = 2;
			}
			else 
			{ 
				error = "First operand must be a number";
				test = 0;
			}
		}
		
		if (test==1) {
			try {
				b = Integer.parseInt(str2);
				if ((b<=0)||(b>10))
				{
					error = "Operands must be in [1, 10] interval";
					test = 0;
				}
			}catch(Exception e){
				error = "Second operand must be a number AND the same tipe like first";
				test = 0;
			}
		}
		if (test==2){
			if  (roma.containsKey(str2)) {
				b = roma.get(str2);
			}
			else
			{
				test = 0;
				error = "Second operand must be a number AND the same tipe like first";
			}
		}		
	}
	
	public String getRomanNumber(int number) {
	    if (number == 0) return "nulla";
		
	    return nCopies(number, "I")
	            .replace("IIIII", "V")
	            .replace("IIII", "IV")
	            .replace("VV", "X")
	            .replace("VIV", "IX")
	            .replace("XXXXX", "L")
	            .replace("XXXX", "XL")
	            .replace("LL", "C")
	            .replace("LXL", "XC")
	            .replace("CCCCC", "D")
	            .replace("CCCC", "CD")
	            .replace("DD", "M")
	            .replace("DCD", "CM");
	}

	private String nCopies(int number, String string) {
		String str = "";
		for (int i=0;i<number;i++) {
			str=str+"I";
		}
		return str;
	}

	public String plus() {
		int s = a + b;
		if (test==1) return Integer.toString(s);
			else if (test==2) return getRomanNumber(s);
		return error;
	}

	public String minus() {
		int s = a - b;
		if (test==1) 
			return Integer.toString(s);
		else if (test==2) 
			if (s>=0) 
				return getRomanNumber(s);
			else return "-" + getRomanNumber(-s);
		return error;
	}

	public String mult() {
		int s = a * b;
		if (test==1) return Integer.toString(s);
			else if (test==2) return getRomanNumber(s);
		return error;
	}

	public String div() {
		int s = a / b;
		if (test==1) return Integer.toString(s);
			else if (test==2) return getRomanNumber(s);
		return error;
	}

}
