package sit707_week6;

import org.junit.Assert;
import org.junit.Test;

public class WeatherAndMathUtilsTest {
	
	@Test
	public void testStudentIdentity() {
		String studentId = "223764339";
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Nikhil Kalra";
		Assert.assertNotNull("Student name is null", studentName);
	}
	
	@Test
	public void testFalseNumberIsEven() {
		Assert.assertFalse("9 should not be even", WeatherAndMathUtils.isEven(9));
	}
	
	@Test
	public void testTrueNumberIsEven() {
		Assert.assertTrue("8 should be even", WeatherAndMathUtils.isEven(8));
	}
	
	@Test
	public void testPrimeNumber() {
		Assert.assertTrue("7 should be prime", WeatherAndMathUtils.isPrime(7));
	}



	@Test
	public void testCancelWeatherAdvice_DangerousWind() {
		Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(70.1, 0.0));
	}

	@Test
	public void testCancelWeatherAdvice_DangerousRain() {
		Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(0.0, 6.1));
	}

	@Test
	public void testCancelWeatherAdvice_ConcerningCombined() {
		Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(50.0, 4.5));
	}

	@Test
	public void testWarnWeatherAdvice_WindOnly() {
		Assert.assertEquals("WARN", WeatherAndMathUtils.weatherAdvice(46.0, 0.0));
	}

	@Test
	public void testWarnWeatherAdvice_RainOnly() {
		Assert.assertEquals("WARN", WeatherAndMathUtils.weatherAdvice(0.0, 4.5));
	}

	@Test
	public void testAllClearWeatherAdvice() {
		Assert.assertEquals("ALL CLEAR", WeatherAndMathUtils.weatherAdvice(20.0, 2.0));
	}
}
