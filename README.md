# Restful API para [Tienda Virtual](https://github.com/lcasan/virtual-market) 

## Descripción
Proyecto backend desarrollado en **Spring Boot** que sigue el patrón de diseño **Restful API**.

**Product/**: Carpeta con los archivos principales relacionados con la entidad Product en la API.
- **Product.java**: Define los campos y la estructura del objeto Product.
- **ProductController.java**: Controlador REST que maneja las solicitudes HTTP relacionadas con Product.
- **ProductService.java**: Procesa los datos entrantes desde el controlador y se encarga de interactuar con la base de datos utilizando consultas SQL puras u otros métodos de persistencia.
- **CustomResponse.java**: Clase personalizada para estructurar el formato de las respuestas de la API. 
- **DataInicializer.java**: Esta clase se encarga de inicializar la base de datos con datos predeterminados cuando la aplicación arranca.
- **ExceptionController.java**: Manejador global de excepciones para la API.

## Configuración de entorno 

### Paso 1: Clonar el Proyecto
``` bash
git clone https://github.com/lcasan/restful-api.git
cd restful-api
```

### Paso 2: Descargar dependencias del proyecto
``` bash
./mvnw clean install
```
### Paso 3: Configuración de la Base de Datos
Configurar las credenciales de conexión en el archivo src/main/resources/application.properties.

### Paso 4: Ejecutar la Aplicación
``` bash
./mvnw spring-boot:run
```
