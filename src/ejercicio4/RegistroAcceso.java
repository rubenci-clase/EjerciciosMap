package ejercicio4;

import java.util.*;

public class RegistroAcceso {
    public static void main(String[] args) {
        String[] registros = {
            "192.168.1.1 - LOGIN - 2023-11-20T10:15:30",
            "192.168.1.2 - DOWNLOAD - 2023-11-20T10:16:00",
            "192.168.1.1 - LOGOUT - 2023-11-20T10:17:00",
            "192.168.1.3 - LOGIN - 2023-11-20T10:18:00",
            "192.168.1.1 - LOGIN - 2023-11-20T10:20:00"
        };

        // Mapa para almacenar las acciones por IP
        HashMap<String, List<String>> accionesPorIP = new HashMap<>();

        for (String registro : registros) {
            String[] partes = registro.split(" - ");
            String ip = partes[0];
            String accion = partes[1];

            accionesPorIP.putIfAbsent(ip, new ArrayList<>());
            accionesPorIP.get(ip).add(accion);
        }

        // Encontrar la IP con más acciones
        String ipConMasAcciones = null;
        int maxAcciones = 0;

        
        for (Map.Entry<String, List<String>> entry : accionesPorIP.entrySet()) {
            if (entry.getValue().size() > maxAcciones) {
                maxAcciones = entry.getValue().size();
                ipConMasAcciones = entry.getKey();
            }
        }

        System.out.println("Acciones por IP: " + accionesPorIP);
        System.out.println("IP con más acciones: " + ipConMasAcciones + " (" + maxAcciones + " acciones)");
    }
}