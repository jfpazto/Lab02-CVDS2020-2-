# Laboratorio 2 - Patterns - 2020-2

## La herramienta Maven

### ¿Cuál es su mayor utilidad?

Maven es un programa para el manejo de proyectos de programación cuyo manejo se basa en xml. Facilita el empaquetamiento y manejo de librerías en un proyecto, no habría que buscar y descargar una por una si no compilar y ejecutar el proyecto para que así nos descargue lo que se esta usando en dicho trabajo.
### Fases de Maven

- Validar

- Compilar

- Pruebas unitarias (test)

- Empaquetar (package)

- Verificar

- Instalar

- Desplegar

### Ciclo de vida de la construcción

Los ciclos de vida de Maven son tres:

- Ciclo de vida default: Gestiona la construcción y despliegue de un proyecto

- Ciclo de vida clean: Eliminia archivos generados en el momento de construcción y despliegue del proyecto

- Ciclo de vida site: Gestiona la documentación del proyecto

### ¿Para qué sirven los plugins?

Los plugins de Maven son como accesorios o programas que Maven no tiene y un desarrollador ha decidido crear para complementar esta falta de funcionalidad en Maven. Nos ayudan en dado caso para situaciones más especificas para no tener que programarlos de nuevo.

### ¿Qué es y para qué sirve el repositorio central de maven? 
En esta página podemos encontrar plugins, librerías y dependencias que han sido desarrolladas directamente por Maven o algún desarrollador que desee compartir su trabajo con los demás.

### Para crear un proyectolo hacemos de la siguiente manera:

``` mvn archetype:generate -DgroupId=edu.eci.cvds -DartifactId=Patterns - DarchetypeArtifactId=maven-archetype-quickstart ```


## Ajustar algunas configuraciones en el proyecto

Aqui va una imagen 

## Compilar y Ejecutar

El Objetivo de Package es empaquetar todo el proyecto en un archivo JAR


```mvn
$ mvn package
```
Tambien se pueden ejecutar:

- validate

- compile

- test

- package

- integration-test

- verify

- install

- deploy

- clean 

- site

Para crear una ejecucion desde la linea de comandos usamos el siguiente codigo:

```mvn
$ mvn exec:java -Dexec.mainClass="edu.eci.cvds.patterns.App" -Dexec.args="Hola Mundo"
```

Realizamos el siguiente cambio en la clase **App.java**, para que dados los parametros en la ejecucion nos imprima un saludo personalizado.

 ```java
package edu.eci.cvds.patterns;

/**
 * Hello world!
 *
 */
public class App 
{
	 
    public static void main( String[] args )
    {
    	String cadena=new String();
    	for (int i=0;i<args.length;i++)
    	{
    		cadena=cadena+" "+args[i];
    	}
    	
        System.out.println("Hello"+ cadena+"!" );
    }
}

```
## Hacer el esqueleto de la aplicacion.

Creamos los siguientes paquetes:

- **edu.eci.cvds.patterns.shapes**
- **edu.eci.cvds.patterns.shapes.concrete**

Creamos la Interfaz: **Shape.java** en el directorio 
**src/main/java/edu/eci/cvds/patterns/shapes** escribimos:

 ```java
package edu.eci.cvds.patterns.shapes;

public interface Shape
{
    public int getNumberOfEdges();
}

```
Creamos la Ennumeracion **RegularShapeType.java** en el directorio: **src/main/java/edu/eci/cvds/patterns/shapes**
 
```java
package edu.eci.cvds.patterns.shapes;

public enum RegularShapeType
{
    Triangle, Quadrilateral, Pentagon, Hexagon
}

```
En el directorio **src/main/java/edu/eci/cvds/patterns/shapes/concrete** creamos las clases:

**Hexagono**
```java
package edu.eci.cvds.patterns.shapes.concrete;

import edu.eci.cvds.patterns.shapes.Shape;

public class Hexagon implements Shape
{
    public int getNumberOfEdges()
	{
	    return 6;
    }
}

```
**Pentagono**
```java
package edu.eci.cvds.patterns.shapes.concrete;

import edu.eci.cvds.patterns.shapes.Shape;

public class Pentagon implements Shape
{
    public int getNumberOfEdges()
	{
	    return 5;
    }
}

```
**Cuadrilatero**
```java
package edu.eci.cvds.patterns.shapes.concrete;

import edu.eci.cvds.patterns.shapes.Shape;

public class Quadrilateral implements Shape
{
    public int getNumberOfEdges()
	{
	    return 4;
    }
}

```
**Triangulo**
```java
package edu.eci.cvds.patterns.shapes.concrete;

import edu.eci.cvds.patterns.shapes.Shape;

public class Triangle implements Shape 
{
    public int getNumberOfEdges()
	{
	    return 3;
    }
}

```

Creamos el archivo **ShapeMain.java** en el directorio **src/main/java/edu/eci/cvds/patterns/shapes**

```java
package edu.eci.cvds.patterns.shapes;

public class ShapeMain
{
	public static void main(String[] args)
	{
		if(args == null || args.length != 1)
		{
			System.err.println("Parameter of type RegularShapeType is required.");
			return;
		}
		try
		{
			RegularShapeType type =RegularShapeType.valueOf(args[0]);
			Shape shape = ShapeFactory.create(type);
			System.out.println(String.format("Successfully created a %s with %s sides.", type, shape.getNumberOfEdges()));
		} catch (IllegalArgumentException ex)
		{
			System.err.println("Parameter " + args[0] + " is not a valid RegularShapeType");
			return;
		}
	}
}

```
Creamos el archivo **ShapeFactory.java** en el directorio **src/main/java/edu/eci/cvds/patterns/shapes**

```java
package edu.eci.cvds.patterns.shapes;
import edu.eci.cvds.patterns.shapes.concrete.*;

public abstract class ShapeFactory
{
	public static Shape create(RegularShapeType type)
	{
		switch(type)
		{
			case Triangle:
				return new Triangle();
			case Quadrilateral:
				return new Quadrilateral();
			case Pentagon:
				return new Pentagon();
			case Hexagon:
				return new Hexagon();
			default:
				break;
		}
		return null;
	}
}

```
Al ejecutar las pruebas solo los arroja un resultado positivo con el la entrada "Hexagono", con los otros nos muestra el mensaje de adevertencia.


```mvn
mvn exec:java -Dexec.mainClass="edu.eci.cvds.patterns.shapes.ShapeMain" -Dexec.args="Hexagon"


```

## Participantes
Para la elaboración de este laboratorio los integrantes son:
Jonathan Paez
Carlos Amorocho

## Bibliografia
[1:](https://1984.lsi.us.es/wiki-egc/index.php/Primeros_pasos_con_Maven#Ciclo_de_vida_y_faseshttps://1984.lsi.us.es/wiki-egc/index.php/Primeros_pasos_con_Maven#Ciclo_de_vida_y_fases)

[2:]
(https://snmb-desarrollo.readthedocs.io/en/develop/howtos/maven-deploy.html
)

[3:]
(https://www.youtube.com/watch?v=s7boC0U4iew&list=PLvimn1Ins-40atMWQkxD8r8pRyPLAU0iQ&index=7
)

[4:]
(https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html
)


