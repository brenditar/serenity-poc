# Serenity POC

Este proyecto es una prueba de concepto (POC) para automatización de pruebas utilizando **Java**, **Gradle** y el framework **Serenity BDD** con integración de **Cucumber**. El objetivo es demostrar la automatización de pruebas de aceptación y API siguiendo el enfoque BDD (Behavior Driven Development).

## Estructura del proyecto

- **src/main/java**: Código fuente principal (modelos, servicios, factories, etc.).
- **src/test/java**: Código de pruebas automatizadas, organizado en:
  - `com.example.api.steps`: Step definitions para pruebas de API (Screenplay, integración real).
  - `com.example.business.steps`: Step definitions para lógica de negocio simulada (patrones, lógica interna).
  - `com.example.api.tasks`, `com.example.api.questions`: Tareas y preguntas Screenplay para pruebas de API.
  - `com.example.api.runners`, `com.example.business.runners`: Clases para ejecutar los tests (cada runner apunta al glue correspondiente).
- **src/test/resources/features/api**: Features de pruebas de API.
- **src/test/resources/features/business**: Features de lógica de negocio simulada.

## Uso de las carpetas `model` y `business/service`

- **model**: Contiene las entidades de dominio (por ejemplo, `User`, `UserFactory`). Es **compartida** entre los tests de API y de lógica interna, ya que ambos contextos pueden necesitar construir o validar datos de usuario.
- **business/service**: Contiene la lógica de negocio simulada (por ejemplo, `UserService`, estrategias de validación). Se utiliza principalmente en el dominio de lógica interna (business), para simular reglas de negocio y aplicar patrones de diseño. No suele usarse directamente en las pruebas de integración de API.

## Tecnologías utilizadas

- Java 11+
- Gradle
- Serenity BDD 4.x
- Cucumber 7.x
- JUnit
- AssertJ, Hamcrest, Rest-Assured

## Ejecución de pruebas

Para facilitar la ejecución de tareas comunes, este proyecto incluye un `Makefile` con los siguientes comandos:

| Comando                       | Descripción                                              |
| ----------------------------- | -------------------------------------------------------- |
| make install                  | Instala dependencias y compila el proyecto               |
| make test                     | Ejecuta todos los tests                                  |
| make test-api                 | Ejecuta todas las pruebas de API (login y register)      |
| make clean                    | Limpia archivos generados y reportes                     |
| make compile                  | Solo compila el código fuente                            |
| make test-feature FEATURE=... | Ejecuta un feature específico (ejemplo: api/register_users_api)  |
| make report                   | Abre el reporte HTML de Serenity                         |
| make help                     | Muestra ayuda y ejemplos de uso                          |

### Ejemplos de uso

```bash
# Instalar dependencias y compilar
make install

# Ejecutar todos los tests
make test

# Ejecutar solo las pruebas de API (login y register)
make test-api

# Ejecutar un feature específico
make test-feature FEATURE=api/register_users_api

# Abrir el reporte de Serenity
make report
```

## Organización de step definitions y runners

- **API:**
  - Step definitions: `com.example.api.steps`
  - Runner: `com.example.api.runners.ApiTestRunner`
  - Features: `src/test/resources/features/api/`
- **Lógica de negocio simulada:**
  - Step definitions: `com.example.business.steps`
  - Runner: `com.example.business.runners.RegisterUserTestRunner`
  - Features: `src/test/resources/features/business/`

## Ejemplo de escenario BDD

```gherkin
Feature: User Registration via API

  Scenario: Successful user registration via API
    Given the API for registration is available
    When I register a user with email "eve.holt@reqres.in" and password "pistol" via API
    Then the registration response code should be 200
```

## Requisitos previos

- Java 11 o superior
- Gradle (wrapper incluido)
- (Opcional) IDE como IntelliJ IDEA o Eclipse
- (Opcional) GNU Make
