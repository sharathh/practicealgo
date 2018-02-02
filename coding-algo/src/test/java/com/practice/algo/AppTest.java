package com.practice.algo;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
        // Retrieve resource
        InputStream is = getClass().getResourceAsStream("/META-INF/test.properties");
        Properties prop = new Properties();
        try {
            prop.load(is);
            System.out.println(prop.getProperty("key1"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
}
