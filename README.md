# Serenity POC

Este proyecto es una prueba de concepto (POC) para automatización de pruebas utilizando **Java**, **Gradle** y el framework **Serenity BDD** con integración de **Cucumber**. El objetivo es demostrar la automatización de pruebas de aceptación y API siguiendo el enfoque BDD (Behavior Driven Development).

## Estructura del proyecto

- **src/main/java**: Código fuente principal (actualmente contiene un ejemplo básico).
- **src/test/java**: Código de pruebas automatizadas, organizado en:
  - `stepdefinitions`: Definiciones de pasos de Cucumber.
  - `runners`: Clases para ejecutar los tests.
  - `interactions`, `tasks`, `questions`, `models`: Patrones Screenplay para organizar la lógica de pruebas.
- **src/test/resources/features**: Archivos `.feature` escritos en Gherkin para describir los escenarios de prueba.

## Tecnologías utilizadas

- Java 11+
- Gradle
- Serenity BDD 4.x
- Cucumber 7.x
- JUnit
- AssertJ, Hamcrest, Rest-Assured

## Ejecución de pruebas

Para ejecutar las pruebas automatizadas:

```bash
./gradlew clean test
```

Los reportes de Serenity se generarán en `target/site/serenity/index.html`.

## Ejemplo de escenario BDD

```gherkin
Feature: User Registration

  Scenario: Successful user registration
    Given Brenda is a client who wants to manage her banking products
    When she sends the required information for registration
    Then she should get a virtual account to log in whenever she needs
```

## Requisitos previos

- Java 11 o superior
- Gradle (wrapper incluido)
- (Opcional) IDE como IntelliJ IDEA o Eclipse 