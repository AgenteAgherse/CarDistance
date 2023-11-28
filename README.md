# Elementos a tener en cuenta
* El programa está hecho en Java 19. En caso de tener problemas con esta distribución, use Docker para crear una VM que tenga ese tipo de Java. En caso de no saber como usar esta herramienta, intente cambiar el tipo de versión en el archivo pom.xml y agregue la versión que usted tiene en su equipo.
* Antes de comenzar a ejecutar el trabajo, actualice su Maven. Si aparece una notificación para instalar Lombok, acepte.

# Diagrama de clase
![Diagrama de Clase](https://github.com/AgenteAgherse/CarDistance/src/resources/static/Diagrama_de_Clases.png)
# Descripción del Trabajo
El trabajo tiene actualmente dos clases de hilos. El primer hilo es el más tradicional y proviene de la clase Autos.

## Clase Autos
Esta clase cuenta con una característica. Es un hilo que no cuenta con un final. Esto es debido a que siempre está aceptando nuevos datos por lo que independiente de la cantidad de autos, este nunca se va a finalizar.

![Thread Principal](https://github.com/AgenteAgherse/CarDistance/src/resources/static/Thread.png)

## Timer
Este tipo de thread es normalmente usado cuando se hace la modificación de un estado de un elemento en nuestro JFrame.

![Thread Principal](https://github.com/AgenteAgherse/CarDistance/src/resources/static/Timer.png)


# Funcionamiento
El programa tiene un hilo que controla a un conjunto de autos y que constantemente está generando calculos en forma de cola. Es decir, los primeros carros que se evalúan son los autos que se han creado primero. Dentro de la clase de Auto, se tienen en cuenta los calculos para sacar las nuevas distancias y, como queremos que se refleje a tiempo real, en vez de sacar todas las distancias de golpe, se saca precisamente a partir de la cola que se genera en el hilo. Esto brinda un seguimiento a tiempo real del auto.
Una vez se realizan los calculos, se usa la librería JFreeChart para reflejar los datos del tiempo y distancia recorridos dentro de un gráfico donde podemos agregar nuestras series.
Esto genera cada segundo 1 foto por la distancia recorrida (distances.png)

![Distancia Recorrida](https://github.com/AgenteAgherse/CarDistance/distances.png)

Y otra que es definida por la posición actual del auto (position.png)

![Posición del vehículo](https://github.com/AgenteAgherse/CarDistance/position.png)

Al final, estas imagenes generadas son agregadas dentro de nuestro JFrame para reflejar la actualización segundo a segundo.
