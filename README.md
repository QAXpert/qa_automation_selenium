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
       <groupId>com.bedu.web_automation_course</groupId>
       <artifactId>BeduWebAutomationCourse</artifactId>
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
       </dependencies>
   </project>

Para más detalles sobre configuración, ejecución de pruebas y desarrollo en este entorno, consulta la documentación detallada en [qaxpert.com](https://qaxpert.com).
