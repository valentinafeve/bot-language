package org.jpavlich.bot;

/** Interfaz para manejar el robot. 
 * Basta con invocar cada m�todo para que el robot autom�ticamente
 * realice la acci�n correspondiente.
 * @author jaimepavlich-mariscal
 *
 */
/**
 * @author jpavlich
 *
 */
public interface Bot {



	/** Mueve el robot hacia abajo la distancia indicada
	 * @param steps Número de pixeles que se mueve el robot hacia atr�s
	 * @return Número de pasos que pudo moverse efectivamente
	 */
	public int down(int steps);

	/** Mueve el robot hacia arriba la distancia indicada
	 * @param steps Número de pixeles que se mueve el robot hacia adelante
	 * @return Número de pasos que pudo moverse efectivamente
	 */
	public int up(int steps);

	/** Rota el robot hacia la izquierda la distancia indicada
	 * @param angle Grados a rotar el robot hacia la izquierda
	 * @return Número de pasos que pudo moverse efectivamente
	 */
	public int left(int steps);

	/** Rota el robot hacia la derecha la la distancia indicada
	 * @param angle Grados a rotar el robot hacia la derecha
	 * @return Número de pasos que pudo moverse efectivamente
	 */
	public int right(int steps);

	/**
	 * Bota el elemento que el robot está cargando
	 * @return True si logra botar el elemento, es decir, si no había nada en el piso antes. Falso en caso contrario
	 */
	public boolean drop();

	/**
	 * Recoge el elemento que se encuentra bajo el robot.
	 * @return True, si pudo recoger el elemento, es decir, si el robot no llevaba nada consigo antes. Falso en caso contrario.
	 */
	public boolean pick();

	/** Mira qué elemento se encuentra debajo del robot.
	 * @return El código del elemento que hay debajo. 0 si no había nada en el suelo
	 */
	public int look();
	
	
	/** 
	 * @return El código del objeto que el robot está cargando. 0 si no tiene nada.
	 */
	public int inventory();
	

}
