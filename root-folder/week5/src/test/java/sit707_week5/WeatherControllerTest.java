package sit707_week5;

import org.junit.Assert;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

public class WeatherControllerTest {

    private WeatherController wController;
    private double[] hourlyTemperatures;
    private int nHours;

    @Before
    public void setUp() {
        wController = WeatherController.getInstance();
        nHours = wController.getTotalHours();
        hourlyTemperatures = new double[nHours];
        for (int i = 0; i < nHours; i++) {
            hourlyTemperatures[i] = wController.getTemperatureForHour(i + 1);
        }
    }
    @After
    public void tearDown() {
        wController.close();
    }

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
    public void testTemperatureMin() {
        System.out.println("+++ testTemperatureMin +++");

        double minTemperature = Double.MAX_VALUE;
        for (int i = 0; i < nHours; i++) {
            if (minTemperature > hourlyTemperatures[i]) {
                minTemperature = hourlyTemperatures[i];
            }
        }

        Assert.assertTrue(wController.getTemperatureMinFromCache() == minTemperature);
    }

    @Test
    public void testTemperatureMax() {
        System.out.println("+++ testTemperatureMax +++");
        double maxTemperature = Double.MIN_VALUE;
        for (int i = 0; i < nHours; i++) {
            if (maxTemperature < hourlyTemperatures[i]) {
                maxTemperature = hourlyTemperatures[i];
            }
        }
        Assert.assertTrue(wController.getTemperatureMaxFromCache() == maxTemperature);
    }

    @Test
    public void testTemperatureAverage() {
        System.out.println("+++ testTemperatureAverage +++");
        double sumTemp = 0;
        for (int i = 0; i < nHours; i++) {
            sumTemp += hourlyTemperatures[i];
        }
        double averageTemp = sumTemp / nHours;
        Assert.assertTrue(wController.getTemperatureAverageFromCache() == averageTemp);
    }

}
    /*
    @Test
    public void testTemperaturePersist() {
        System.out.println("+++ testTemperaturePersist +++");

        // Initialise controller
        WeatherController wController = WeatherController.getInstance();

        String persistTime = wController.persistTemperature(10, 19.5);
        String now = new java.text.SimpleDateFormat("H:m:s").format(new java.util.Date());
        System.out.println("Persist time: " + persistTime + ", now: " + now);

        Assert.assertTrue(persistTime.equals(now));

        wController.close();
    }
    */ 
