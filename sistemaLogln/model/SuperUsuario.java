package model;

public class SuperUsuario extends Usuario implements BaseManaged{
	private BaseDados baseDados;

	public SuperUsuario(String cpf, String sexo, String login, String senha, Endereco endereco) {
		super(cpf, sexo, login, senha, endereco);
		this.baseDados = new BaseDados();
	}
	
	public boolean haPessoas() {
		if (this.baseDados.getUsuarios().size() > 0)
			return true;
		return false;
	}
	
	public void inicializaBase() {
		BaseDados.inicializarBase();
	}
	
	public String pessoasToString() {
		return this.baseDados.getUsuarios().toString();
	}

	@Override
	public Pessoa buscarPessoa(String cpf) {
		for(Pessoa pessoa : this.baseDados.getUsuarios()) {
			if (pessoa.getCpf() == cpf)
				return pessoa;
		}
		return null;
	}

	@Override
	public boolean isPessoa(Pessoa pessoa) throws PessoaException {
		if(pessoa == null) {
			throw new PessoaException(TipoErro.NULL_USUARIO);
		}
		return this.baseDados.getUsuarios().contains(this.buscarPessoa(pessoa.getCpf()));
	}

	@Override
	public boolean adicionarPessoa(Pessoa pessoa) throws PessoaException {
		if (this.isPessoa(pessoa)) {
			throw new PessoaException(TipoErro.EXISTE_USUARIO);
		}
		return this.baseDados.getUsuarios().add(pessoa);
	}

	@Override
	public boolean removerPessoa(Pessoa pessoa) throws PessoaException {
		if (!this.isPessoa(pessoa)) {
			throw new PessoaException(TipoErro.NAO_EXISTE_USUARIO);
		}
		return this.baseDados.getUsuarios().remove(this.buscarPessoa(pessoa.getCpf()));
	}

	@Override
	public boolean atualizarPessoa(Pessoa pessoaOld, Pessoa pessoaNew) throws PessoaException {
		if (!this.isPessoa(pessoaOld)) {
			throw new PessoaException(TipoErro.NAO_EXISTE_USUARIO);
		}
		if (this.isPessoa(pessoaNew)) {
			throw new PessoaException(TipoErro.EXISTE_USUARIO);
		}
		
		this.baseDados.getUsuarios().set(
				this.baseDados.getUsuarios().indexOf(this.buscarPessoa(pessoaOld.getCpf())),
				pessoaNew
		);
		return true;
	}
}
