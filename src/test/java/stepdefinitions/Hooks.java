package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void setup(){
        System.out.println("setup calisti");
    }

    @After
    public void teardown(){
        System.out.println("teardown calisti");
    }


}
