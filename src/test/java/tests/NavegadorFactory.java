package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class NavegadorFactory {

    private static WebDriver navegador;

    public static synchronized WebDriver build() {
        System.setProperty("webdriver.chrome.driver", "/home/cicerooliverio/Downloads/chromedriver_linux64/chromedriver");
        if (navegador == null) {
            navegador = new ChromeDriver();
            navegador.manage().window().maximize();
            navegador.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        }
        return navegador;
    }
}
