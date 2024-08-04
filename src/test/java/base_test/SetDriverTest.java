package base_test;

import driver.HeadDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import provider.DataProviders;

public abstract class SetDriverTest {

    @BeforeMethod
    public void setDriver() {
        HeadDriver.createDriver();
        HeadDriver.setWindowSize();
        HeadDriver.open(DataProviders.URL);
    }

    @AfterMethod
    public void closeDriver() {
        HeadDriver.closeDriver();
    }
}
