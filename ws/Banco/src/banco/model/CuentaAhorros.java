package banco.model;
import banco.exceptions.CuentaExceptions;

public class CuentaAhorros extends Cuenta {
	private boolean activa;
	public CuentaAhorros(float saldo, float tasaAnual) {
		super(saldo, tasaAnual);
		if (saldo < 10000) /* Si el saldo es menor a 10000, la cuenta no se activa */
			activa = false;
		else
			activa = true;
	}
	public void retirar(float cantidad) throws CuentaExceptions {
		if (activa) // Si la cuenta esta activa, se puede retirar dinero
			super.retirarDinero(cantidad); /* Invoca al metodo retirar de la clase padre */
	}
	public void consignar(float cantidad) throws CuentaExceptions {
		if (activa) // Si la cuenta esta activa, se puede consignar dinero
			super.consignarDinero(cantidad); /* Invoca al metodo consignar de la clase padre */
	}
	public void extractoMensual() {
		/* Si la cantidad de retiros es superior a cuatro, se genera una comision mensual */
		if (getnRetiros()> 4) {
			setComisionM(getComisionM() + (getnRetiros() - 4) * 1000);
		}
		super.extractoMensual(); // Invoca al metodo de la clase padre /* Si el saldo actualizado de la cuenta es menor a 10000, la cuenta no se activa */
		if ( saldo < 10000 )
			activa = false;
	}
	public void imprimir() {
		System.out.println("Saldo = $ " + saldo);
		System.out.println("Comision mensual = $ " + getComisionM());
		System.out.println("Numero de transacciones = "+ (getnConsignaciones()+ getnRetiros()));
		System.out.println();
	}
}
