package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.PessoaException;
import model.SuperUsuario;
import model.Usuario;
import view.TelaAplicacao;
import view.TelaMensagem;

public class Controller {
	private TelaAplicacao telaAplicacao;
	private String sexoSelecionado = "Masculino";
	private SuperUsuario administrador;

	public Controller(SuperUsuario administrador) {
		this.administrador = administrador;
		this.administrador.inicializaBase();
		this.telaAplicacao = new TelaAplicacao();

		this.telaAplicacao.novoButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Controller.this.telaAplicacao.showNovoFields();
			}
		});

		this.telaAplicacao.loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Controller.this.telaAplicacao.showLoginFields();
			}
		});

		this.telaAplicacao.addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Controller.this.criarUsuario();
				} catch (CampoVazioException e2) {
					Controller.this.showAlert(e2.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		this.telaAplicacao.removeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Controller.this.removerUsuario();
			}
		});

		this.telaAplicacao.showButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Controller.this.exibirUsuarios();
			}
		});

		this.telaAplicacao.sairButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		this.telaAplicacao.hideAllFields();
		this.telaAplicacao.setVisible(true);

	}

	public void criarUsuario() throws CampoVazioException {
//		Professor, e o cpf? se o usuário não informar seu cpf como posso saber?
//		vendo isto, criei um campo cpf adicional, também pensei em criar
//		um gerador de cpfs ficticios, mas acho que não seria legal
		if (this.telaAplicacao.cpfField.getText() == "" ||
				this.telaAplicacao.loginField.getText() == "" ||
				new String(this.telaAplicacao.senhaField.getPassword()) == ""
		) {
			throw new CampoVazioException("Erro ao criar usuario. preencha todos os campos");
		}
		Usuario usuario = new Usuario(
				this.telaAplicacao.cpfField.getText(),
				this.sexoSelecionado,
				this.telaAplicacao.loginField.getText(),
				new String(this.telaAplicacao.senhaField.getPassword()),
				null
		);

		try {
			this.administrador.adicionarPessoa(usuario);
			this.showAlert("Usuario criado com sucesso", "Sucesso", JOptionPane.DEFAULT_OPTION);
		} catch (PessoaException e) {
			this.showAlert(e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void removerUsuario() {
		Usuario usuario = new Usuario(
				this.telaAplicacao.cpfField.getText(),
				this.sexoSelecionado,
				this.telaAplicacao.loginField.getText(),
				new String(this.telaAplicacao.senhaField.getPassword()),
				null
		);

		try {
			this.administrador.removerPessoa(usuario);
			this.showAlert("Usuario removido com sucesso", "Sucesso", JOptionPane.DEFAULT_OPTION);
		} catch (PessoaException e) {
			this.showAlert(e.getMessage(), "Erro ao remover usuario!", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void exibirUsuarios() {
		if(this.administrador.haPessoas()) {
			this.showAlert(this.administrador.pessoasToString(), "Usuarios cadastrados", JOptionPane.NO_OPTION);
		}
		else {
			this.showAlert("não existem usuários", "Usuarios cadastrados", JOptionPane.NO_OPTION);
		}

	}

	private void showAlert(String msg, String title, int operation) {
		new TelaMensagem(msg, title, operation);
	}

}
