package com.test.project;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.SessionId;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BaseConfig {

	public WebDriver driver = null;
	public  SessionId session = null;
	public Configuration config;
	
	public BaseConfig(){
		ObjectMapper mapper = new ObjectMapper();
        try {
			this.config = mapper.readValue(
			        getClass().getClassLoader().getResource("test-environment.json"),
			        Configuration.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	public WebDriver getDriver() {
		return this.getDriver();
	}
	
	public void setDriver(WebDriver driver){
		this.driver=driver;
	}
	
    private void setUpDriver(){
        String browser = this.config.getBrowser();
        if (browser == null) {
            browser = "chrome";
        }
        switch (browser) {
            case "chrome":
            	System.setProperty("webdriver.chrome.driver","./src/test/lib/chromedriver.exe");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("start-maximized");
            	   //session = ((ChromeDriver)driver).getSessionId();
                driver = new ChromeDriver(chromeOptions);
                break;
            case "firefox":
            	System.setProperty("webdriver.gecko.driver","./src/test/lib/geckodriver.exe");
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                break;
            default:
                throw new IllegalArgumentException("Browser \"" + browser + "\" isn't supported.");
        }
    }
    
    /**
     * Navigates to the root Url of the application
     */
    public void launchApplication() {
    	setUpDriver();
        this.driver.get(this.config.getAppUri());
    }
    
    public void closeDriver(){
        driver.close();
    }
}