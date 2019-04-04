package paquete;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Main {

	private static final float CAPACIDAD = 1000;

	public static void main(String[] args) {

		MaquinaDeBoletos maquina = new MaquinaDeBoletos();
		Scanner scan = new Scanner(System.in);
		int opcion = 0;

		do {
			System.out.println("Bienvenido! Como lo podemos ayudar?");
			System.out.println("\n\t 1. Ingresar dinero");
			System.out.println("\t 2. Obtener saldo");
			System.out.println("\t 3. Obtener precio boleto");
			System.out.println("\t 4. Obtener total");
			System.out.println("\t 5. Poner precio");
			System.out.println("\t 6. Vaciar maquina");
			System.out.println("\t 7. Ver cantidad de boletos impresos");
			System.out.println("\t 0. Salir");
			System.out.print("\n\t Ingrese su opcion: ");
			opcion = scan.nextInt();

			switch (opcion) {
			case 1:
				System.out.print("Cantidad de dinero a ingresar: ");
				float dineroIngresado = scan.nextFloat();
				if (dineroIngresado > 0 && !maquina.chequearCompleto(dineroIngresado, CAPACIDAD)) {
					maquina.ingresarDinero(dineroIngresado);
					if(maquina.obtenerSaldo() >= maquina.obtenerPrecio()) {
						maquina.imprimirBoleto();
					}
				} else if(dineroIngresado <= 0){
					System.out.println("Ingrese una cantidad valida de dinero.");
				} else {
					System.out.println("La maquina expendedora no recibe más dinero. Lamentamos las molestias");
				}
				
				break;

			case 2:
				System.out.printf("\nSu saldo es de: $%.2f \n \n", maquina.obtenerSaldo());
				break;

			case 3:
				System.out.printf("\nPrecio del boleto: $%.2f\n\n", maquina.obtenerPrecio());				
				break;
				
			case 4:
				System.out.printf("\nEl total recaudado es de: $%.2f \n \n", maquina.obtenerTotal());
				break;
				
			case 5:
				System.out.print("Ingrese el nuevo precio: ");
				float nuevoPrecio = scan.nextFloat();
				if(nuevoPrecio > 0) {
					maquina.ponerPrecio(nuevoPrecio);
					System.out.println("Operación realizada con éxito!");
				} else {
					System.out.println("Ingrese un monto valido.");
				}
				break;
				
			case 6:
				maquina.vaciar();
				System.out.println("\nLa maquina se encuentra vacia\n");
				break;
				
			case 7:
				System.out.println("\nSe imprimeron " + maquina.obtenerContador() + " boleto/s\n");
				
			case 0:
				break;
				
			default:
				System.out.println("Ingrese una opción valida");
				break;
			}
			
		} while (opcion != 0);
		
		scan.close();
		
		//JOptionPane pane = new JOptionPane();
		
		//pane.showMessageDialog(pane, "Mati tiene plata");
	}

}
