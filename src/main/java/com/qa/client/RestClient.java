package com.qa.client;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;


public class RestClient {

//  1. Get Method
    public void get(String url) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault(); //from HttpClients dependency
        HttpGet httpGet = new HttpGet(url); //http get request
        CloseableHttpResponse closableHttpResponse = httpClient.execute(httpGet); // hit the GET URL

        //a. Status Code:
        int statusCode = closableHttpResponse.getStatusLine().getStatusCode(); // fetch status code after from header
        System.out.println("Status Code===>>"+ statusCode); // print the statusCode from above line

        //b. Json String:
        String responseString = EntityUtils.toString(closableHttpResponse.getEntity(), "UTF-8");

       JSONObject jsonObject = new JSONObject(responseString);
        System.out.println("Response JSON from API.."+ jsonObject);

        //c. All Headers
        Header[] headersArray = closableHttpResponse.getAllHeaders();
        HashMap<String, String> allHeaders = new HashMap<String, String>();
        for (Header header : headersArray){
            allHeaders.put(header.getName(), header.getValue());
        }
        System.out.println("Header Array -->>"+ allHeaders);

    }
    // 1. Get Method
    //a.Status Code:
    //b.Json String:


/*//1. GET Method without Headers:
public CloseableHttpResponse get(String url) throws ClientProtocolException, IOException{
    CloseableHttpClient httpClient = HttpClients.createDefault();
    HttpGet httpget = new HttpGet(url); //http get request
    CloseableHttpResponse closebaleHttpResponse =  httpClient.execute(httpget); //hit the GET URL

    return closebaleHttpResponse;

}*/


}
