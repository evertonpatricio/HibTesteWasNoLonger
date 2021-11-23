package filter;

import java.util.Date;

import enums.TipoParticipante;
import pojo.FaseFunilVendas;

public class ParticipanteFilter {
	
	private Long id;
	private String nomeRazaoSocial;
	private String apelidoFantasia;
	private String cpfCnpj;
	private Date dataCadastroInicial;
	private Date dataCadastroFinal;
	private String participantesSemSetor;
	private TipoParticipante tipoParticipante = TipoParticipante.CLIENTE;
	private FaseFunilVendas faseFunilVendas;
	private boolean prospects;
	private String email;
	private String senha;
	private boolean persona;
	
	private int primeiroRegistro;
	private int quantidadeRegistros;
	private String propriedadeOrdenacao;
	private boolean ascendente;
	
	
	public String getNomeRazaoSocial(){
		return nomeRazaoSocial;
	}
	
	public void setNomeRazaoSocial(String nomeRazaoSocial) {
		this.nomeRazaoSocial = nomeRazaoSocial;
	}
	
	public String getApelidoFantasia() {
		return apelidoFantasia;
	}
	
	public void setApelidoFantasia(String apelidoFantasia) {
		this.apelidoFantasia = apelidoFantasia;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}
	
	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}
	
	public Date getDataCadastroInicial() {
		return dataCadastroInicial;
	}

	public void setDataCadastroInicial(Date dataCadastroInicial) {
		this.dataCadastroInicial = dataCadastroInicial;
	}

	public Date getDataCadastroFinal() {
		return dataCadastroFinal;
	}

	public void setDataCadastroFinal(Date dataCadastroFinal) {
		this.dataCadastroFinal = dataCadastroFinal;
	}

	public String getParticipantesSemSetor() {
		return participantesSemSetor;
	}
	
	public void setParticipantesSemSetor(String participantesSemSetor) {
		this.participantesSemSetor = participantesSemSetor;
	}

	public TipoParticipante getTipoParticipante() {
		return tipoParticipante;
	}

	public void setTipoParticipante(TipoParticipante tipoParticipante) {
		this.tipoParticipante = tipoParticipante;
	}

	public FaseFunilVendas getFaseFunilVendas() {
		return faseFunilVendas;
	}

	public void setFaseFunilVendas(FaseFunilVendas faseFunilVendas) {
		this.faseFunilVendas = faseFunilVendas;
	}

	public boolean isProspects() {
		return prospects;
	}

	public void setProspects(boolean prospects) {
		this.prospects = prospects;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean isPersona() {
		return persona;
	}

	public void setPersona(boolean persona) {
		this.persona = persona;
	}

	public int getPrimeiroRegistro() {
		return primeiroRegistro;
	}

	public void setPrimeiroRegistro(int primeiroRegistro) {
		this.primeiroRegistro = primeiroRegistro;
	}

	public int getQuantidadeRegistros() {
		return quantidadeRegistros;
	}

	public void setQuantidadeRegistros(int quantidadeRegistros) {
		this.quantidadeRegistros = quantidadeRegistros;
	}

	public String getPropriedadeOrdenacao() {
		return propriedadeOrdenacao;
	}

	public void setPropriedadeOrdenacao(String propriedadeOrdenacao) {
		this.propriedadeOrdenacao = propriedadeOrdenacao;
	}

	public boolean isAscendente() {
		return ascendente;
	}

	public void setAscendente(boolean ascendente) {
		this.ascendente = ascendente;
	}
}
