package testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class dependencia_metodos_testng {

    @Test
    public void iniciarSesion() {
        // Lógica para iniciar sesión
        System.out.println("Iniciar Sesión");
        //Assert.assertTrue(false, "Fallo al iniciar sesión"); // Simulando un fallo
        Assert.assertTrue(true, "Iniciar Sesión"); // True
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
