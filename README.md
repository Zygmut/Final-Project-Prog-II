# 21707 - PROGRAMACIÓN II

### CURSO 2018 - 2019

## ENUNCIADO DE LA PRÁCTICA

## Simulación de movimiento

Diseñar una aplicación que permita visualizar el movimiento de círculos. En la ventana de la aplicación hay
diferenciadas dos partes: por un lado un panel donde se ven los círculos en movimiento y la otra donde está la
interfaz gráfica con un campo de texto editable que permite insertar el número de círculos de la simulación y
dos cajas de verificación que permiten activar / desactivar la colisión de los círculos con los límites del
panel y el tipo de movimiento a visualizar que puede ser de seguimiento del ratón o de caída. Ver Fig. 1.
Ver vídeo https://youtu.be/BSyYRUXbWz


![figure 1](https://i.ibb.co/bgwTtgZ/figure-1.png)
Fig 1. Interfaz propuesta

## Objetivos e indicaciones

Los objetivos de esta práctica son trabajar con un entorno gráfico e interactivo con las prestaciones que
ofrecen las librerías gráficas de Java pero, sobre todo, aplicar los conceptos de objetos y de tipo
abstractos de datos.

Para alcanzar estos objetivos es necesario implementar un programa principal que contenga la definición y
comportamiento de la interfaz y la llamada a un método que pone en marcha la simulación o el movimiento de los
círculos. Además se han de definir las siguientes clases:

- Panel de círculos: Es un panel gráfico activo a los movimientos del ratón que contiene la definición de una
    colección de círculos y los datos provenientes de la interfaz gráfica. Entre otros contiene el método que pone en
    marcha la simulación y el paintComponent responsable de la visualización. El método que hace la
    simulación del movimiento es un bucle infinito donde para todos los círculos de la colección es calcula la
    su nueva posición y su interacción con límites del panel ( "paredes"), estas dos operaciones
    dependen de lo que haya configurado en la interfaz gráfica. Después de cada iteración hay programado un retraso
    para que la visualización sea adecuada. En Java se puede programar un retraso con la sentencia:
    Thread.sleep (10); donde el parámetro indica los milisegundos de espera.
- Círculo: Se caracteriza por su diámetro, la forma, el color, la posición, la velocidad y la aceleración.
    Este últimos tres atributos son vectores en el plano. Entre otros contiene los métodos que actualizan
    la posición (siguiendo el ratón o cayendo), los métodos que controlan la interacción con los límites
    (Rebotando en las paredes o atravesándolas) y lo que pinta. Para la actualización de la posición se debe hacer
    utilizando la notación vectorial que implica calcular la aceleración según el tipo de movimiento,
    actualizar la velocidad a partir de este valor y finalmente agregar este valor a la posición para
    encontrar la nueva. Ver Fig. 2.

![figure 2](https://i.ibb.co/dbmxtD8/figure-2.png)

Fig 2. Cálculo de la nueva posición


  En el caso de caída se tendrá una aceleración constante en el eje Y (para cuestiones de
  visualización puede ser interesante dar un valor pequeño a X en lugar de cero) y en el caso del seguimiento
  del ratón se calculará la aceleración a partir del vector definido entre la posición del círculo y la
  posición del ratón (resto de vectores). Para cuestión de visualización en la pantalla puede ser interesante
  normalizar el vector de dirección y multiplicarlo por un factor que haga la animación fluida.

- Vector en el plan: Caracterizado por dos coordenadas X e Y contiene las principales operaciones que se
    pueden hacer con vectores como: adición (suma de componentes), sustracción (resto de componentes),
    multiplicación por escalar (producto de componentes por un escalar), división por escalar (división de
    componentes por un escalar), magnitud o módulo (raíz cuadrada de la suma de componentes al
    cuadrado), norma o vector unitario (división escalar por la magnitud) y limitación (si la magnitud es
    mayor que un valor máximo, normalizar el vector y hacer la multiplicación escalar por el máximo).


https://ca.wikipedia.org/wiki/Vector_(matemàtiques)

https://ca.wikipedia.org/wiki/Vector_(f%C3%ADsica)

https://www.vitutor.net/1/1.html

## Presentación:

La práctica, que debe hacerse de manera individual o en grupos de dos personas como máximo, deberá
entregar en el Aula Digital un fichero comprimido (se recomienda la compresión con .zip o con .rar) que contendrá:

1. El proyecto Netbeans con los códigos bien comentados de las clases que solucionan el problema. En la
    primera línea de cada fichero del código estarán los nombres de los autores en un línea comentada.
2. Un archivo pdf con la memoria de la práctica que contiene:

    a) Portada con el título de la práctica, el nombre del autor o autores, el nombre de la asignatura y el
    profesor.
    b) Introducción que sintetice el enunciado de la práctica.
    c) Diseño. Donde se describa el diseño descendente que ha conducido a la solución propuesta.
    Explicando las clases y métodos.
    d) Conclusiones. Que sinteticen la experiencia obtenida, describan las lecciones aprendidas y
    resalten los puntos que han resultado difíciles de resolver.

3. Un enlace a un vídeo de máximo 10 minutos donde el estudiante explique el código resultado de la práctica y en
   muestre las funcionalidades. El vídeo puede estar tanto en una plataforma específica del estilo YouTube como
   un disco virtual del estilo Dropbox. El enlace saldrá a la segundo línea del código abajo del nombres de los autores y
   en la portada del documento pdf también bajo los nombres.
