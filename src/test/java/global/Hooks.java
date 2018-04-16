package global;

import cucumber.api.Scenario;
import cucumber.api.java.Before;

public class Hooks {

    @Before("@randomTag")
    public void beforeScenario(Scenario scenario) {
        System.out.println("I am before a random tag!");
    }
}
