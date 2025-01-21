package stepDefinitions;

import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;

import org.testng.annotations.DataProvider;
import java.util.concurrent.CountDownLatch;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


		@CucumberOptions(
				  features = "src/test/resources/features",
				  glue = {"stepDefinitions"},
				  plugin = {"pretty", "json:target/cucumber.json"},
				  tags = "@smoke"
				)
		public class TestRunner extends AbstractTestNGCucumberTests {

		    private static final int MAX_THREADS = 1;  // Control number of concurrent threads

		    @Override
		    @DataProvider(parallel = false)  // Set parallel to false
		    public Object[][] scenarios() {
		        return super.scenarios();
		    }

		    @Override
		    public void runScenario(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {
		        // Create a thread pool with a fixed number of threads
		        ExecutorService executorService = Executors.newFixedThreadPool(MAX_THREADS);
		        
		        executorService.submit(() -> {
		            // Run the scenario
		            super.runScenario(pickleWrapper, featureWrapper);
		        });

		        executorService.shutdown();
		    }
		}