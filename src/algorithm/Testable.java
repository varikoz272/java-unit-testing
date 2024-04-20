package algorithm;

import org.junit.jupiter.api.Test;

public interface Testable {
	@Test
	public void leetCodeTest();
	
	@Test
	public void test();
	
	@Test
	public default void fullTest() {
		leetCodeTest();
		test();
	}
}
