package testng;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class dependencia_metodos_testng {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Antes de todo.");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("Antes de cada prueba");
    }

    @AfterSuite
    public void aftersuite(){
        System.out.println("despues de las pruebas");
    }
    @Test
    public void iniciarSesion() {
        // Lógica para iniciar sesión
        System.out.println("Iniciar Sesión");
        Assert.assertTrue(false, "Fallo al iniciar sesión"); // Simulando un fallo
        //Assert.assertTrue(true, "Iniciar Sesión"); // True
    }

    @Test(dependsOnMethods = { "iniciarSesion" })
    public void agregarProductoAlCarrito() {
        // Lógica para agregar un producto al carrito
        System.out.println("Agregar Producto al Carrito");
    }

    @Test(dependsOnMethods = { "agregarProductoAlCarrito" })
    public void realizarPago() {
        // Lógica para realizar el pago
        System.out.println("Realizar Pago");
    }
}
