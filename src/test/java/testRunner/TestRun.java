package testRunner;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
        (
        	features=".//Features//Login.feature",
        	//glue={"stepDefination","utilities"},
        	glue="stepDefination",
        	dryRun=false,
        	monochrome = true,
        	plugin= {"pretty",
        			    "html:test-output"
        	        }
		)



public class TestRun 
{
	

}
