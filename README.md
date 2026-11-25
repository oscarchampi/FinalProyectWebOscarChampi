# AutoWeb - Automatización de Pruebas Web
# Autor: OSCAR CHAMPI CORRALES


## Descripción del proyecto

AutoWeb es un proyecto de automatización de pruebas funcionales web desarrollado con Java y Serenity BDD, utilizando Selenium WebDriver y Cucumber.

El proyecto tiene como objetivo automatizar y validar funcionalidades de la plataforma (https://www.demoblaze.com/), verificando el correcto funcionamiento de sus principales procesos mediante escenarios de prueba.

## Tecnologías utilizadas

- **Java 17:** Lenguaje de programación.
- **Maven:** Gestión de dependencias y construcción del proyecto.
- **Selenium WebDriver:** Automatización de navegadores web.
- **Serenity BDD:** Gestión y generación de reportes de pruebas.
- **Cucumber:** Definición de escenarios de prueba utilizando Gherkin.
- **JUnit 4:** Ejecución de pruebas automatizadas.
- **Screenplay Pattern:** Patrón de diseño para organizar las interacciones y acciones de los actores.

## Aplicación bajo prueba

- Plataforma: DemoBlaze
- URL: https://www.demoblaze.com/

## Funcionalidades automatizadas

El proyecto contempla la validación de funcionalidades del sitio web, como:

- Registro de usuarios.
- Navegación por categorías y productos.
- Selección de productos.
- Gestión del carrito de compras.
- Validación del proceso de compra.

## Estructura del proyecto

```text
AutoWeb/
│
├── src/
│   ├── main/
│   │   └── java/
│   │       └── org/example/
│   │
│   └── test/
│       ├── java/
│       │   └── org/example/
│       │       ├── Pages/
│       │       └── StepDefinition/
│       │
│       └── resources/
│           └── features/
│
├── pom.xml
├── .gitignore
└── README.md
```

## Requisitos previos

Para ejecutar el proyecto se necesita:

- Java JDK 17.
- Apache Maven.
- IntelliJ IDEA.
- Google Chrome.
- Conexión a Internet.

## Instalación y ejecución

1. Clonar el repositorio:

```bash
git clone https://github.com/oscarchampi/FinalProyectWebOscarChampi.git
```

2. Ingresar a la carpeta del proyecto:

```bash
cd AutoWeb
```

3. Ejecutar las pruebas automatizadas:

```bash
mvn clean verify
```

## Reportes de pruebas

El proyecto utiliza Serenity BDD para generar reportes detallados de la ejecución de las pruebas automatizadas.

Para generar el reporte manualmente:

```bash
mvn serenity:aggregate
```

GitHub: [@oscarchampi](https://github.com/oscarchampi)
