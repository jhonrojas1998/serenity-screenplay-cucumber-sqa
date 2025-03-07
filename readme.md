# Autor
Jhon Hader Rojas Cabrera

![ Mi Foto ](C:\Users\Universal_Tech\Downloads\mi-foto.jpg.jpeg)

# Automatización de Pruebas con Serenity BDD y Screenplay

## Descripción
Este proyecto implementa pruebas automatizadas utilizando **Serenity BDD** con el **patrón Screenplay** y **Cucumber BDD**. Se enfoca en la automatización de compras en un ecommerce, incluyendo la selección de productos, el diligenciamiento del formulario de entrega y la confirmación del pedido.

## Tecnologías Utilizadas
- **Java**
- **Serenity BDD**
- **Screenplay Pattern**
- **Cucumber BDD**
- **Gradle**
- **Selenium WebDriver**

## Estructura del Proyecto
```
serenity-screenplay-cucumber/
├── src
│   ├── main
│   │   ├── java
│   │   │   └── co.com.sqasa
│   │   │       ├── exceptions
│   │   │       ├── interactions
│   │   │       ├── models
│   │   │       ├── questions
│   │   │       ├── tasks
│   │   │       ├── userinterfaces
│   │   │       ├── utils
│   │   ├── resources
│   ├── test
│   │   ├── java
│   │   │   └── co.com.sqasa
│   │   │       ├── runners
│   │   │       ├── stepdefinitions
│   │   ├── resources
│   │       ├── features
│   │       ├── serenity.conf
├── target
├── .gitignore
├── build.gradle
├── gradlew
├── gradlew.bat
├── mi-foto.jpg
├── readme.md
├── settings.gradle
└── External Libraries

```

## Instalación y Ejecución
### Prerrequisitos
- Tener instalado **Java 11 o superior**
- Tener instalado **Gradle**
- Tener configurado **ChromeDriver** o el driver del navegador correspondiente

### Ejecución de Pruebas
Ejecutar todas las pruebas:
```sh
gradle clean test aggregate
```
Ejecutar un escenario específico:
```sh
gradle clean test --tests "co.com.sqasa.runners.AddToCartRunner"
```

## Reportes
Los reportes generados por Serenity se encuentran en:
```
target/site/serenity/index.html
```
Abrir en un navegador para visualizar los resultados.

## Contacto
Para dudas o mejoras en el proyecto, contáctame a través de [tu email o LinkedIn].

