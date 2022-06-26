# VinchucaTPFinalObj2

Integrantes del trabajo final: 

Nicolas Carrizo - carrizonicolas97@gmail.com
<br>
Luis Salas - sc.luis93@gmail.com

### Pautas corregidas 📌

* La busqueda de muestra se delego en distintos filtros que se llaman de la siguiente forma: FiltroFechaCreacion, FiltroFechaUltimaVotacion, FiltroNivelDeVerificacion
  y FiltroTipoInsecto. Mientras haciamos el cambio, observamos que nos encontramos con un patron de diseño que es el Template Method. Donde la clase BusquedaDeMuestra se   convirtio en nuestra clase abstracta en donde contiene un Metodo Plantilla que es el metodo filtrarMuestras. Las clases que extienden de BusquedaDeMuestra implementan   el metodo esMuestraFiltrable.
 
* Se agrego la clase Sistema que representa el sistema de nuestra aplicacion, la cual puede agregar usuarios al sistema, agregar zonas, muestras y tambien podemos saber
  las opiniones de una muestra, el estado de una muestra o si un usuario es especialista. 
 
* Sacamos del PDF el strategy que no va. 

* Se modifico UML con los nuevos cambios. El JPG se llama "VinchucaUMLTPFinal-Modificaciones" y se agregan test para la parte de Filtros

* los JAR de mockito utilizados fueron los siguientes:
 
   - byte-buddy-1.10.18.jar
   - byte-buddy-agent-1.10.15.jar
   - mockito-core-3.6.0.jar
   - mockito-inline-3.6.0.jar
   - objenesis-3.1.jar

<br>
