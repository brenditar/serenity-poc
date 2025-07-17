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

## Uso del Makefile

Para facilitar la ejecución de tareas comunes, este proyecto incluye un `Makefile` con los siguientes comandos:

| Comando                        | Descripción                                                        |
|--------------------------------|--------------------------------------------------------------------|
| `make install`                 | Instala dependencias y compila el proyecto                         |
| `make test`                    | Ejecuta todos los tests                                            |
| `make clean`                   | Limpia archivos generados y reportes                               |
| `make compile`                 | Solo compila el código fuente                                      |
| `make test-feature FEATURE=...`| Ejecuta un feature específico (ejemplo: `register_users`)          |
| `make report`                  | Abre el reporte HTML de Serenity                                   |
| `make help`                    | Muestra ayuda y ejemplos de uso                                    |

### Ejemplos de uso

```bash
# Instalar dependencias y compilar
make install

# Ejecutar todos los tests
enmake test

# Ejecutar un feature específico
make test-feature FEATURE=register_users

# Abrir el reporte de Serenity
enmake report
```

## Ejemplo de escenario BDD

```gherkin
Feature: User Registration

  Scenario: Successful user registration
    Given Brenda is a client who wants to manage her banking products
    When she sends the required information for registration
    Then she should get a virtual account to log in whenever she needs
```
