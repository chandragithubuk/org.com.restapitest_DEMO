package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestBase {

    public Properties prop;

    public TestBase()  {
        try {
            prop = new Properties();
            System.out.println("2 Hello...!!!");
            //FileInputStream ip = new FileInputStream(System.getProperty("C:\\Projects\\src\\main\\java\\com\\qa\\config\\config1.properties"));
            FileInputStream ip = new FileInputStream("C:\\Projects\\src\\main\\java\\com\\qa\\config\\config1.properties");
            System.out.println("3 Hello...");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found Exception Raised..");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IOException is raised....");
            e.printStackTrace();
        }
        catch(Exception e){
            System.out.println("Some Other Exception is raised...!!");
        }
    }
}

