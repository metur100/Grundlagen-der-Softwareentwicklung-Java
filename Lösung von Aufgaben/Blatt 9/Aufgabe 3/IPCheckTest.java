import org.junit.Test;
import static org.junit.Assert.*;

public class IPCheckTest {

	@Test
	public void randomInRange() {
		for (int i = 0; i < 1000000; i++) {
			String ip = generateRandomIPInRange();
			assertTrue(ip, IPCheck.check(ip));			
		}
	}

	@Test
	public void randomOutOfRange() {
		for (int i = 0; i < 1000000; i++) {
			String ip = generateRandomIPNotInRange();
			assertFalse(ip, IPCheck.check(ip));			
		}
	}

	@Test 
	public void rangeBorder() {
		assertTrue(IPCheck.check("172.16.0.0"));
		assertTrue(IPCheck.check("172.31.255.255"));
	}

	private static String generateRandomIPInRange() {
		int v1 = 172;
		int v2 = randomPositiveIntInRange(16, 31);
		int v3 = randomPositiveIntInRange(0, 255);
		int v4 = randomPositiveIntInRange(0, 255);

		return v1 + "." + v2 + "." + v3 + "." + v4;
	}

	private static String generateRandomIPNotInRange() {
		int v1 = randomPositiveIntNotInRange(172, 172);
		int v2 = randomPositiveIntNotInRange(16, 31);
		int v3 = randomPositiveIntInRange(0, 255);
		int v4 = randomPositiveIntInRange(0, 255);

		return v1 + "." + v2 + "." + v3 + "." + v4;
	}

	private static int randomPositiveIntInRange(int rangeStartIncl, int rangeEndIncl) {
		return (int) (Math.random() * (rangeEndIncl - rangeStartIncl)) + rangeStartIncl;
	}

	private static int randomPositiveIntNotInRange(int rangeStartIncl, int rangeEndIncl) {
		if (Math.random() > 0.5) {
			return randomPositiveIntInRange(0, rangeStartIncl - 1);
		} else {
			return randomPositiveIntInRange(rangeEndIncl + 1, 255);
		}
	}
}
