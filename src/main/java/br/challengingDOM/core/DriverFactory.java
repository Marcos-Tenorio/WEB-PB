package br.challengingDOM.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {

    //private static WebDriver driver;

    private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<WebDriver>() {
        @Override
        protected synchronized WebDriver initialValue() {
            return initDriver();
        }
    };

    private DriverFactory() {
    }

    public static WebDriver getDriver() {
        return threadDriver.get();
    }

    public static WebDriver initDriver() {
        WebDriver driver = null;

        if(Properties.TIPO_EXECUCAO == Properties.TipoExecucao.LOCAL){
            switch (Properties.BROWSER){
                case CHROME:
                    System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
                    driver = new ChromeDriver();
                    break;
            }
        }

        return driver;
    }

    public static void killDriver() {
        WebDriver driver = getDriver();
        if (driver != null) {
            driver.close();
            driver.quit();
            driver = null;

        }
        if (threadDriver != null) {
            threadDriver.remove();
        }
    }

}
