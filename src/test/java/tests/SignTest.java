package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SignTest {
    @Test
    public void testFazerLoginNoTaskit(){

        System.setProperty("webdriver.chrome.driver","/home/cicerooliverio/Downloads/chromedriver_linux64/chromedriver");
        WebDriver navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        navegador.manage().window().maximize();

        navegador.get("http://www.juliodelima.com.br/taskit");
  
        navegador.findElement(By.linkText("Sign in")).click();

        navegador.findElement(By.id("signinbox")).findElement(By.name("login")).sendKeys("cicero01");
        navegador.findElement(By.id("signinbox")).findElement(By.name("password")).sendKeys("123456");

        navegador.findElement(By.linkText("SIGN IN")).click();

        String saudacao = navegador.findElement(By.className("me")).getText();

        Assert.assertEquals("Hi, Cicero",saudacao);

        navegador.quit();




    }
}
