package com.qa.tests;

import com.qa.base.TestBase;
import com.qa.client.RestClient;
import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import java.io.IOException;

public class GetAPITest extends TestBase{
    TestBase testBase;
    String apiurl;
    String serviceUrl;
    String url;
    RestClient restClient;

    public GetAPITest() throws IOException {
    }
    @BeforeMethod
    public void setUp() throws IOException {
        System.out.println("1 Hello..");
        // call the constructor of the BaseClass
        testBase = new TestBase(); // initialize the prop object
        //service URL & apiurl

        url = prop.getProperty("url");
        System.out.println("The URI is: "+url);
    }

    @Test
    public void getAPITest() throws IOException {
        restClient = new RestClient();
        restClient.get(url);

    }
}
