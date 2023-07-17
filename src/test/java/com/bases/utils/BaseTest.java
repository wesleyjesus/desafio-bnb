package com.bases.utils;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Classe base para gerenciamento do driver.
 * Todos os testes devem ser herdados desta página.
 */
public abstract class BaseTest {
    
    protected static WebDriver driver;

    @BeforeEach
    public void setUp() throws Exception {

        System.out.println("Testes automatizados iniciados!");

		try {

			ChromeOptions options = new ChromeOptions();

			options.addArguments("start-maximized");
			options.addArguments("--disable-popup-blocking");
			options.addArguments("--disable-notifications");
            options.addArguments("--disable-extensions");
            options.addArguments("headless");
            
            try {
                driver = WebDriverManager.chromedriver().capabilities(options).create();
            } catch (IllegalStateException e) {
                e.printStackTrace();
                throw e;
            }

            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.manage().window().maximize();

        } catch (Exception e) {

            e.printStackTrace();
            throw e;

        }

    }

    @AfterEach
    public void tearDown() throws Exception {
        System.out.println("Testes finalizados com sucesso!");
        driver.manage().deleteAllCookies();
        driver.quit();
    }

}
