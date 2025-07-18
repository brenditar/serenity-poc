# Makefile para Serenity BDD + Gradle + Cucumber

.PHONY: install test clean report compile test-feature help

# Instala dependencias y compila el proyecto
install:
	./gradlew clean build

# Ejecuta todos los tests (modo headless por defecto)
test:
	./gradlew clean test

# Limpia los archivos generados por Gradle y reportes
clean:
	./gradlew clean
	rm -rf target/site/serenity/*

# Solo compila sin ejecutar tests
compile:
	./gradlew compileJava

# Ejecuta un solo feature (ejemplo: make test-feature FEATURE=register_users)
test-feature:
	./gradlew clean test --tests * --info -Dcucumber.options="src/test/resources/features/$(FEATURE).feature"

# Abre el reporte HTML de Serenity
report:
	xdg-open target/site/serenity/index.html || open target/site/serenity/index.html || echo "Abre el archivo target/site/serenity/index.html manualmente"

# Ayuda por defecto
help:
	@echo "Comandos disponibles: install, test, clean, compile, test-feature, report"
	@echo "Ejemplo para ejecutar un feature: make test-feature FEATURE=register_users" 