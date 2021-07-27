package app;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import controller.Controller;
import model.Endereco;
import model.PessoaException;
import model.SuperUsuario;
import model.Usuario;
import view.TelaAplicacao;

public class App extends Thread {
	Controller controller;
	TelaAplicacao tela;

	public static void main(String[] args) {
		
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		}
		catch (UnsupportedLookAndFeelException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		new App().start();;
		
	}
	
	public void run() {
		synchronized (this) {
			SuperUsuario administrador = new SuperUsuario(null, null, "admin", "admin", null);
			this.controller = new Controller(administrador);
			
//			"Sem a utilização de telas e exibição em console:"
//			Professor, essa frase não fez sentido pra mim, se não é pra exibir
//			em telas nem no console, onde então?
			try {
				administrador.adicionarPessoa(new Usuario("444.111.333-21", "masculino", "Eder", "123",
						new Endereco("Rua da Santa", 21, "centro", "manaira", "pb")));
				
				Endereco zeAdress = new Endereco("Rua do estudo", 10, "Bairro do desespero", "aleluia", "es");
				administrador.adicionarPessoa(new Usuario("111.111.111-11", "masculino", "ze", "123", zeAdress));
				administrador.adicionarPessoa(new Usuario("111.111.111-11", "masculino", "ze", "123", zeAdress));

			} catch (PessoaException e1) {
				e1.printStackTrace();
			}
			
			while (true) {
				try {
					Thread.sleep(60000);
				}
				catch (InterruptedException e) {
					JOptionPane.showMessageDialog(null, "Erro ao executar!");
					System.exit(0);
				}
				this.controller.exibirUsuarios();
			}
		}
	}
}
