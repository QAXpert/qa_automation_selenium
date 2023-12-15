package app.booking.home;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;

public class HomeView {

    /**
     * Page Object Model (POM) para aplicación de Calculadora
     */

     By
    protected AndroidDriver driver;

    // Creamos el método que recibirá el driver en esta clase
    public HomeView(AndroidDriver driver){
        this.driver = driver;
    }

    // Creamos el método que creara el localizador by para los numeros de la calculadora
    public By locateDigit(int digito){
        String locator = "com.google.android.calculator:id/digit_"+ digito;
        By digit = By.id(locator);
        return digit;

    }

    // Creamos el método que realizara click en los digitos de la calculadora
    public void clickDigit(int digit) throws InterruptedException {

        String number = String.valueOf(digit);
        char[] digits = number.toCharArray();

        for(int i = 0; i < digits.length; i++) {

            driver.findElement(locateDigit(Character.getNumericValue(digits[i]))).click();
        }

    }

    // Creamos el método que realizara click en la suma
    public void clickSuma() throws InterruptedException {
        driver.findElement(By.id("com.google.android.calculator:id/op_add")).click();
    }


    // Creamos el método que obtiene el resultado
    public String getResult() throws InterruptedException {
        Thread.sleep(2000);
        String result = driver.findElement(By.id("com.google.android.calculator:id/result_preview")).getText();
        System.out.println("El resultado es = " + result);
        return result;
    }

    // Creamos el método que realizara click en la resta

    // Creamos el método que realizara click en la multiplicacion

    // Creamos el método que realizara click en la división

}