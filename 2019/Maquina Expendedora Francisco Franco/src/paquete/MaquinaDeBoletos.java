package paquete;

public class MaquinaDeBoletos {

	private float precio;
	private float saldo;
	private float total;
	private boolean estado;
	private int contador;
	
	public int obtenerContador() {
		return contador;
	}
	
	public boolean obtenerEstado() {
		return estado;
	}
	
	public void modificarEstado(boolean estado) {
		this.estado = estado;
	}

	public float obtenerPrecio() {
		return precio;
	}

	public void ponerPrecio(float precio) {
		this.precio = precio;
	}
	
	public float obtenerSaldo() {
		return saldo;
	}

	public void ingresarDinero(float dineroIngresado) {
		this.saldo = obtenerSaldo() + dineroIngresado;
	}

	public void imprimirBoleto() {
		this.saldo -= this.precio;
		this.total += this.precio;
		this.contador++;
		if (this.saldo > 0) {
			darVuelto();
		}
	}

	public void darVuelto() {
		if(this.saldo > 0.05) {
			System.out.printf("\nSu vuelto es: $%.2f\n\n", this.saldo);
		} else {
			this.total += this.saldo;
		}
		this.saldo -= this.saldo;
	}
	
	public boolean chequearCompleto(float dineroIngresado, float capacidad) {
		if ((dineroIngresado + this.total) > capacidad) {
			return true;
		} else {
			return false;
		}
	}
	
	public float obtenerTotal() {
		return total;
	}
	
	public void vaciar() {
		this.total = 0;
	}
	
	public MaquinaDeBoletos() {
		this.precio = 10;
		this.saldo = 0;
		this.total = 0;
	}
}
