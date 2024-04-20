package algorithm;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntToRoman implements Testable {
	
	public String[] romanToIntValues;
	
    public String intToRoman(int num) {
        
    	romanToIntValues = new String[1001];
    	romanToIntValues[1] = "I";
    	romanToIntValues[5] = "V";
    	romanToIntValues[10] = "X";
    	romanToIntValues[50] = "L";
    	romanToIntValues[100] = "C";
    	romanToIntValues[500] = "D";
    	romanToIntValues[1000] = "M";
    	
    	String roman = "";
    	
    	for (int grade = 1; grade < num; grade *= 10)
    		roman += romanToIntValues[(num % (grade * 10)) / grade];
    	
    	return roman;
    }
    
    @Override
	public void test() {
    	//todo tests
	}

	@Override
	public void leetCodeTest() {
		assertEquals("III", intToRoman(3));
		assertEquals("LVIII", intToRoman(58));
		assertEquals("MCMXCIV", intToRoman(1994));
	}

	@Override
	public void fullTest() {
		leetCodeTest();
		test();
	}

}
