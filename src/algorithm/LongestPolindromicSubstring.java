package algorithm;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestPolindromicSubstring implements Testable {
	
	public static IntStringPair[] cache;
	
	
	public boolean isAlreadyChecked(int l, int r, IntStringPair[] cache) {
    	if (cache[l] != null)
    		if (cache[l].r >= r)
    			return true;
    	
    	return false;
	}
	
	public String addRecordAndGet(String str, int l, int r, IntStringPair[] cache) {
		cache[l] = new IntStringPair(r, longestPalindrome(str, l, r));
		return cache[l].longestStr;
	}
	
    public String longestPalindrome(String str, int l, int r) {
    	
    	if (isPolindrom(str.substring(l, r))) return str.substring(l, r);
    	
    	String leftResult = (isAlreadyChecked(l + 1, r, cache)) ? cache[l + 1].longestStr : addRecordAndGet(str, l + 1, r, cache);
    	String rightResult = (isAlreadyChecked(l, r - 1, cache)) ? cache[l].longestStr : addRecordAndGet(str, l, r - 1, cache);
    	
    	return (rightResult.length() < leftResult.length()) ? leftResult : rightResult;
    }
    
    public String longestPalindrome(String s) {
    	cache = new IntStringPair[s.length()];
    	return longestPalindrome(s, 0, s.length());
    }
	
    public static boolean isPolindrom(String str) {
    	double middle = str.length() / 2.0;
    	for (int i = 0; i < middle; i++)
    		if (str.charAt(i) != str.charAt(str.length() - i - 1)) return false;
    	
    	return true;
    }
	
	@Override
	public void leetCodeTest() {
		assertEquals("bab", longestPalindrome("babad"));
	}

	@Override
	public void test() {
		assertEquals("bb", longestPalindrome("cbbd"));
	}
    
	public static class IntStringPair {
		public final int r;
		public final String longestStr;
		
		public IntStringPair(int r, String longestStr) {
			this.r = r;
			this.longestStr = longestStr;
		}
	}
}
