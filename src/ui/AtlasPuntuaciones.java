
// Descripción del programa:
/* 
Entradas:
1. Cantidad de rondas (valor maximo 5)
2. Cantidad de jugadores (Maximo 10)
3. Puntaje de cada jugador por cada ronda

Salidas
1. Por cada jugador su promedio y suma de puntaje en todas las rondas
2. Jugador con puntaje mas alto, en caso de empate cualquiera de los tengan el puntaje maximo

Proceso.
1. Solicitar entradas  1 (rondas) y 2 (numero de jugadores)
2. Crear los arreglos para almacenar la informacion
3. Ciclo para solicitar los puntajes por jugador en cada ronda
4. En un metodo hacer los calculos de promedio y suma total por jugador y almacenar en otro arreglo
5. Imprimir los valores de puntaje para cada jugador y el mas alto
*/


package ui; // No olvidar especificar el paquete / carpeta de nuestro programa

import java.util.Scanner; // Para poder usar Scanner, debemos importarlo

public class AtlasPuntuaciones {

	// Declaración del Escaner que nos ayudará en todo el programa
	private Scanner escaner;

	// Declaración de nuestras constantes a utilizar


	private AtlasPuntuaciones() {
		escaner = new Scanner(System.in);
	}
	
	/**
	 * 
	 */
	public void run()
	{
		// Declaracion de todas las variables a usar en el programa
		int rondas, jugadores, maximo = 0, ganador = 0;
		double promedios;
		System.out.println("Hola bienvenido a Atlas Puntajes, para iniciar el proceso necesitare la cantidad de rondas que haras (Maximo 10)");
		rondas = leerEnteroMaximo(10, "rondas");
		System.out.println("Bien Ahora dime la cantidad de judadores que participaran (Maximo 5)");
		jugadores = leerEnteroMaximo(5, "jugadores");

		int [][] partida = new int[jugadores][rondas];

		for(int i = 0; i < jugadores ; i++) {
			for(int j = 0; j< rondas ; j++){
				System.err.println("digame los puntajes del jugador "+ (i+1) + " en la ronda " + (j+1) );
				partida[i][j] = leerpuntaje();
			}
        }

		int totales[] = calculartotales(partida);
		for(int i = 0; i < totales.length; i++){
			System.out.println("jugador "+ (i+1)+" Puntaje total: "+ totales[i]+", Promedio: "+ (totales[i]/rondas));
		}
		
		for (int i = 0; i < totales.length; i++) {
			if(totales[i]>maximo){
				maximo = totales[i];
				ganador = i;
			}
		}
		System.out.println("El jugador con mayor puntaje es, el judador "+ (ganador+1));
	}

	/**
	 * Calcula los totales por cada jugador en la partida
	 */
	public int[] calculartotales(int[][] partida){
		int[] totales = new int [partida.length];
		for(int i = 0; i < partida.length ; i++) {
			for(int j = 0; j< partida[0].length ; j++){
				totales[i] = totales[i]+partida[i][j];
				
			}
	 
        }
		return totales;
	}

	/**
 	* Lee un puntaje, valida que no supere el valor de 100
 	*/
	public int leerpuntaje(){
		int puntaje = escaner.nextInt();
		while (puntaje > 100){
			System.out.println("Valor invalido, el valor debe ser maximo 100");
			puntaje = escaner.nextInt();
		}
		return puntaje;
	}

	/**
	 * Le un entero se asegura que el valor no supere maximo y si lo supera muestra el mensaje
	 * maximo: valor maximo que el usuario puede digitar
	 * mensaje: Mensaje que se le presentara al usuario cuando exceda el valor
	 */
	public int leerEnteroMaximo(int maximo, String mensaje){
		int puntaje = escaner.nextInt();
		while (puntaje > maximo){
			System.out.println("Valor invalido, el valor maximo de "+ mensaje +" es de " + maximo);
			puntaje = escaner.nextInt();
		}
		return puntaje;
	}

	public static void main(String[] args) {
		AtlasPuntuaciones mainApp = new AtlasPuntuaciones();
		mainApp.run();
	}

	
	
}