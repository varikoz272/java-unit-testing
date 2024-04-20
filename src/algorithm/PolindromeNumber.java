package algorithm;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PolindromeNumber implements Testable {
	
    public boolean isPalindrome(int x) {
    	
    	if (x < 0) return false;
    	
    	String strX = Integer.toString(x);
    	double middle = strX.length() / 2.0;
    	for (int i = 0; i < middle; i++)
    		if (strX.charAt(i) != strX.charAt(strX.length() - i - 1))
    			return false;
    	
    	return true;
    }
	


	@Override
	public void leetCodeTest() {
		assertEquals(true, isPalindrome(121));
		assertEquals(false, isPalindrome(-121));
		assertEquals(false, isPalindrome(10));
	}

	@Override
	public void test() {
		assertEquals(false, isPalindrome(1011));
		assertEquals(true, isPalindrome(11011));
		assertEquals(false, isPalindrome(-11011));
	}
	
	@Override
	public void fullTest() {
		test();
		leetCodeTest();
	}

}
