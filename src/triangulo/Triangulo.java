package triangulo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Triangulo {

	private int lado1;
	private int lado2;
	private int lado3;
	
	public static void main(String[] args) throws IOException {
		//1
		String rutaEntrada = "entrada.txt";
		String rutaSalida = "salida.txt";
		FileReader reader = new FileReader (rutaEntrada);
		BufferedReader entrada = new BufferedReader (reader);
		FileWriter writer = new FileWriter (rutaSalida);
		PrintWriter salida = new PrintWriter(writer);
		String linea = new String();
		String clasificacion = new String();
		//2
		while((linea = entrada.readLine()) != null) {
			//3
			String[] lados = linea.split(" ");
			//4
			if(lados.length == 3) {
				//5
				if(entradasValidas(lados[0],lados[1],lados[2])) {
					//6
					Triangulo triangulo = new Triangulo(lados[0],lados[1],lados[2]);
					//7
					if(triangulo.esTrianguloValido()) {
						//8
						if(triangulo.esEscaleno())
							//9
							clasificacion = "El triangulo es escaleno";
						//10
						else if(triangulo.esIsosceles())
							//11
							clasificacion = "El triangulo es isosceles";
						//12
						else
							clasificacion = "El triangulo es equilatero";
					}
					//13
					else
						clasificacion = "Los numeros ingresados no forman un triangulo";
				}
				//14
				else
					clasificacion = "Las entradas no son numeros enteros positivos";
				
			}
			//15
			else
				clasificacion = "No posee 3 lados";
			//16
			salida.println(clasificacion);
		}
		//17
		entrada.close();
		salida.close();

	}
	
	public Triangulo(String lado1, String lado2, String lado3) {
		this.lado1 = Integer.parseInt(lado1);
		this.lado2 = Integer.parseInt(lado2);
		this.lado3 = Integer.parseInt(lado3);
	}
	
	public static boolean entradasValidas(String lado1, String lado2, String lado3) {
		boolean valido = false;
		try {
			if(Integer.parseInt(lado1) > 0 && Integer.parseInt(lado2) > 0 && Integer.parseInt(lado3) > 0)
				valido = true;
			else
				valido = false;
		} catch (NumberFormatException nfe){
			valido = false;
		}
		return valido;
	}
	
	public boolean esTrianguloValido() {
		return ( (lado1 < (lado2 + lado3)) && (lado2 < (lado3 + lado1)) && (lado3 < (lado1 + lado2)) );
	}
	
	public boolean esEquilatero() {
		return (lado1 == lado2 && lado2 == lado3 && lado3 == lado1);
	}
	
	public boolean esIsosceles() {
		return ( (lado1 == lado2 && lado1 != lado3) || (lado2 == lado3 && lado2 != lado1) || (lado3 == lado1 && lado3 != lado2) );
	}
	
	public boolean esEscaleno() {
		return (lado1 != lado2 && lado2 != lado3 && lado3 != lado1);
	}

	public int getLado1() {
		return lado1;
	}

	public void setLado1(int lado1) {
		this.lado1 = lado1;
	}

	public int getLado2() {
		return lado2;
	}

	public void setLado2(int lado2) {
		this.lado2 = lado2;
	}

	public int getLado3() {
		return lado3;
	}

	public void setLado3(int lado3) {
		this.lado3 = lado3;
	}
	
	

}
