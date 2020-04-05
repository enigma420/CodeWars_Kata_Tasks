package kyu_5;

import static org.junit.Assert.assertEquals;

import kyu_5.CountIPAdress.CountIPAddresses;
import org.junit.Test;

public class CountIPAddressesTest {

    @Test
    public void ipsBetweenFirstSolution() throws Exception {
        assertEquals( 50, CountIPAddresses.ipsBetweenFirstSolution( "10.0.0.0", "10.0.0.50" ) );
        assertEquals( 246, CountIPAddresses.ipsBetweenFirstSolution( "20.0.0.10", "20.0.1.0" ) );
        assertEquals( 16777216, CountIPAddresses.ipsBetweenFirstSolution( "25.0.0.0", "24.0.0.0" ) );
        assertEquals( 34542074, CountIPAddresses.ipsBetweenFirstSolution( "0.0.0.10", "2.15.18.4" ) );
    }

    @Test
    public void ipsBetweenSecondSolution() throws Exception {
        assertEquals( 50, CountIPAddresses.ipsBetweenSecondSolution( "10.0.0.0", "10.0.0.50" ) );
        assertEquals( 246, CountIPAddresses.ipsBetweenSecondSolution( "20.0.0.10", "20.0.1.0" ) );
        assertEquals( 16777216, CountIPAddresses.ipsBetweenSecondSolution( "25.0.0.0", "24.0.0.0" ) );
        assertEquals( 34542074, CountIPAddresses.ipsBetweenSecondSolution( "0.0.0.10", "2.15.18.4" ) );
    }



}