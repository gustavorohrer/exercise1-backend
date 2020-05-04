# EJERCICIO 1 BACKEND

## Configuración de base de datos

Con Docker, ejecute el siguiente comando en el mismo directorio donde se encuentra el archivo .yml:
```bash
docker-compose up
```

## Compilar y correr localmente

Para compilar y ejecutar localmente, necesitamos usar gradle wrapper.
```bash
SPRING_PROFILES_ACTIVE=local ./gradlew bootrun
```

## Documentación para pruebas de servicios web utlizando IntelliJ Idea

Si está ejecutando la edición IntelliJ IDEA Ultimate, puede crear, editar y ejecutar solicitudes HTTP directamente en el
Editor de código IntelliJ IDEA. Todas las pruebas http están en la carpeta **request**, y las configuraciones de entornos en el archivo
**http-client.env.json**. Para obtener más ayuda sobre esto, visite https://www.jetbrains.com/help/idea/http-client-in-product-code-editor.html.

## Notas adicionales

### Cuestiones no cubiertas por cuestiones de tiempo

- La seguridad del backend no está cubierta.
- La lógica solicitada en el ejercicio no fue cubierta totalmente: en lugar de desarrollar la lógica para que distintos tipos de operadores sean asignados según la disponibilidad, un usuario que simula ser un operador es quien selecciona, desde el frontend, la sesión de chat que va a atender. 
