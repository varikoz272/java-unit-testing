package algorithm;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RemoveDuplicateLetters implements Testable {

 	public static void swap(String array, int f, int s) {
 		StringBuilder sb = new StringBuilder(array);
 		
 		char temp = array.charAt(f);
 		sb.setCharAt(f, array.charAt(s));
 		sb.setCharAt(s, temp);
 		
 		array = sb.toString();
 	}
	
	public static void quickSort(String array, int from, int until) {
 		
 		if (from >= until)
 			return;
 		
 		int pivot = array.charAt(until);
 		
 		int l = from;
 		int r = until;
 		
 		while (l < r) {
 			
 			while (array.charAt(l) <= pivot && l < r)
 				l++;
 			
 			while (array.charAt(r) >= pivot && l < r)
 				r--;
 			
 			swap(array, l, r);
 		}
 		swap(array, l, until);
 		
 		quickSort(array, from, r - 1);
 		quickSort(array, l + 1, until);
 	}
	
    public String removeDuplicateLetters(String s) {
    	
    	String out = new String("");
    	
        for (int start = 0; start < s.length(); start++)
        	
        	if (!out.contains(s.subSequence(start, start + 1)))
        		out += s.charAt(start);
        
        quickSort(out, 0, out.length() - 1);
        return out;
    }
    
	@Override
	public void leetCodeTest() {
		assertEquals("bca", removeDuplicateLetters("bcabc"));
		assertEquals("cbad", removeDuplicateLetters("cbacdcbc"));
	}

	@Override
	public void test() {
		assertEquals("t", removeDuplicateLetters("tttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt"));
	}

}
