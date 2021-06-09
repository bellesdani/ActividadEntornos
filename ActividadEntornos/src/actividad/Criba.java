package actividad;

import java.util.Scanner;

/**
 * 
 * La clase Criba sirve para indicar los nº primos del 1 hasta el numero indicado por el usuario. 
 * @author Daniel Bellés
 * @version 1.0.0
 */

public class Criba {
	
	/**
	 * Metodo necesario para hacer los metodos de generacion de Primos
	 * @param max
	 * @return dim
	 */
	
	public static int dim(int max) {
		
		int i, j;
		if (max >= 2) {
			int dim = max + 1; 
			boolean[] esPrimo = new boolean[dim];
			
			for (i = 0; i < dim; i++)
				esPrimo[i] = true;
			esPrimo[0] = esPrimo[1] = false;
			
			for (i = 2; i < Math.sqrt(dim) + 1; i++) {
				if (esPrimo[i]) {
					for (j = 2 * i; j < dim; j += i)
						esPrimo[j] = false;
				}
			}
			return dim;
		}
		else { 
			return 0;
		}
	}
	
	/**
	 * Metodo que devuelve un array de booleanos , en el que si es true, es primo
	 * @param max
	 * @return 
	 */
	
public static boolean[] esPrimo(int max) {
		
		int i, j;
		if (max >= 2) {
			int dim = max + 1; 
			boolean[] esPrimo = new boolean[dim];
			
			for (i = 0; i < dim; i++)
				esPrimo[i] = true;
			esPrimo[0] = esPrimo[1] = false;
			
			for (i = 2; i < Math.sqrt(dim) + 1; i++) {
				if (esPrimo[i]) {
					for (j = 2 * i; j < dim; j += i)
						esPrimo[j] = false;
				}
			}
			return esPrimo;
		}else { 
			return new boolean[0];
		}
	}
	
/**
 * Array de enteros con todos los primos desde el 2 hasta el nº indicado por el usuario
 * @param max
 * @return primos
 */

	public static int[] generarPrimos(int max) {
		
		int i, j;
		if (max >= 2) {
		int dim=dim(max);
		boolean[] esPrimo=esPrimo(max);
			
			int cuenta = 0;
			for (i = 0; i < dim; i++) {
				if (esPrimo[i])
					cuenta++;
			}
			int[] primos = new int[cuenta];
			for (i = 0, j = 0; i < dim; i++) {
				if (esPrimo[i])
					primos[j++] = i;
			}
			return primos;
		} else { 
			return new int[0];
		}
	}

	/**
	 * Main de la clase , que pregunta un numero al usuario para ensenyarle los primos hasta él
	 * @param args
	 */
	
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce el número para la criba de Erastótenes:");
		
		int dato = teclado.nextInt();
		int vector[] = new int[dato];
		teclado.close();
		
		System.out.println("\nVector inicial hasta : " + dato);
		
		for (int i = 0; i < vector.length; i++) {
			if (i % 10 == 0)
				System.out.println();
			System.out.print(i + 1 + "\t");
		}
		
		vector = generarPrimos(dato);
		
		System.out.println("\nVector de primos hasta:" + dato);
		
		for (int i = 0; i < vector.length; i++) {
			if (i % 10 == 0)
				System.out.println();
			System.out.print(vector[i] + "\t");
		}
		System.out.println("REFACTORIZAMOS EL CÓDIGO");
		teclado.close();
	}
}
