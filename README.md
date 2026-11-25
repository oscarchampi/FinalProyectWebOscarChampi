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


# Se adjunta capturas de las evidencias de los escenarios propuestos y ejecutados 


<img width="1886" height="277" alt="image" src="https://github.com/user-attachments/assets/14383dee-e6e3-4bca-bdf8-4431649eceaa" />

<img width="1872" height="245" alt="image" src="https://github.com/user-attachments/assets/45e19cb1-3aa9-41ce-87c8-ead90f869724" />

<img width="1862" height="200" alt="image" src="https://github.com/user-attachments/assets/6cb9ebb3-c1be-4540-acbb-9487857e4544" />

<img width="1852" height="857" alt="image" src="https://github.com/user-attachments/assets/2449017e-0c62-4132-ba4f-ead4c3343497" />

<img width="1875" height="792" alt="image" src="https://github.com/user-attachments/assets/f0f2316a-5381-4aa3-bc71-604690f7ccc5" />





