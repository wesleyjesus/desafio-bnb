package com.bases.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Classe base para criação de novas PagesObjects
 */
public abstract class BasePO {
    
    protected WebDriver driver;

    protected BasePO(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
