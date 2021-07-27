package model;

public interface BaseManaged {

	public Pessoa buscarPessoa(String cpf);
	public boolean isPessoa(Pessoa pessoa) throws PessoaException;
	public boolean adicionarPessoa(Pessoa pessoa) throws PessoaException;
	public boolean removerPessoa(Pessoa pessoa) throws PessoaException;
	public boolean atualizarPessoa(Pessoa pessoaOld, Pessoa pessoaNew) throws PessoaException;
}
