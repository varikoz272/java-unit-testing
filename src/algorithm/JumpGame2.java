package algorithm;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JumpGame2 implements Testable {
	
	public JumpPair[] checkedCache;
	
	public int amountOfJumpsToFinish(int[] array, int startIndex, int curAmountOfJumps) {
		
		if (startIndex >= array.length - 1) return curAmountOfJumps;
		if (checkedCache[startIndex] != null)
			if (curAmountOfJumps >= checkedCache[startIndex].amountOfJumps)
				return checkedCache[startIndex].amountOfJumps;
		
        int shortestPath = -1;
        
        for (int i = array[startIndex]; i > 0; i--) {
        	
            int result = amountOfJumpsToFinish(array, startIndex + i, curAmountOfJumps + 1);
            if (result != -1) {
                if (shortestPath == -1) shortestPath = result;
                else if (shortestPath > result) shortestPath = result;
            }
        }
        
        checkedCache[startIndex] = new JumpPair(startIndex, shortestPath);
        return shortestPath;
    }
    
    public int jump(int[] array) {
    	checkedCache = new JumpPair[array.length];
        return amountOfJumpsToFinish(array, 0, 0);
    }
    
    public static int[] getSlice(int[] fullArray, int from, int length) {
    	
    	int correctSliceLength = (from + length <= fullArray.length) ? length : fullArray.length - from;
    	
    	int[] slice = new int[correctSliceLength];
    	for (int i = 0; i < correctSliceLength; i++)
    		slice[i] = fullArray[i + from];
    	
    	return slice;
    }
    
    public static void swap(int[] array, int f, int s) {
 		int buf = array[f];
 		array[f] = array[s];
 		array[s] = buf;
 	}
	
	public static void quickSort(int[] array, int from, int until) {
 		
 		if (from >= until)
 			return;
 		
 		int pivot = array[until];
 		
 		int l = from;
 		int r = until;
 		
 		while (l < r) {
 			
 			while (array[l] <= pivot && l < r)
 				l++;
 			
 			while (array[r] >= pivot && l < r)
 				r--;
 			
 			swap(array, l, r);
 		}
 		swap(array, l, until);
 		
 		quickSort(array, from, r - 1);
 		quickSort(array, l + 1, until);
 	}
    
    
	public static class JumpPair {
		final int start;
		final int amountOfJumps;
		
		public JumpPair(int start, int amountOfJumps) {
			this.start = start;
			this.amountOfJumps = amountOfJumps;
		}
	}


	@Override
	public void leetCodeTest() {
		assertEquals(2, jump(new int[] {2,3,1,1,4}));
		assertEquals(2, jump(new int[] {2,3,0,1,4}));
	}

	@Override
	public void test() {
		assertEquals(1, jump(new int[]{1, 0}));
	}
}

