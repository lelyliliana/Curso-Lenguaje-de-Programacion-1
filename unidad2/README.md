# Unidad 2 – Concurrencia y Network

Esta unidad presenta los fundamentos de programación en red con Java, integrando conceptos de cliente-servidor, direcciones IP, URL, sockets, TCP, UDP, serialización de objetos y RMI.

Los ejemplos están organizados de forma progresiva: comienzan con elementos básicos de red y avanzan hasta aplicaciones cliente-servidor concurrentes y comunicación remota.

## Objetivos de la unidad

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

## Tecnologías o APIs utilizadas

Java 21, Maven, `java.net` (TCP, UDP, URI y URL), `java.io` (texto y serialización), `java.rmi`, `Thread` y `Runnable`.

## Ejemplos

| Ejemplo | Tema |
|---|---|
| [U2_01](docs/ejemplo01/README.md) | InetAddress |
| [U2_02](docs/ejemplo02/README.md) | Componentes de una URL |
| [U2_03](docs/ejemplo03/README.md) | Servidor TCP tipo eco |
| [U2_04](docs/ejemplo04/README.md) | Cliente TCP tipo eco |
| [U2_05](docs/ejemplo05/README.md) | TCP bidireccional |
| [U2_06](docs/ejemplo06/README.md) | Servidor TCP multicliente |
| [U2_07](docs/ejemplo07/README.md) | Servidor UDP |
| [U2_08](docs/ejemplo08/README.md) | Cliente UDP |
| [U2_09](docs/ejemplo09/README.md) | Serialización de objetos |
| [U2_10](docs/ejemplo10/README.md) | Envío de objetos por TCP |
| [U2_11](docs/ejemplo11/README.md) | RMI |
| [U2_12](docs/ejemplo12/README.md) | Ejercicio integrador de redes |

Cada enlace abre la guía del ejemplo con acceso directo al archivo Java, ejecución, resultados y navegación al ejemplo siguiente. La documentación vive en `docs/`; los paquetes Java conservan su ubicación.

## Requisitos

- Java JDK 21.
- Apache Maven.
- Un editor de código o IDE compatible con Java (opcional).

## Estructura del proyecto

```text
unidad2/
├── pom.xml
├── README.md
├── docs/                         # README por ejemplo
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

## Ejecución

- Los ejemplos 03/04 (TCP) y 07/08 (UDP) requieren dos terminales: primero el servidor y después el cliente. Terminan tras un intercambio correcto.
- Los ejemplos 05, 06, 10 y 12 crean servidor y clientes en una sola ejecución. La pausa de 500 ms facilita el arranque, pero no garantiza disponibilidad.
- El ejemplo 11 crea su propio registro RMI y lo cierra al terminar correctamente; no requiere rmiregistry externo.
- Si una ejecución queda esperando, usa `Ctrl+C`. UDP no configura timeout: una pérdida puede dejar al cliente esperando indefinidamente.

Desde la carpeta raíz del repositorio:

```bash
mvn -f unidad2/pom.xml compile
```

También puede compilarse el proyecto completo:

```bash
mvn compile
```

Los comandos de esta unidad y de sus ejemplos se ejecutan desde la **raíz del repositorio**. Después de compilar, ejecuta una clase por su nombre completo, por ejemplo:

```bash
java -cp unidad2/target/classes com.lelyliliana.unidad2.U2_01_InetAddress
```

También puedes ejecutar su método `main` desde el IDE. Consulta cada guía para los detalles y resultados esperados.

## Comunicación UDP

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

## TCP vs UDP

| Característica | TCP | UDP |
|---|---|---|
| Orientado a conexión | Sí | No |
| Entrega | Flujo fiable y ordenado mientras la conexión funciona; pueden ocurrir fallos | Sin garantía de entrega ni reintentos automáticos |
| Mantiene el orden | Sí | No necesariamente |
| Recuperación de pérdidas | Retransmisión integrada | La aplicación debe gestionarla si la necesita |
| Sobrecarga | Mayor | Menor |
| Forma de comunicación | Flujo | Datagramas |
| Clases principales en Java | `Socket`, `ServerSocket` | `DatagramSocket`, `DatagramPacket` |

---

## Serialización

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

## RMI

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

## Conceptos principales

### Host

Equipo conectado a una red e identificado mediante un nombre o dirección.

### Dirección IP

Identificador utilizado para localizar un dispositivo dentro de una red IP.

### Puerto

Número utilizado para identificar una aplicación o servicio dentro de un equipo.

### Socket

Extremo de una comunicación entre dos aplicaciones.

### Cliente

Aplicación que solicita un servicio.

### Servidor

Aplicación que espera solicitudes y proporciona servicios.

### Protocolo

Conjunto de reglas utilizadas para realizar una comunicación.

### TCP

Protocolo orientado a conexión que proporciona comunicación confiable y ordenada.

### UDP

Protocolo sin conexión que utiliza datagramas y no garantiza entrega ni orden.

### Serialización

Conversión de un objeto en una secuencia de bytes.

### Deserialización

Reconstrucción de un objeto a partir de una secuencia de bytes.

### RMI

Mecanismo de Java que permite invocar métodos de objetos remotos.

---

## Clases principales utilizadas

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

## Puertos utilizados en los ejemplos

| Ejemplo | Puerto |
|---|---:|
| TCP eco | `5000` |
| TCP bidireccional | `5001` |
| TCP multicliente | `5002` |
| UDP | `6000` |
| Objetos TCP | `6001` |
| RMI | `1099` (registro) y un puerto TCP dinámico para el objeto remoto |
| Integrador | `7000` |

Si alguno de estos puertos está ocupado en el equipo, puede sustituirse por otro puerto disponible siempre que cliente y servidor utilicen el mismo valor.

---

## Orden recomendado de estudio

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

## Recomendaciones

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

[← Volver al inicio del repositorio](../README.md)
