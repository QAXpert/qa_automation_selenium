package testng;

import org.testng.annotations.Test;

public class depenedencias_basic {
    @Test
    public static void prueba()
    {
        System.out.println("Este es el primero que se ejecuta, no tiene dependencia");
    }

    @Test(dependsOnMethods = { "prueba" })
    public static void segunda_prueba()
    {
        System.out.println("Este se ejecuta de segundo, depende de la ejecución del metodo `prueba`");
    }

    @Test(dependsOnMethods = { "segunda_prueba" })
    public static void primera_prueba()
    {
        System.out.println("Este se ejecuta de segundo, depende de la ejecución del metodo `segunda_prueba`");
    }

}
