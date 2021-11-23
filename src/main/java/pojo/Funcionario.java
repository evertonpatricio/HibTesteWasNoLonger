package pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import enums.Sexo;
import enums.TipoBairro;

@Entity
public class Funcionario implements Serializable{
	
	private static final long serialVersionUID = 1L;
	// Informações iniciais
	private Long id;
	private String nome;
	private String apelido;
	private String cargo;

	// Dados do endereço
	private String cep;
	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	private String tempoNesteEndereco;
	private TipoBairro tipoBairro;
	private Municipio municipio;

	// Documentação
	private String cpf;
	private String rg;
	private String orgaoExpeditor;
	private Date dataEmissaoRg;
	private String naturalidade;
	private Date dataNascimento;
	private Sexo sexo;
	private String conjuge;
	private String tempoConjuge;
	private Date dataCadastro;

	// Informações de contato
	private String telefone01;
	private String obsTelefone01;
	private String telefone02;
	private String obsTelefone02;
	private String telefone03;
	private String obsTelefone03;
	private String telefone04;
	private String obsTelefone04;
	private String telefone05;
	private String obsTelefone05;
	private String email;

	private String nivelAutorizacao;
	
	private boolean ativo = true;
	private String nomeUsuario;
	private Date dataInativacao;
	private Date horaInativacao;

	@Id
	@Column(name = "id")
	@GeneratedValue(generator = "funcionarioid_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "funcionarioid_seq", sequenceName = "funcionarioid_seq", allocationSize = 1)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "nome", length = 80)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name = "apelido", length = 20)
	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	@Column(name = "cargo", length = 20)
	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	@Column(name = "cep", length = 10)
	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	@Column(name = "logradouro", length = 100)
	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	@Column(name = "numero", length = 4)
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	@Column(name = "complemento", length = 80)
	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	@Column(name = "bairro", length = 50)
	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	@Column(name = "tempo_neste_endereco", length = 50)
	public String getTempoNesteEndereco() {
		return tempoNesteEndereco;
	}

	public void setTempoNesteEndereco(String tempoNesteEndereco) {
		this.tempoNesteEndereco = tempoNesteEndereco;
	}
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_bairro", length = 20)
	public TipoBairro getTipoBairro() {
		return tipoBairro;
	}

	public void setTipoBairro(TipoBairro tipoBairro) {
		this.tipoBairro = tipoBairro;
	}

	@ManyToOne
	@JoinColumn(name = "municipio_id")
	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	@Column(name = "cpf", length = 20)
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Column(name = "rg", length = 20)
	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	@Column(name = "orgao_expedidor", length = 60)
	public String getOrgaoExpeditor() {
		return orgaoExpeditor;
	}

	public void setOrgaoExpeditor(String orgaoExpeditor) {
		this.orgaoExpeditor = orgaoExpeditor;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "data_emissao_rg")
	public Date getDataEmissaoRg() {
		return dataEmissaoRg;
	}

	public void setDataEmissaoRg(Date dataEmissaoRg) {
		this.dataEmissaoRg = dataEmissaoRg;
	}

	@Column(name = "naturalidade", length = 100)
	public String getNaturalidade() {
		return naturalidade;
	}

	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "data_nascimento")
	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	@Enumerated(EnumType.STRING)
	@Column(name = "sexo", length = 10)
	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	@Column(name = "conjuge", length = 100)
	public String getConjuge() {
		return conjuge;
	}

	public void setConjuge(String conjuge) {
		this.conjuge = conjuge;
	}

	@Column(name = "tempo_conjuge", length = 3)
	public String getTempoConjuge() {
		return tempoConjuge;
	}

	public void setTempoConjuge(String tempoConjuge) {
		this.tempoConjuge = tempoConjuge;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "data_cadastro")
	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	@Column(name = "telefone_01", length = 20)
	public String getTelefone01() {
		return telefone01;
	}

	public void setTelefone01(String telefone01) {
		this.telefone01 = telefone01;
	}

	@Column(name = "obs_telefone_01", length = 100)
	public String getObsTelefone01() {
		return obsTelefone01;
	}

	public void setObsTelefone01(String obsTelefone01) {
		this.obsTelefone01 = obsTelefone01;
	}

	@Column(name = "telefone_02", length = 20)
	public String getTelefone02() {
		return telefone02;
	}

	public void setTelefone02(String telefone02) {
		this.telefone02 = telefone02;
	}

	@Column(name = "obs_telefone_02", length = 100)
	public String getObsTelefone02() {
		return obsTelefone02;
	}

	public void setObsTelefone02(String obsTelefone02) {
		this.obsTelefone02 = obsTelefone02;
	}

	@Column(name = "telefone_03", length = 20)
	public String getTelefone03() {
		return telefone03;
	}

	public void setTelefone03(String telefone03) {
		this.telefone03 = telefone03;
	}

	@Column(name = "obs_telefone_03", length = 100)
	public String getObsTelefone03() {
		return obsTelefone03;
	}

	public void setObsTelefone03(String obsTelefone03) {
		this.obsTelefone03 = obsTelefone03;
	}

	@Column(name = "telefone_04", length = 20)
	public String getTelefone04() {
		return telefone04;
	}

	public void setTelefone04(String telefone04) {
		this.telefone04 = telefone04;
	}

	@Column(name = "obs_telefone_04", length = 100)
	public String getObsTelefone04() {
		return obsTelefone04;
	}

	public void setObsTelefone04(String obsTelefone04) {
		this.obsTelefone04 = obsTelefone04;
	}

	@Column(name = "telefone_05", length = 20)
	public String getTelefone05() {
		return telefone05;
	}

	public void setTelefone05(String telefone05) {
		this.telefone05 = telefone05;
	}

	@Column(name = "obs_telefone_05", length = 100)
	public String getObsTelefone05() {
		return obsTelefone05;
	}

	public void setObsTelefone05(String obsTelefone05) {
		this.obsTelefone05 = obsTelefone05;
	}

	@Column(name = "email", length = 100)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "nivel_autorizacao", length = 100)
	public String getNivelAutorizacao() {
		return nivelAutorizacao;
	}

	public void setNivelAutorizacao(String nivelAutorizacao) {
		this.nivelAutorizacao = nivelAutorizacao;
	}
	
	@Column(name = "ativo")
	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	@Column(name = "nomeUsuario")
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "data_inativacao")
	public Date getDataInativacao() {
		return dataInativacao;
	}

	public void setDataInativacao(Date dataInativacao) {
		this.dataInativacao = dataInativacao;
	}

	@Temporal(TemporalType.TIME)
	@Column(name = "hora_inativacao")
	public Date getHoraInativacao() {
		return horaInativacao;
	}

	public void setHoraInativacao(Date horaInativacao) {
		this.horaInativacao = horaInativacao;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
