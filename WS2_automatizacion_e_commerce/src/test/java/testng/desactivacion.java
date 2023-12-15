package testng;

import org.testng.annotations.Test;

public class desactivacion {

    @Test(priority = 2,enabled = false)
    public static void PrimeraPrueba()
    {
        System.out.println("Este es el SEGUNDO caso de prueba porque la prioridad = 2");
    }

    @Test(priority = 1)
    public static void SegundaPrueba()
    {
        System.out.println("Este es el PRIMER caso de prueba porque la prioridad = 1 pero esta deshabilitado asi que no se ejecuta");
    }
}
