## Automatización con Selenium, Java y Maven

Este repositorio está diseñado para facilitar la automatización de pruebas utilizando Selenium WebDriver con Java y Maven, integrando también TestNG para una ejecución y manejo efectivos de pruebas de interfaz de usuario.

### Introducción

Este proyecto tiene como objetivo proporcionar un entorno estructurado y listo para usar, donde puedas practicar y desarrollar habilidades en automatización de pruebas. Utiliza las potentes capacidades de Selenium para interactuar con aplicaciones web, aprovechando la flexibilidad de Java y la gestión de dependencias de Maven.

### Instrucciones

#### Requisitos previos:
- **Java JDK 19.02**: Instala Java Development Kit (JDK) versión 19.02. Confirma la instalación ejecutando `java --version` en tu terminal.

#### Pasos a seguir:
1. **Instalar Java JDK 19.02**:
   - Dirígete al [sitio de descarga de Oracle](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html) o a tu gestor de paquetes preferido para descargar e instalar JDK 19.02.
   - Verifica la instalación ejecutando `java --version` en tu terminal o línea de comandos.


2. **Crear un proyecto usando IntelliJ IDEA**:
   - Abre IntelliJ IDEA y selecciona `File -> New -> Project`.
   - Elige `Maven` como el tipo de proyecto
   - `Opciones avannzadas` Ingresa el `GroupId` y el `ArtifactId` de tu proyecto.
   - Haz clic en `Create`  para crear el proyecto.

     3. **Configurar el proyecto con Maven**:
        - Abre el archivo `pom.xml` dentro de tu proyecto.
        - Asegúrate de que la estructura del archivo `pom.xml` sea similar a la siguiente:

        ```xml
        <project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
            xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
            <modelVersion>4.0.0</modelVersion>
           <groupId>com.qaxpert</groupId>
           <artifactId>selenium</artifactId>
            <version>0.0.1-SNAPSHOT</version>

            <dependencies>
                <!-- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java -->
                <dependency>
                    <groupId>org.seleniumhq.selenium</groupId>
                    <artifactId>selenium-java</artifactId>
                    <version>4.1.2</version>
                    <scope>test</scope>
                </dependency>

                <!-- https://mvnrepository.com/artifact/org.testng/testng -->
                <dependency>
                    <groupId>org.testng</groupId>
                    <artifactId>testng</artifactId>
                    <version>7.4.0</version>
                    <scope>test</scope>
                </dependency>
        
                <dependency>
                  <groupId>io.github.bonigarcia</groupId>
                  <artifactId>webdrivermanager</artifactId>
                   <version>5.6.2</version>
                    <scope>test</scope>
                 </dependency>
                 </dependencies>
             <properties>
                  <maven.compiler.source>17</maven.compiler.source>
                  <maven.compiler.target>17</maven.compiler.target>
                  <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
              </properties>
             </project>
           - Instalar dependencias


## Estructura del Proyecto

En el directorio `selenium_basic`, se encuentran varios ejemplos de configuración de drivers para Chrome y Firefox:

- `/selenium_basic/src/test/java/helloWorld_DriverChrome.java`
- `/selenium_basic/src/test/java/helloWorld_DriverFirefox.java`

Estos archivos, `helloWorld_DriverChrome` y `helloWorld_DriverFirefox`, están configurados para utilizar un driver específico para cada navegador. Se recomienda mantener actualizados estos drivers según la máquina en la que se ejecuten.

Además, dentro del mismo directorio, se encuentran:

- `/selenium_basic/src/test/java/helloWorldChrome.java`
- `/selenium_basic/src/test/java/helloWorldFirefox.java`

Estos archivos utilizan la librería `WebDriverManager` de Boni Garcia, lo que proporciona la ventaja de utilizar cualquier driver de navegador sin preocuparse por la versión instalada actualmente. Esto simplifica la gestión de los drivers y evita la necesidad de actualizar manualmente las versiones.

La elección entre usar un driver específico o `WebDriverManager` depende de las necesidades del proyecto y las preferencias de mantenimiento de los drivers de navegador.

Para más detalles sobre configuración, ejecución de pruebas y desarrollo en este entorno, consulta la documentación detallada en [qaxpert.com](https://qaxpert.com).
