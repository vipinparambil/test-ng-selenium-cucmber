package com.test.project.steps;

import static org.junit.Assert.assertNotNull;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.test.project.BaseConfig;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestSteps {
	private final BaseConfig baseConfig;

	private static By search = By
			.xpath("/html/body/div[1]/div[3]/form/div[2]/div[1]/div[1]/div/div[2]/input[@name='q']");
	private static By searchButton = By
			.xpath("/html/body/div[1]/div[3]/form/div[2]/div[1]/div[3]/center/input[1][@name='btnK']");
	private By searchCount  = By.id("result-stats");
	

	public TestSteps() {
		this.baseConfig = new BaseConfig();
	}

	@Given("Open Google")
	public void open_Google() {
		baseConfig.launchApplication();
	}

	@When("search the text {string}")
	public void search_the_text(String serachString) {
		WebElement element = this.baseConfig.driver.findElement(search);
		if (element != null) {
			element.sendKeys(serachString);
			WebElement btn = this.baseConfig.driver.findElement(searchButton);
			btn.click();
		}
	}

	@Then("result is displayed")
	public void result_is_displayed() {
		WebElement element = this.baseConfig.driver.findElement(searchCount);
		System.out.println(element.getText());
		assertNotNull("No reult found : ", element.getText());
	}
	
	@Then("the site is closed")
	public void the_site_is_closed() {
	    this.baseConfig.closeDriver();
	}

}
