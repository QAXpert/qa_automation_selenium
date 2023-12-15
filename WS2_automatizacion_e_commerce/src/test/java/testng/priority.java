package testng;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class priority {

    @Test(priority = 2)
    public static void segundaPrueba()
    {
        System.out.println("Este es el SEGUNDO caso de prueba porque la prioridad = 2");
    }

    @Test(priority = 1)
    public static void primeraPrueba()
    {
        System.out.println("Este es el PRIMER caso de prueba porque la prioridad = 1");
    }

    @Test(priority = 3)
    public static void ultimaPrueba()
    {
        System.out.println("Este es el último caso de prueba porque no tiene prioridad");
    }

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
}
