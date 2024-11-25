package ejercicio4;

import java.util.HashMap;

public class Ejer2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] registros = {"Felipe", "Juan","Shiva", "Pablo"};
		HashMap<String, HashMap<Character, Integer>>  hashMapPalabras = new HashMap<>();
		
		for (String registro : registros) {
			
			hashMapPalabras.put(registro, new HashMap<Character, Integer>());
			
			for (int i = 0; i< registro.length(); i++) {
				HashMap<Character, Integer> hashMapinterno = hashMapPalabras.get(registro);
				
				char caracter = registro.charAt(i);
				
				if (hashMapinterno.isEmpty() || hashMapinterno.get(caracter) == null) {
					hashMapinterno.put(caracter, 1);
				}
				
				else {
					int cantidad = hashMapinterno.get(caracter) + 1;
					
					hashMapinterno.put(caracter, cantidad);
				}
			}
			
		}
		
        for (String innerKey : hashMapPalabras.keySet()) {
            System.out.println("  Palabra: " + innerKey + ", Letras: " + hashMapPalabras.get(innerKey));
        }
		
	}

}
