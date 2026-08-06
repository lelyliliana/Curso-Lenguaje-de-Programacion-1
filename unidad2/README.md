# Unidad 2 - Concurrencia y Network en Java

Esta unidad presenta los fundamentos de programación en red con Java, integrando conceptos de cliente-servidor, direcciones IP, URL, sockets, TCP, UDP, serialización de objetos y RMI.

Los ejemplos están organizados de forma progresiva: comienzan con elementos básicos de red y avanzan hasta aplicaciones cliente-servidor concurrentes y comunicación remota.

## Objetivos

- Identificar los principales elementos de comunicación en red.
- Consultar información de host y dirección IP mediante `InetAddress`.
- Analizar los componentes de una URL.
- Comprender el modelo cliente-servidor.
- Crear servidores y clientes TCP mediante `ServerSocket` y `Socket`.
- Implementar comunicación bidireccional mediante TCP.
- Atender múltiples clientes de manera concurrente.
- Crear servidores y clientes UDP mediante `DatagramSocket` y `DatagramPacket`.
- Comprender la serialización y deserialización de objetos.
- Enviar objetos serializados mediante sockets TCP.
- Implementar un ejemplo básico de RMI.
- Integrar concurrencia y comunicación en red en una aplicación.

## Requisitos

- Java JDK 21.
- Apache Maven.
- Un editor de código o IDE compatible con Java.

## Estructura del proyecto

```text
unidad2/
├── pom.xml
├── README.md
└── src/
    └── main/
        └── java/
            └── com/
                └── lelyliliana/
                    └── unidad2/
                        ├── U2_01_InetAddress.java
                        ├── U2_02_URL.java
                        ├── U2_03_TCP_ServidorEco.java
                        ├── U2_04_TCP_ClienteEco.java
                        ├── U2_05_TCP_Bidireccional.java
                        ├── U2_06_TCP_Multicliente.java
                        ├── U2_07_UDP_Servidor.java
                        ├── U2_08_UDP_Cliente.java
                        ├── U2_09_Serializacion.java
                        ├── U2_10_EnvioObjetosTCP.java
                        ├── U2_11_RMI.java
                        └── U2_12_IntegradorRedes.java
```

## Compilación del proyecto

Desde la carpeta raíz del repositorio:

```bash
mvn -f unidad2/pom.xml compile
```

También puede compilarse el proyecto completo:

```bash
mvn compile
```

---

## Ejemplo 1. InetAddress

Archivo:

```text
U2_01_InetAddress.java
```

Este ejemplo utiliza la clase:

```java
java.net.InetAddress
```

para consultar información del equipo local.

Se obtiene el host mediante:

```java
InetAddress equipoLocal =
        InetAddress.getLocalHost();
```

Después pueden consultarse datos como:

```java
equipoLocal.getHostName();
```

y:

```java
equipoLocal.getHostAddress();
```

También se consulta:

```text
localhost
```

mediante:

```java
InetAddress.getByName("localhost");
```

### Ejecución

```bash
java -cp unidad2/target/classes com.lelyliliana.unidad2.U2_01_InetAddress
```

### Observación

La dirección obtenida para el equipo local depende de la configuración del sistema operativo.

Por ejemplo, en algunos sistemas Linux el nombre local puede resolverse a:

```text
127.0.1.1
```

mientras que `localhost` normalmente corresponde a:

```text
127.0.0.1
```

---

## Ejemplo 2. Componentes de una URL

Archivo:

```text
U2_02_URL.java
```

Este ejemplo analiza diferentes partes de una URL.

Se utiliza una dirección similar a:

```text
https://www.ejemplo.com:443/cursos/java?unidad=2#network
```

y se consultan componentes como:

- Protocolo.
- Host.
- Puerto.
- Puerto por defecto.
- Ruta.
- Consulta.
- Referencia.

La URL se obtiene desde un objeto `URI`:

```java
URL direccion = URI.create(
        "https://www.ejemplo.com:443/cursos/java?unidad=2#network"
).toURL();
```

### Ejecución

```bash
java -cp unidad2/target/classes com.lelyliliana.unidad2.U2_02_URL
```

### Salida aproximada

```text
COMPONENTES DE UNA URL
----------------------
Protocolo: https
Host: www.ejemplo.com
Puerto: 443
Puerto por defecto: 443
Ruta: /cursos/java
Consulta: unidad=2
Referencia: network
```

---

## Ejemplo 3. Servidor TCP tipo eco

Archivo:

```text
U2_03_TCP_ServidorEco.java
```

Este ejemplo crea un servidor TCP básico.

La clase principal utilizada es:

```java
ServerSocket
```

El servidor queda escuchando en un puerto:

```java
ServerSocket servidor =
        new ServerSocket(5000);
```

Después espera una conexión:

```java
Socket cliente =
        servidor.accept();
```

`accept()` bloquea el programa hasta que un cliente se conecte.

Una vez establecida la conexión, se utilizan flujos para leer y escribir datos.

### Ejecución

Este ejemplo debe ejecutarse antes que el cliente:

```bash
java -cp unidad2/target/classes com.lelyliliana.unidad2.U2_03_TCP_ServidorEco
```

El servidor permanecerá esperando una conexión.

---

## Ejemplo 4. Cliente TCP tipo eco

Archivo:

```text
U2_04_TCP_ClienteEco.java
```

Este ejemplo se conecta al servidor anterior mediante:

```java
Socket socket =
        new Socket(
                "localhost",
                5000
        );
```

El cliente envía un mensaje y espera una respuesta.

### Ejecución

Primero debe estar ejecutándose:

```text
U2_03_TCP_ServidorEco
```

Después se ejecuta:

```bash
java -cp unidad2/target/classes com.lelyliliana.unidad2.U2_04_TCP_ClienteEco
```

### Flujo de comunicación

```text
Cliente
   |
   | mensaje
   v
Servidor
   |
   | respuesta
   v
Cliente
```

---

## Ejemplo 5. TCP bidireccional

Archivo:

```text
U2_05_TCP_Bidireccional.java
```

Este ejemplo permite intercambiar varios mensajes utilizando una sola conexión TCP.

El servidor permanece leyendo mensajes mediante:

```java
while ((mensaje = entrada.readLine()) != null) {
```

Cada mensaje recibe una respuesta.

Cuando llega:

```text
salir
```

la comunicación termina.

En este ejemplo cliente y servidor se ejecutan dentro de hilos diferentes para facilitar la demostración desde una sola clase.

### Ejecución

```bash
java -cp unidad2/target/classes com.lelyliliana.unidad2.U2_05_TCP_Bidireccional
```

---

## Ejemplo 6. Servidor TCP multicliente

Archivo:

```text
U2_06_TCP_Multicliente.java
```

Este ejemplo muestra cómo un servidor puede atender varios clientes.

Por cada conexión aceptada se crea un nuevo hilo:

```java
Thread hiloCliente =
        new Thread(
                new ManejadorCliente(cliente),
                "Cliente-" + i
        );
```

Cada cliente puede ser atendido independientemente.

Esto integra conceptos de:

- Sockets.
- TCP.
- Cliente-servidor.
- Concurrencia.
- `Runnable`.
- Hilos.

### Ejecución

```bash
java -cp unidad2/target/classes com.lelyliliana.unidad2.U2_06_TCP_Multicliente
```

### Importante

El orden de salida puede variar entre ejecuciones porque los clientes se atienden concurrentemente.

---

# Comunicación UDP

UDP utiliza datagramas en lugar de establecer una conexión permanente.

Las clases principales utilizadas son:

```java
DatagramSocket
```

y:

```java
DatagramPacket
```

---

## Ejemplo 7. Servidor UDP

Archivo:

```text
U2_07_UDP_Servidor.java
```

El servidor crea:

```java
DatagramSocket socket =
        new DatagramSocket(6000);
```

Después prepara un paquete de recepción:

```java
DatagramPacket paqueteEntrada =
        new DatagramPacket(
                buffer,
                buffer.length
        );
```

y espera mediante:

```java
socket.receive(paqueteEntrada);
```

Después responde al mismo host y puerto desde donde llegó el datagrama.

### Ejecución

Debe ejecutarse antes que el cliente:

```bash
java -cp unidad2/target/classes com.lelyliliana.unidad2.U2_07_UDP_Servidor
```

---

## Ejemplo 8. Cliente UDP

Archivo:

```text
U2_08_UDP_Cliente.java
```

El cliente construye un datagrama:

```java
DatagramPacket paqueteSalida =
        new DatagramPacket(
                datos,
                datos.length,
                direccionServidor,
                PUERTO
        );
```

y lo envía mediante:

```java
socket.send(paqueteSalida);
```

Después espera otro datagrama como respuesta.

### Ejecución

Primero:

```text
U2_07_UDP_Servidor
```

Después:

```bash
java -cp unidad2/target/classes com.lelyliliana.unidad2.U2_08_UDP_Cliente
```

---

# TCP vs UDP

| Característica | TCP | UDP |
|---|---|---|
| Orientado a conexión | Sí | No |
| Garantiza entrega | Sí | No |
| Mantiene el orden | Sí | No necesariamente |
| Control de errores | Mayor | Menor |
| Sobrecarga | Mayor | Menor |
| Forma de comunicación | Flujo | Datagramas |
| Clases principales en Java | `Socket`, `ServerSocket` | `DatagramSocket`, `DatagramPacket` |

---

# Serialización

Serializar consiste en convertir el estado de un objeto en una secuencia de bytes.

Esto permite:

- Guardarlo en un archivo.
- Enviarlo por una red.
- Reconstruirlo posteriormente.

Una clase serializable implementa:

```java
Serializable
```

---

## Ejemplo 9. Serialización de objetos

Archivo:

```text
U2_09_Serializacion.java
```

La clase `Estudiante` implementa:

```java
Serializable
```

El objeto se guarda mediante:

```java
ObjectOutputStream
```

y:

```java
writeObject()
```

Por ejemplo:

```java
salida.writeObject(estudiante);
```

Después se recupera mediante:

```java
ObjectInputStream
```

y:

```java
readObject()
```

### Ejecución

```bash
java -cp unidad2/target/classes com.lelyliliana.unidad2.U2_09_Serializacion
```

Durante la ejecución se genera el archivo:

```text
estudiante.dat
```

---

## Ejemplo 10. Envío de objetos por TCP

Archivo:

```text
U2_10_EnvioObjetosTCP.java
```

Este ejemplo integra:

- TCP.
- Sockets.
- Serialización.
- `ObjectInputStream`.
- `ObjectOutputStream`.

El cliente envía un objeto:

```java
salida.writeObject(estudiante);
```

El servidor lo recupera mediante:

```java
Estudiante estudiante =
        (Estudiante) entrada.readObject();
```

Luego el servidor devuelve una confirmación al cliente.

### Ejecución

```bash
java -cp unidad2/target/classes com.lelyliliana.unidad2.U2_10_EnvioObjetosTCP
```

---

# RMI

RMI significa:

```text
Remote Method Invocation
```

Permite invocar métodos de objetos remotos utilizando Java.

Los elementos principales son:

1. Interfaz remota.
2. Implementación del objeto remoto.
3. Registro RMI.
4. Publicación del servicio.
5. Cliente.
6. Búsqueda mediante `lookup()`.
7. Invocación del método remoto.

---

## Ejemplo 11. RMI

Archivo:

```text
U2_11_RMI.java
```

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
LocateRegistry.createRegistry(1099);
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

### Ejecución

```bash
java -cp unidad2/target/classes com.lelyliliana.unidad2.U2_11_RMI
```

---

## Ejemplo 12. Ejercicio integrador de redes

Archivo:

```text
U2_12_IntegradorRedes.java
```

Este ejemplo integra:

- `ServerSocket`.
- `Socket`.
- TCP.
- Varios clientes.
- Hilos.
- `Runnable`.
- Procesamiento de solicitudes.
- Respuestas del servidor.

El servidor acepta varias conexiones:

```java
Socket socket =
        serverSocket.accept();
```

y crea un hilo para cada cliente:

```java
Thread hiloCliente =
        new Thread(
                new AtenderCliente(socket),
                "Atencion-" + i
        );
```

Cada cliente envía:

- Nombre.
- Tipo de operación.

El servidor procesa operaciones como:

```text
saludo
hora
estado
```

mediante una expresión `switch`.

### Ejecución

```bash
java -cp unidad2/target/classes com.lelyliliana.unidad2.U2_12_IntegradorRedes
```

### Importante

El orden de atención puede variar porque existen varios hilos ejecutándose concurrentemente.

---

# Conceptos principales de la unidad

## Host

Equipo conectado a una red e identificado mediante un nombre o dirección.

## Dirección IP

Identificador utilizado para localizar un dispositivo dentro de una red IP.

## Puerto

Número utilizado para identificar una aplicación o servicio dentro de un equipo.

## Socket

Extremo de una comunicación entre dos aplicaciones.

## Cliente

Aplicación que solicita un servicio.

## Servidor

Aplicación que espera solicitudes y proporciona servicios.

## Protocolo

Conjunto de reglas utilizadas para realizar una comunicación.

## TCP

Protocolo orientado a conexión que proporciona comunicación confiable y ordenada.

## UDP

Protocolo sin conexión que utiliza datagramas y no garantiza entrega ni orden.

## Serialización

Conversión de un objeto en una secuencia de bytes.

## Deserialización

Reconstrucción de un objeto a partir de una secuencia de bytes.

## RMI

Mecanismo de Java que permite invocar métodos de objetos remotos.

---

# Clases principales utilizadas

| Clase o interfaz | Propósito |
|---|---|
| `InetAddress` | Representa información relacionada con una dirección IP. |
| `URI` | Representa un identificador de recurso. |
| `URL` | Representa la ubicación de un recurso. |
| `ServerSocket` | Espera conexiones TCP del lado servidor. |
| `Socket` | Representa un extremo de una conexión TCP. |
| `BufferedReader` | Permite lectura de texto mediante búfer. |
| `PrintWriter` | Facilita envío de texto. |
| `DatagramSocket` | Envía y recibe datagramas UDP. |
| `DatagramPacket` | Representa un datagrama UDP. |
| `Serializable` | Marca una clase cuyos objetos pueden serializarse. |
| `ObjectOutputStream` | Escribe objetos serializados. |
| `ObjectInputStream` | Lee objetos serializados. |
| `Remote` | Marca una interfaz como remota en RMI. |
| `UnicastRemoteObject` | Permite exportar objetos remotos. |
| `Registry` | Representa el registro de servicios RMI. |
| `LocateRegistry` | Permite crear o localizar un registro RMI. |

---

# Puertos utilizados en los ejemplos

| Ejemplo | Puerto |
|---|---:|
| TCP eco | `5000` |
| TCP bidireccional | `5001` |
| TCP multicliente | `5002` |
| UDP | `6000` |
| Objetos TCP | `6001` |
| RMI | `1099` |
| Integrador | `7000` |

Si alguno de estos puertos está ocupado en el equipo, puede sustituirse por otro puerto disponible siempre que cliente y servidor utilicen el mismo valor.

---

# Orden recomendado de estudio

1. `InetAddress`.
2. Componentes de una URL.
3. Servidor TCP.
4. Cliente TCP.
5. Comunicación TCP bidireccional.
6. Servidor TCP multicliente.
7. Servidor UDP.
8. Cliente UDP.
9. Serialización.
10. Envío de objetos por TCP.
11. RMI.
12. Ejercicio integrador de redes.

---

# Recomendaciones

En los ejemplos cliente-servidor que utilizan archivos diferentes, debe ejecutarse primero el servidor.

Por ejemplo:

```text
U2_03_TCP_ServidorEco
```

antes de:

```text
U2_04_TCP_ClienteEco
```

y:

```text
U2_07_UDP_Servidor
```

antes de:

```text
U2_08_UDP_Cliente
```

Si aparece un error similar a:

```text
Address already in use
```

significa que el puerto está siendo utilizado por otro proceso o quedó otra ejecución activa.

La comunicación mediante `localhost` permite probar cliente y servidor en una misma computadora. Para realizar pruebas entre dos equipos diferentes, debe utilizarse la dirección IP del equipo donde se ejecuta el servidor y deben revisarse las reglas de red y firewall correspondientes.