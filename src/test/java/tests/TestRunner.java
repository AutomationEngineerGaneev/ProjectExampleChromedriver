package tests;

import io.qameta.allure.Epic;
import org.testng.TestNG;
import org.testng.annotations.Listeners;
import org.testng.collections.Lists;
import utils.listeners.TestListener;

import java.util.List;

@Listeners({TestListener.class})
@Epic("Regression Tests")
public class TestRunner {

    public static void main(String[] args) {
        TestNG testng = new TestNG();
        List<String> suites = Lists.newArrayList();
        suites.add("testng.xml");
        testng.setTestSuites(suites);
        testng.run();
    }
}
