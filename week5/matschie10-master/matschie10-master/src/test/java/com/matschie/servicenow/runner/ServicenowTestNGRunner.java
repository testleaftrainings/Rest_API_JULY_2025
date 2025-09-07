package com.matschie.servicenow.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		          features = {"src/test/java/com/matschie/servicenow/features/incident.feature"},
		          glue = {"com.matschie.servicenow.step.defs"},
		          dryRun = false,
		          plugin = {
		        		  "pretty",
		        		  "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"
		          }
		        )
public class ServicenowTestNGRunner extends AbstractTestNGCucumberTests {	

}