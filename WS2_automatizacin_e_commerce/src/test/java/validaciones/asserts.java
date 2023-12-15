package validaciones;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class asserts {
    @Test
    public void pruebaConHardAssert() {
        int actual = 5;
        int esperado = 5;

        // Hard Assert: Si esta afirmación falla, la prueba se detendrá inmediatamente
        Assert.assertEquals(actual, esperado, "Los valores no son iguales");

        // Este código no se ejecutará si la afirmación anterior falla
        System.out.println("La prueba continúa después de la afirmación dura");
    }
    @Test
    public void pruebaConSoftAssert() {
        SoftAssert softAssert = new SoftAssert();

        int actual = 0;
        int esperado = 10;

        // Soft Assert: Si esta afirmación falla, se registra el error pero la prueba continúa
        softAssert.assertEquals(actual, esperado, "Los valores no son iguales");

        // Esta afirmación también se agrega al registro de errores, pero no detendrá la prueba
        softAssert.assertTrue(actual > 0, "El valor actual no es positivo");

        // Todas las afirmaciones suaves se verifican al final con el método assertAll()


        // Este código se ejecutará incluso si hay afirmaciones fallidas
        System.out.println("La prueba continúa después de las afirmaciones suaves");
        softAssert.assertAll();


    }


}
