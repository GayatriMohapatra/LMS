package com.mohs10.ActionDriver;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.mohs10.base.StartBrowser;

public class dataEncrypt_Decrypt2 extends StartBrowser {
    @Test
    public static void encryptAndDecryptData(By locator, String password) {
        // Encode the password using URL-safe Base64 encoding
        byte[] encodedBytes = Base64.getUrlEncoder().encode(password.getBytes(StandardCharsets.UTF_8));
        String encryptedPassword = new String(encodedBytes, StandardCharsets.UTF_8);

        System.out.println("Encrypted Password: " + encryptedPassword);

        // Decode the encrypted password using URL-safe Base64 decoding
        byte[] decodedBytes = Base64.getUrlDecoder().decode(encryptedPassword);
        String decryptedPassword = new String(decodedBytes, StandardCharsets.UTF_8);

        //System.out.println("Decrypted Password: " + decryptedPassword);

        // Perform a sendKeys action on the specified WebElement with the decrypted password
        WebElement element = driver.findElement(locator);
        element.sendKeys(decryptedPassword);
       // element.sendKeys(encryptedPassword);
    }
}
