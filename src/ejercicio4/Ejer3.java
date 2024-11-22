package ejercicio4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class Ejer3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String[] registros = {"LOGIN","DOWNLOAD","LOGOUT","LOGIN","LOGIN", "Diego", "Pablo", "asdfgh", "DiegoDiegoDiegoDiego"};

            // Mapa para almacenar las acciones por IP
            HashMap<Integer, List<String>> hashMapPalabras = new HashMap<>();
            ArrayList<String> palabrasMetidas = new ArrayList<String>();

            for (String registro : registros) {
            	
            	int tamaño = registro.length();
            	
            	if(tamaño < 15 ) {
            		
            		hashMapPalabras.putIfAbsent(tamaño, new ArrayList<>());	
            		
            		if(hashMapPalabras.get(tamaño).isEmpty() || !palabrasMetidas.contains(registro.toLowerCase())) {

                    	hashMapPalabras.get(tamaño).add(registro.toLowerCase());  
                    	palabrasMetidas.add(registro.toLowerCase());
            		}
            	}	
            }
            
            for(Entry<Integer, List<String>> entry : hashMapPalabras.entrySet()) {
            	
            	Collections.sort(entry.getValue());
            }
            
            System.out.println("Lista de palabras: " + hashMapPalabras);
	}

}
