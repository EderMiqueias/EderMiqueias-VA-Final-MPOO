package model;

import java.util.ArrayList;

public class BaseDados {
	private static ArrayList<Pessoa> usuarios;
	
	public static void inicializarBase() {
		usuarios = new ArrayList<Pessoa>();
	}

	public ArrayList<Pessoa> getUsuarios() {
		return usuarios;
	}

}
