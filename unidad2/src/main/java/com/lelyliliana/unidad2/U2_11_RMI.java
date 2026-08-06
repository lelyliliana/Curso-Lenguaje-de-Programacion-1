package com.lelyliliana.unidad2;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class U2_11_RMI {

    private static final int PUERTO_RMI = 1099;
    private static final String NOMBRE_SERVICIO = "ServicioSaludo";

    public interface ServicioSaludo extends Remote {

        String saludar(String nombre)
                throws RemoteException;
    }

    static class ServicioSaludoImpl
            extends UnicastRemoteObject
            implements ServicioSaludo {

        protected ServicioSaludoImpl()
                throws RemoteException {
            super();
        }

        @Override
        public String saludar(String nombre)
                throws RemoteException {

            return "Hola, "
                    + nombre
                    + ". Respuesta enviada mediante RMI.";
        }
    }

    public static void main(String[] args) {

        try {

            System.out.println("EJEMPLO RMI");
            System.out.println("-----------");

            Registry registro =
                    LocateRegistry.createRegistry(
                            PUERTO_RMI
                    );

            ServicioSaludo servicio =
                    new ServicioSaludoImpl();

            registro.rebind(
                    NOMBRE_SERVICIO,
                    servicio
            );

            System.out.println(
                    "Servidor: servicio publicado como "
                            + NOMBRE_SERVICIO
            );

            Registry registroCliente =
                    LocateRegistry.getRegistry(
                            "localhost",
                            PUERTO_RMI
                    );

            ServicioSaludo servicioRemoto =
                    (ServicioSaludo) registroCliente.lookup(
                            NOMBRE_SERVICIO
                    );

            String respuesta =
                    servicioRemoto.saludar("Leli");

            System.out.println(
                    "Cliente recibió:"
            );

            System.out.println(respuesta);

            UnicastRemoteObject.unexportObject(
                    servicio,
                    true
            );

            UnicastRemoteObject.unexportObject(
                    registro,
                    true
            );

            System.out.println(
                    "Servicio RMI finalizado."
            );

        } catch (Exception e) {

            System.out.println(
                    "Error en RMI: "
                            + e.getMessage()
            );
        }
    }
}