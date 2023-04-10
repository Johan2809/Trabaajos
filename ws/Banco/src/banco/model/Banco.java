package banco.model;
import java.util.ArrayList;
import java.util.List;

import banco.model.Cuenta;

public class Banco {
	String nombre;
	List<Cuenta>listaCuentas = new ArrayList<Cuenta>();
	List<Cliente>listaClientes = new ArrayList<Cliente>();

	public Banco() {

	}

	public Banco(String nombre, List<Cuenta> listaCuentas, List<Cliente> listaClientes) {
		super();
		this.nombre = nombre;
		this.listaCuentas = listaCuentas;
		this.listaClientes = listaClientes;
	}



	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Cuenta> getListaCuentas() {
		return listaCuentas;
	}

	public void setListaCuentas(List<Cuenta> listaCuentas) {
		this.listaCuentas = listaCuentas;
	}

	public List<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}





}
