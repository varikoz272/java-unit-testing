package algorithm;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Pow implements Testable {

	public double pow(double x, int n) {
		double startX = x;
		if (n < 0) x = (1 / x) / x;
		for (int i = 1; i < n; i++)
			x *= startX;
		return x;
	}

	@Override
	public void leetCodeTest() {
		assertEquals(4, pow(2, 2));
		assertEquals(8, pow(2, 3));
		assertEquals(1024, pow(2, 10));
	}

	@Override
	public void test() {
		assertEquals(-2, pow(2, -1));
	}
}
