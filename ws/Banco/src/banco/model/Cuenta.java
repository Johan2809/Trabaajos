package banco.model;
import banco.exceptions.CuentaExceptions;

public abstract class Cuenta {
	 protected float saldo;
	 protected int nConsignaciones;
	 protected int nRetiros;
	 protected float tasaAnual;
	 protected float comisionM;

	public Cuenta(float saldo, float tasaAnual) {
		super();
		this.saldo = saldo;
		this.nConsignaciones = 0;
		this.nRetiros = 0;
		this.tasaAnual = tasaAnual;
		this.comisionM = 0;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public int getnConsignaciones() {
		return nConsignaciones;
	}

	public void setnConsignaciones(int nConsignaciones) {
		this.nConsignaciones = nConsignaciones;
	}

	public int getnRetiros() {
		return nRetiros;
	}

	public void setnRetiros(int nRetiros) {
		this.nRetiros = nRetiros;
	}

	public float getTasaAnual() {
		return tasaAnual;
	}

	public void setTasaAnual(float tasaAnual) {
		this.tasaAnual = tasaAnual;
	}

	public float getComisionM() {
		return comisionM;
	}

	public void setComisionM(float comisionM) {
		this.comisionM = comisionM;
	}

	public void consignarDinero(double valor) throws CuentaExceptions {
        if (valor <= 0) {
            throw new CuentaExceptions("El valor a consignar debe ser mayor 0");
        }
        saldo += valor;
        setnConsignaciones(getnConsignaciones()+1);
    }

	public double retirarDinero(double valor) throws CuentaExceptions {
		if (valor <= 0) {
			throw new CuentaExceptions("El valor a retirar debe ser mayor a 0");
		}
		if (valor > saldo) {
			throw new CuentaExceptions("No se puede retirar. Saldo insuficiente.");
		}
		saldo -= valor;
		setSaldo(saldo);
		setnConsignaciones(getnConsignaciones()+1);
		return saldo;
	}
	public double calcularInteresMensual() {
        double interesMensual = saldo * (tasaAnual / 12);
        saldo += interesMensual;
        setSaldo(saldo);
        return saldo;
    }
	public void extractoMensual(){
		saldo= saldo-comisionM;
		calcularInteresMensual();
	}
}
