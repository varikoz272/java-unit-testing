package algorithm;

public final class AlgorithmController {
	
	public static AlgorithmController instance = new AlgorithmController();
	
	private AlgorithmController() {}
	
	public void testAlgorithm(Testable algorithmInstance) {
		algorithmInstance.fullTest();
	}
	
	public void testAllAlgorithms() {
		testAlgorithm(new PolindromeNumber());
		testAlgorithm(new RemoveDuplicateLetters());
		testAlgorithm(new JumpGame2());
		testAlgorithm(new LongestPolindromicSubstring());
		testAlgorithm(new Pow());
		testAlgorithm(new IntToRoman());
	}
	
	public static void main(String[] args) {
		instance.testAllAlgorithms();
	}
}
