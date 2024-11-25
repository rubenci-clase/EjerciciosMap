package ejercicio4;

import java.util.HashMap;

public class Ejer1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        HashMap<String, HashMap<String, Integer>> hashMapVotos = new HashMap<>();
		
		String[] registros = {"Presidente , Felipe", "Presidente , Juan","Gobernador , Shiva", "Gobernador , Pablo", "Gobernador , Shiva"};
		
        for (String registro : registros) {
        	
            String[] partes = registro.split(" , ");
        	String cargo = partes[0];
        	String nombre = partes[1];
        	HashMap <String, Integer> mapaVoto = new HashMap<>();
        	mapaVoto.putIfAbsent(nombre, 1);
        	
        	if (!hashMapVotos.containsKey(cargo)) { //Si el cargo no existe
        		hashMapVotos.putIfAbsent(cargo, mapaVoto); //Lo añadimos y añadimos el voto

        	}
        	else if (hashMapVotos.get(cargo).containsKey(nombre)){ //Si, si existe el cargo y el nombre
        		HashMap<String, Integer> hashMapInterno = hashMapVotos.get(cargo);
        		Integer numero = hashMapInterno.get(nombre) + 1;
        		hashMapInterno.put(nombre, numero);
        		hashMapVotos.put(cargo, hashMapInterno);
        	}
        	else { // Si existe el cargo pero no el nombre
        		hashMapVotos.get(cargo).putAll(mapaVoto);
        	}
        }        
        
        for (String innerKey : hashMapVotos.keySet()) {
            System.out.println("  Cargo: " + innerKey + ", Votos: " + hashMapVotos.get(innerKey));
        }
	}
}
