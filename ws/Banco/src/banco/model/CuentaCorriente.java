package banco.model;

import banco.exceptions.CuentaExceptions;

public class CuentaCorriente extends Cuenta{
	float sobreGiro;
	public CuentaCorriente(float saldo, float tasaAnual) {
		super(saldo, tasaAnual); // Invoca al constructor de la clase padre
		sobreGiro = 0; // Inicialmente no hay sobregiro
	}
	public void retirar(float cantidad) throws CuentaExceptions {
		float resultado = saldo - cantidad; // Se calcula un saldo temporal
		/* Si el valor a retirar supera el saldo de la cuenta, el valor excedente se convierte en sobregiro y el saldo es cero */
		if (resultado < 0) {
			sobreGiro = sobreGiro - resultado;
			saldo = 0;
		} else {
			super.retirarDinero(cantidad); /* Si no hay sobregiro, se realiza un retiro normal */
		}
	}
	public void consignar(float cantidad) throws CuentaExceptions {
		float residuo = sobreGiro - cantidad;
		// Si existe sobregiro la cantidad consignada se resta al sobregiro
		if (sobreGiro > 0) {
			if ( residuo > 0) { /* Si el residuo es mayor que cero, se libera el sobregiro */
				sobreGiro = 0;
				saldo = residuo;
			} else { /* Si el residuo es menor que cero, el saldo es cero y surge un sobregiro */
				sobreGiro = -residuo;
				saldo = 0;
			}
		} else {
			super.consignarDinero(cantidad); /* Si no hay sobregiro, se realiza una consignaci�n normal */
		}
	}
	public void extractoMensual() {
		super.extractoMensual(); // Invoca al metodo de la clase padre
	}
	public void imprimir() {
		System.out.println("Saldo = $ " + saldo);
		System.out.println("Cargo mensual = $ " + comisionM);
		System.out.println("Numero de transacciones = " + (nConsignaciones + nRetiros));
		System.out.println("Valor de sogregiro = $" + (nConsignaciones + nRetiros));
		System.out.println();
	}
}
