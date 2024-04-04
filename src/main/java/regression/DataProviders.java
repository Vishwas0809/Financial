package regression;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name="Valid_details")
    public static Object[][] getCredentials() {
        return new Object[][] {
            {"testentry@fincart.com","fincart@123","rahul","India","9898989898","kjahdiuh@yopmail.com",1,"sample"},
        };
    }

    @DataProvider(name="Invalid_details")
    public static Object[] getNewLeadDetails() {
        return new Object[][] {
            {"xyz","abc","rahul","India","9898989898","kjahdiuh@yopmail.com",1,"sample"}
        };
    }
}
