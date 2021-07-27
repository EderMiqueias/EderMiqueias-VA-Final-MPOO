package model;

public class Usuario extends Pessoa {

	private String login;
	private String senha;
	private Endereco endereco;
	
	public Usuario(String cpf, String sexo, String login, String senha, Endereco endereco) {
		super(cpf, sexo);
		this.login = login;
		this.senha = senha;
		this.setEndereco(endereco);
	}
	
	@Override
	public String toString() {
		return "Usuario [login=" + login + ", senha=" + senha + ", getCpf()=" + getCpf() + ", getSexo()=" + getSexo()
				+ "]";
	}

	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
}
