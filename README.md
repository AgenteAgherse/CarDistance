# Elementos a tener en cuenta
    * El programa está hecho en Java 19. En caso de tener problemas con esta distribución, use Docker para crear una VM que tenga ese tipo de Java. En caso de no saber como usar esta herramienta, intente cambiar el tipo de versión en el archivo pom.xml y agregue la versión que usted tiene en su equipo.
    * Antes de comenzar a ejecutar el trabajo, actualice su Maven. Si aparece una notificación para instalar Lombok, acepte.
# Descripción del Trabajo
El trabajo tiene actualmente dos clases de hilos. El primer hilo es el más tradicional y proviene de la clase Autos.

## Clase Autos
    Esta clase cuenta con una característica. Es un hilo que no cuenta con un final. Esto es debido a que siempre está aceptando nuevos datos por lo que independiente de la cantidad de autos, este nunca se va a finalizar.



## Timer