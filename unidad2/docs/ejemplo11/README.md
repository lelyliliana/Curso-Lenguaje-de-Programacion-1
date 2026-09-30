# U2_11 – RMI

## Objetivo

Invocar un método mediante una referencia remota RMI.

## Conceptos principales

ServicioSaludo extiende Remote y declara RemoteException; ServicioSaludoImpl extiende UnicastRemoteObject. Registry publica y localiza el servicio por nombre.

## Archivo principal

[U2_11_RMI.java](../../src/main/java/com/lelyliliana/unidad2/U2_11_RMI.java)

## ¿Qué hace el ejemplo?

Crea el registro local en 1099, publica ServicioSaludo, busca su referencia y llama saludar("Leli"); al terminar desexporta servicio y registro.

## Código clave

La interfaz remota extiende:

```java
Remote
```

Ejemplo:

```java
public interface ServicioSaludo
        extends Remote {
```

Los métodos remotos deben poder lanzar:

```java
RemoteException
```

La implementación extiende:

```java
UnicastRemoteObject
```

El registro se crea mediante:

```java
Registry registro =
        LocateRegistry.createRegistry(
                PUERTO_RMI
        );
```

El servicio se publica con:

```java
registro.rebind(
        NOMBRE_SERVICIO,
        servicio
);
```

El cliente obtiene la referencia mediante:

```java
registroCliente.lookup(
        NOMBRE_SERVICIO
);
```

y después invoca el método como si fuera un objeto local.

## Flujo de ejecución

```text
Crear registro
↓
exportar servicio
↓
rebind()
↓
lookup()
↓
saludar()
↓
unexportObject()
```

## Cómo ejecutar

Desde la **raíz del repositorio**, con JDK 21 y Maven:

```bash
mvn -pl unidad2 compile
java -cp unidad2/target/classes com.lelyliliana.unidad2.U2_11_RMI
```

Una sola ejecución crea primero el registro y publica el servicio, y después actúa como cliente. No ejecutes rmiregistry por separado: el puerto TCP `1099` debe estar libre. El servicio exportado con `super()` utiliza además un puerto TCP asignado dinámicamente. En la ruta correcta, unexportObject() retira servicio y registro y el proceso termina. Si un error anterior al cierre deja recursos exportados, detén la ejecución con `Ctrl+C`.

## Resultado esperado

Se recibe «Hola, Leli. Respuesta enviada mediante RMI.» y luego «Servicio RMI finalizado.».

## Qué observar

- Publicar precede a buscar e invocar.
- La interfaz remota define el contrato.
- El cierre normal desexporta ambos objetos.

## Experimenta

Cambia el argumento Leli de la llamada remota y observa la respuesta. Después de editar el código, vuelve a compilar la unidad.

---

[← Volver a la Unidad 2](../../README.md) · [← Ejemplo anterior](../ejemplo10/README.md) · [Siguiente ejemplo →](../ejemplo12/README.md)
