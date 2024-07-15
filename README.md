# Proyecto de Automatización de Pruebas con Serenity Screenplay

## 1. Prerequisitos:

- Maquina local con el sistema operativo Windows 10 o superior
- IDE IntelliJ IDEA
- Maven versión 3.8.6 (debe estar configurado en la variable de entorno `PATH`)
- JDK versión 1.8 (debe estar configurado en la variable de entorno `JAVA_HOME`)

  
## 2. Comandos de instalación:

Para preparar el entorno de desarrollo y ejecutar las pruebas, sigue estos pasos:

- Instala las dependencias del proyecto utilizando Maven:
mvn clean install -DskipTests


## 3. Instrucciones para ejecutar los tests:

Para ejecutar las pruebas automatizadas y generar reportes, sigue estos pasos:

- Abre el proyecto en IntelliJ IDEA.

- Configura el WebDriver en el archivo `serenity.properties` según el navegador que deseas utilizar.

- Ejecuta las pruebas utilizando Maven desde el archivo src\test\java\com\example\runners\CucumberTestSuite:
  
- Después de la ejecución, los reportes estarán disponibles en el directorio `target/site/serenity`.

## 4. Información adicional:

- Este proyecto utiliza Serenity Screenplay para estructurar las pruebas en un estilo basado en comportamientos.
- Asegúrate de tener acceso a la aplicación web de prueba y que esté disponible durante la ejecución de las pruebas.
- Los reportes generados por Serenity Screenplay proporcionan detalles sobre el estado de las pruebas, incluyendo capturas de pantalla y métricas.
