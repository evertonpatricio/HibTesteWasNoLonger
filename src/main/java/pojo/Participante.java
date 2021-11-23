package pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import enums.Sexo;
import enums.TipoBairro;
import enums.TipoContribuinte;
import enums.TipoParticipante;
import enums.TipoPessoa;

@Entity
public class Participante implements Serializable{

	private static final long serialVersionUID = 1L;
	// Informações iniciais
	private Long id;
	private TipoParticipante tipoParticipante = TipoParticipante.CLIENTE;
	private TipoPessoa tipoPessoa = TipoPessoa.FISICA;
	private TipoContribuinte tipoContribuinte;
	private String nomeRazaoSocial;
	private String apelidoFantasia;
    private Integer indicadorIe;

	// Documentação
	private String cpfCnpj;
	private String rg;
	private String orgaoExpeditor;
	private Date dataEmissaoRg;
	private String inscricaoEstadual;
	private String inscricaoMunicipal;
	private String naturalidade;
	private Date dataNascimento;
	private Sexo sexo;
	private String conjuge;
	private String tempoConjuge;
	private Date dataCadastro;

	// Dados do endereço
	private String cep;
	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	private SetorEndereco setor;
	private String tempoNesteEndereco;
	private TipoBairro tipoBairro;
	private Municipio municipio;

	// Dados do endereço anterior
	private String cepAnterior;
	private String logradouroAnterior;
	private String numeroAnterior;
	private String complementoAnterior;
	private TipoBairro tipoBairroAnterior;
	private String bairroAnterior;
	private SetorEndereco setorAnterior;
	private String tempoNesteEnderecoAnterior;

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

	// Dados Comerciais
	private String empresaOndeTrabalha;
	private String profissao;
	private BigDecimal remuneracao;
	private String cepComercial;
	private String logradouroComercial;
	private String numeroComercial;
	private String complementoComercial;
	private TipoBairro tipoBairroComercial;
	private String bairroComercial;
	private String telefoneComercial01;
	private String obsTelefoneComercial01;
	private String telefoneComercial02;
	private String obsTelefoneComercial02;

	// Dados da filiação
	private String nomePai;
	private String nomeMae;
	private String cepFiliacao;
	private String logradouroFiliacao;
	private String numeroFiliacao;
	private String complementoFiliacao;
	private TipoBairro tipoBairroFiliacao;
	private String bairroFiliacao;
	private String telefoneFiliacao01;
	private String obsTelefoneFiliacao01;
	private String telefoneFiliacao02;
	private String obsTelefoneFiliacao02;
	private String emailFiliacao;
	private String profissaoFiliacao;
	private BigDecimal remuneracaoFiliacao;
	//Não serão mais utilizados, pois só tem o endereço comercial da filiação, 
	//quando é necessário ter as informações comercias do pai e da mãe
	private String cepComercialFiliacao;
	private String logradouroComercialFiliacao;
	private String numeroComercialFiliacao;
	private String complementoComercialFiliacao;
	private TipoBairro tipoBairroComercialFiliacao;
	private String bairroComercialFiliacao;
	//Novas informações do endereço comercial da filiação
	//Ahh, antes disso, devemos levar em conta que o cadastro do cliente é tudo. 
	//Logo, é necessário identificar se os pais ainda são vivos, se não, qual deles ainda continua vivo.
	//Se os dois forem vivos, verificar se os dois são casados. Se forem, aparecer somente um dado de endereço (endereço da filiação).
	//Se não, aparecer os dados de dois endereços (endereço pai e endereço mãe).
	
	//Colocar também as outras informações, como idade, estilo musical, renda mensal, etc, etc.
	//Ou seria melhor colcoar essas informações na definição da persona?

	// Dados básicos do avalista
	private String nomeAvalista;
	private String cepAvalista;
	private String logradouroAvalista;
	private String numeroAvalista;
	private String complementoAvalista;
	private TipoBairro tipoBairroAvalista;
	private String bairroAvalista;
	private Municipio municipioAvalista;
	
	// Dados de contato do avalista
	private String telefoneAvalista01;
	private String obsTelefoneAvalista01;
	private String telefoneAvalista02;
	private String obsTelefoneAvalista02;
	
	// Dados comerciais do avalista
	private String profissaoAvalista;
	private BigDecimal remuneracaoAvalista;
	private String empresaOndeTrabalhaAvalista;
	private String cepComercialAvalista;
	private String logradouroComercialAvalista;
	private String numeroComercialAvalista;
	private String complementoComercialAvalista;
	private TipoBairro tipoBairroComercialAvalista;
	private String bairroComercialAvalista;
	private String telefoneComercial01Avalista;
	
	// Dados da filiação do avalista
	private String nomePaiAvalista;
	private String nomeMaeAvalista;

	// Dados adicionais
	private BigDecimal limiteCredito;
	private BigDecimal saldoCredito;
	private String referenciaOndeComprou01;
	private String referenciaOndeComprou02;
	private String referenciaOndeComprou03;

	// Informações fiscais específicas
	private boolean informaIssDigital;
	private boolean informaDief;
	private boolean informaDic;
	private boolean informaDemms;
	private boolean orgaoPublico;
	private boolean informaLivroEletronico;
	private boolean sociedadeSimples;
	private boolean substitutoIss;
	private boolean isentoIcms;
	private boolean fornecedorProdutoPrimario;

	// Colcar apenas um campo de obs, do tipo text.
	private String obs;
	
	private List<Equipamento> equipamentos = new ArrayList<>();
	
	private boolean ativo = true;
	private String nomeUsuario;
	private Date dataInativacao;
	private Date horaInativacao;
	
	private boolean inadimplente;
	private boolean bloqueado;
	private boolean especial;
	private boolean revenda;
	
	private boolean spc;
	private String motivoSpc;
	
	private boolean serasa;
	private String motivoSerasa;
	private FaseFunilVendas fase;
	private Persona persona;
	private List<Acao> acoes = new ArrayList<Acao>();
	
	private boolean emTreinamento;
	
	private String segmento = "Comércio Geral";
	private String nivel = "Básico";
	private boolean usaFiscal;
	private boolean pafEcef;
	private boolean nfe;
	private boolean nfce;
	private boolean mfe;
	private boolean satCf;
	
	private String diaPagamentoMensalidade;
	private BigDecimal valorMensalidade = BigDecimal.ZERO;
	
	private String referencia;
	
	
	@Id
	@Column(name = "id")
	@GeneratedValue(generator = "participante_id_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "participante_id_seq", sequenceName = "participante_id_seq", allocationSize = 1)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_participante", length = 10)
	public TipoParticipante getTipoParticipante() {
		return tipoParticipante;
	}

	public void setTipoParticipante(TipoParticipante tipoParticipante) {
		this.tipoParticipante = tipoParticipante;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_pessoa", length = 8)
	public TipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(TipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_contribuinte", length = 20)
	public TipoContribuinte getTipoContribuinte() {
		return tipoContribuinte;
	}

	public void setTipoContribuinte(TipoContribuinte tipoContribuinte) {
		this.tipoContribuinte = tipoContribuinte;
	}

	@Column(name = "nome_razao_social", length = 100)
	public String getNomeRazaoSocial() {
		return nomeRazaoSocial;
	}

	public void setNomeRazaoSocial(String nomeRazaoSocial) {
		this.nomeRazaoSocial = nomeRazaoSocial;
	}

	@Column(name = "apelido_fantasia", length = 100)
	public String getApelidoFantasia() {
		return apelidoFantasia;
	}

	public void setApelidoFantasia(String apelidoFantasia) {
		this.apelidoFantasia = apelidoFantasia;
	}
	
	@Column(name = "indicador_ie")
	public Integer getIndicadorIe() {
		return indicadorIe;
	}

	public void setIndicadorIe(Integer indicadorIe) {
		this.indicadorIe = indicadorIe;
	}

	@Column(name = "cpf_cnpj", length = 14)
	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	@Column(name = "rg", length = 20)
	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	@Column(name = "orgao_expeditor", length = 20)
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

	@Column(name = "inscricao_estadual", length = 30)
	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	@Column(name = "inscricao_municipal", length = 30)
	public String getInscricaoMunicipal() {
		return inscricaoMunicipal;
	}

	public void setInscricaoMunicipal(String inscricaoMunicipal) {
		this.inscricaoMunicipal = inscricaoMunicipal;
	}

	@Column(name = "naturalidade", length = 50)
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

	@Column(name = "conuge", length = 100)
	public String getConjuge() {
		return conjuge;
	}

	public void setConjuge(String conjuge) {
		this.conjuge = conjuge;
	}

	@Column(name = "tempo_conjuge", length = 20)
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

	@Column(name = "numero", length = 10)
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	@Column(name = "complemento", length = 30)
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "setor_id")
	public SetorEndereco getSetor() {
		return setor;
	}

	public void setSetor(SetorEndereco setor) {
		this.setor = setor;
	}

	@Column(name = "tempo_neste_endereco", length = 20)
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
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "municipio_id")
	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	@Column(name = "cep_anterior", length = 10)
	public String getCepAnterior() {
		return cepAnterior;
	}

	public void setCepAnterior(String cepAnterior) {
		this.cepAnterior = cepAnterior;
	}

	@Column(name = "logradouro_anterior", length = 100)
	public String getLogradouroAnterior() {
		return logradouroAnterior;
	}

	public void setLogradouroAnterior(String logradouroAnterior) {
		this.logradouroAnterior = logradouroAnterior;
	}

	@Column(name = "numero_anterior", length = 10)
	public String getNumeroAnterior() {
		return numeroAnterior;
	}

	public void setNumeroAnterior(String numeroAnterior) {
		this.numeroAnterior = numeroAnterior;
	}

	@Column(name = "complemento_anterior", length = 30)
	public String getComplementoAnterior() {
		return complementoAnterior;
	}

	public void setComplementoAnterior(String complementoAnterior) {
		this.complementoAnterior = complementoAnterior;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_bairro_anterior", length = 20)
	public TipoBairro getTipoBairroAnterior() {
		return tipoBairroAnterior;
	}

	public void setTipoBairroAnterior(TipoBairro tipoBairroAnterior) {
		this.tipoBairroAnterior = tipoBairroAnterior;
	}

	@Column(name = "bairro_anterior", length = 50)
	public String getBairroAnterior() {
		return bairroAnterior;
	}

	public void setBairroAnterior(String bairroAnterior) {
		this.bairroAnterior = bairroAnterior;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "setor_anterior_id")
	public SetorEndereco getSetorAnterior() {
		return setorAnterior;
	}

	public void setSetorAnterior(SetorEndereco setorAnterior) {
		this.setorAnterior = setorAnterior;
	}

	@Column(name = "tempo_neste_endereco_anterior", length = 20)
	public String getTempoNesteEnderecoAnterior() {
		return tempoNesteEnderecoAnterior;
	}

	public void setTempoNesteEnderecoAnterior(String tempoNesteEnderecoAnterior) {
		this.tempoNesteEnderecoAnterior = tempoNesteEnderecoAnterior;
	}

	@Column(name = "telefone_01", length = 20)
	public String getTelefone01() {
		return telefone01;
	}

	public void setTelefone01(String telefone01) {
		this.telefone01 = telefone01;
	}

	@Column(name = "obs_telefone_01", length = 20)
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

	@Column(name = "obs_telefone_02", length = 20)
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

	@Column(name = "obs_telefone_03", length = 20)
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

	@Column(name = "obs_telefone_04", length = 20)
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

	@Column(name = "obs_telefone_05", length = 20)
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

	@Column(name = "empresa_onde_trabalha", length = 120)
	public String getEmpresaOndeTrabalha() {
		return empresaOndeTrabalha;
	}

	public void setEmpresaOndeTrabalha(String empresaOndeTrabalha) {
		this.empresaOndeTrabalha = empresaOndeTrabalha;
	}

	@Column(name = "profissao", length = 30)
	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	@Column(name = "remuneracao", precision = 18, scale = 4)
	public BigDecimal getRemuneracao() {
		return remuneracao;
	}

	public void setRemuneracao(BigDecimal remuneracao) {
		this.remuneracao = remuneracao;
	}

	@Column(name = "cep_comercial", length = 10)
	public String getCepComercial() {
		return cepComercial;
	}

	public void setCepComercial(String cepComercial) {
		this.cepComercial = cepComercial;
	}

	@Column(name = "logradouro_comercial", length = 100)
	public String getLogradouroComercial() {
		return logradouroComercial;
	}

	public void setLogradouroComercial(String logradouroComercial) {
		this.logradouroComercial = logradouroComercial;
	}

	@Column(name = "numero_comercial", length = 10)
	public String getNumeroComercial() {
		return numeroComercial;
	}

	public void setNumeroComercial(String numeroComercial) {
		this.numeroComercial = numeroComercial;
	}

	@Column(name = "complemento_comercial", length = 30)
	public String getComplementoComercial() {
		return complementoComercial;
	}

	public void setComplementoComercial(String complementoComercial) {
		this.complementoComercial = complementoComercial;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_bairro_comercial", length = 20)
	public TipoBairro getTipoBairroComercial() {
		return tipoBairroComercial;
	}

	public void setTipoBairroComercial(TipoBairro tipoBairroComercial) {
		this.tipoBairroComercial = tipoBairroComercial;
	}

	@Column(name = "bairro_comercial", length = 50)
	public String getBairroComercial() {
		return bairroComercial;
	}

	public void setBairroComercial(String bairroComercial) {
		this.bairroComercial = bairroComercial;
	}

	@Column(name = "telefone_comercial_01", length = 20)
	public String getTelefoneComercial01() {
		return telefoneComercial01;
	}

	public void setTelefoneComercial01(String telefoneComercial01) {
		this.telefoneComercial01 = telefoneComercial01;
	}

	@Column(name = "obs_telefone_comercial_01", length = 20)
	public String getObsTelefoneComercial01() {
		return obsTelefoneComercial01;
	}

	public void setObsTelefoneComercial01(String obsTelefoneComercial01) {
		this.obsTelefoneComercial01 = obsTelefoneComercial01;
	}

	@Column(name = "telefone_comercial_02", length = 20)
	public String getTelefoneComercial02() {
		return telefoneComercial02;
	}

	public void setTelefoneComercial02(String telefoneComercial02) {
		this.telefoneComercial02 = telefoneComercial02;
	}

	@Column(name = "obs_telefone_comercial_02", length = 20)
	public String getObsTelefoneComercial02() {
		return obsTelefoneComercial02;
	}

	public void setObsTelefoneComercial02(String obsTelefoneComercial02) {
		this.obsTelefoneComercial02 = obsTelefoneComercial02;
	}

	@Column(name = "nome_pai", length = 100)
	public String getNomePai() {
		return nomePai;
	}

	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}

	@Column(name = "nome_mae", length = 100)
	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	@Column(name = "cep_filiacao", length = 10)
	public String getCepFiliacao() {
		return cepFiliacao;
	}

	public void setCepFiliacao(String cepFiliacao) {
		this.cepFiliacao = cepFiliacao;
	}

	@Column(name = "logradouro_filiacao", length = 100)
	public String getLogradouroFiliacao() {
		return logradouroFiliacao;
	}

	public void setLogradouroFiliacao(String logradouroFiliacao) {
		this.logradouroFiliacao = logradouroFiliacao;
	}

	@Column(name = "numero_filiacao", length = 10)
	public String getNumeroFiliacao() {
		return numeroFiliacao;
	}

	public void setNumeroFiliacao(String numeroFiliacao) {
		this.numeroFiliacao = numeroFiliacao;
	}

	@Column(name = "complemento_filiacao", length = 30)
	public String getComplementoFiliacao() {
		return complementoFiliacao;
	}

	public void setComplementoFiliacao(String complementoFiliacao) {
		this.complementoFiliacao = complementoFiliacao;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_bairro_filiacao", length = 20)
	public TipoBairro getTipoBairroFiliacao() {
		return tipoBairroFiliacao;
	}

	public void setTipoBairroFiliacao(TipoBairro tipoBairroFiliacao) {
		this.tipoBairroFiliacao = tipoBairroFiliacao;
	}

	@Column(name = "bairro_filiacao", length = 50)
	public String getBairroFiliacao() {
		return bairroFiliacao;
	}

	public void setBairroFiliacao(String bairroFiliacao) {
		this.bairroFiliacao = bairroFiliacao;
	}

	@Column(name = "telefone_filiacao_01", length = 20)
	public String getTelefoneFiliacao01() {
		return telefoneFiliacao01;
	}

	public void setTelefoneFiliacao01(String telefoneFiliacao01) {
		this.telefoneFiliacao01 = telefoneFiliacao01;
	}

	@Column(name = "obs_telefone_filiacao_01", length = 20)
	public String getObsTelefoneFiliacao01() {
		return obsTelefoneFiliacao01;
	}

	public void setObsTelefoneFiliacao01(String obsTelefoneFiliacao01) {
		this.obsTelefoneFiliacao01 = obsTelefoneFiliacao01;
	}

	@Column(name = "telefone_filiacao_02", length = 20)
	public String getTelefoneFiliacao02() {
		return telefoneFiliacao02;
	}

	public void setTelefoneFiliacao02(String telefoneFiliacao02) {
		this.telefoneFiliacao02 = telefoneFiliacao02;
	}

	@Column(name = "obs_telefone_filiacao_02", length = 20)
	public String getObsTelefoneFiliacao02() {
		return obsTelefoneFiliacao02;
	}

	public void setObsTelefoneFiliacao02(String obsTelefoneFiliacao02) {
		this.obsTelefoneFiliacao02 = obsTelefoneFiliacao02;
	}

	@Column(name = "email_filiacao")
	public String getEmailFiliacao() {
		return emailFiliacao;
	}

	public void setEmailFiliacao(String emailFiliacao) {
		this.emailFiliacao = emailFiliacao;
	}

	@Column(name = "profissao_filiacao", length = 30)
	public String getProfissaoFiliacao() {
		return profissaoFiliacao;
	}

	public void setProfissaoFiliacao(String profissaoFiliacao) {
		this.profissaoFiliacao = profissaoFiliacao;
	}

	@Column(name = "remuneracao_filiacao", precision = 18, scale = 4)
	public BigDecimal getRemuneracaoFiliacao() {
		return remuneracaoFiliacao;
	}

	public void setRemuneracaoFiliacao(BigDecimal remuneracaoFiliacao) {
		this.remuneracaoFiliacao = remuneracaoFiliacao;
	}

	@Column(name = "cep_comercial_filiacao", length = 10)
	public String getCepComercialFiliacao() {
		return cepComercialFiliacao;
	}

	public void setCepComercialFiliacao(String cepComercialFiliacao) {
		this.cepComercialFiliacao = cepComercialFiliacao;
	}

	@Column(name = "logradouro_comercial_filiacao", length = 100)
	public String getLogradouroComercialFiliacao() {
		return logradouroComercialFiliacao;
	}

	public void setLogradouroComercialFiliacao(String logradouroComercialFiliacao) {
		this.logradouroComercialFiliacao = logradouroComercialFiliacao;
	}

	@Column(name = "numero_comercial_filiacao", length = 10)
	public String getNumeroComercialFiliacao() {
		return numeroComercialFiliacao;
	}

	public void setNumeroComercialFiliacao(String numeroComercialFiliacao) {
		this.numeroComercialFiliacao = numeroComercialFiliacao;
	}

	@Column(name = "complemento_comercial_filiacao", length = 30)
	public String getComplementoComercialFiliacao() {
		return complementoComercialFiliacao;
	}

	public void setComplementoComercialFiliacao(String complementoComercialFiliacao) {
		this.complementoComercialFiliacao = complementoComercialFiliacao;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_bairro_comercial_filiacao", length = 20)
	public TipoBairro getTipoBairroComercialFiliacao() {
		return tipoBairroComercialFiliacao;
	}

	public void setTipoBairroComercialFiliacao(TipoBairro tipoBairroComercialFiliacao) {
		this.tipoBairroComercialFiliacao = tipoBairroComercialFiliacao;
	}

	@Column(name = "bairro_comercial_filiacao", length = 50)
	public String getBairroComercialFiliacao() {
		return bairroComercialFiliacao;
	}

	public void setBairroComercialFiliacao(String bairroComercialFiliacao) {
		this.bairroComercialFiliacao = bairroComercialFiliacao;
	}

	@Column(name = "nome_avalista", length = 100)
	public String getNomeAvalista() {
		return nomeAvalista;
	}

	public void setNomeAvalista(String nomeAvalista) {
		this.nomeAvalista = nomeAvalista;
	}

	@Column(name = "cep_avalista", length = 10)
	public String getCepAvalista() {
		return cepAvalista;
	}

	public void setCepAvalista(String cepAvalista) {
		this.cepAvalista = cepAvalista;
	}

	@Column(name = "logradouro_avalista", length = 100)
	public String getLogradouroAvalista() {
		return logradouroAvalista;
	}

	public void setLogradouroAvalista(String logradouroAvalista) {
		this.logradouroAvalista = logradouroAvalista;
	}

	@Column(name = "numero_avalista", length = 10)
	public String getNumeroAvalista() {
		return numeroAvalista;
	}

	public void setNumeroAvalista(String numeroAvalista) {
		this.numeroAvalista = numeroAvalista;
	}

	@Column(name = "complemento_avalista", length = 30)
	public String getComplementoAvalista() {
		return complementoAvalista;
	}

	public void setComplementoAvalista(String complementoAvalista) {
		this.complementoAvalista = complementoAvalista;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_bairro_avalista", length = 20)
	public TipoBairro getTipoBairroAvalista() {
		return tipoBairroAvalista;
	}

	public void setTipoBairroAvalista(TipoBairro tipoBairroAvalista) {
		this.tipoBairroAvalista = tipoBairroAvalista;
	}

	@Column(name = "bairro_avalista", length = 50)
	public String getBairroAvalista() {
		return bairroAvalista;
	}

	public void setBairroAvalista(String bairroAvalista) {
		this.bairroAvalista = bairroAvalista;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "municipio_avalista_id")
	public Municipio getMunicipioAvalista() {
		return municipioAvalista;
	}

	public void setMunicipioAvalista(Municipio municipioAvalista) {
		this.municipioAvalista = municipioAvalista;
	}

	@Column(name = "telefone_avalista_01", length = 20)
	public String getTelefoneAvalista01() {
		return telefoneAvalista01;
	}

	public void setTelefoneAvalista01(String telefoneAvalista01) {
		this.telefoneAvalista01 = telefoneAvalista01;
	}

	@Column(name = "obs_telefone_avalista_01", length = 20)
	public String getObsTelefoneAvalista01() {
		return obsTelefoneAvalista01;
	}

	public void setObsTelefoneAvalista01(String obsTelefoneAvalista01) {
		this.obsTelefoneAvalista01 = obsTelefoneAvalista01;
	}

	@Column(name = "telefone_avalista_02", length = 20)
	public String getTelefoneAvalista02() {
		return telefoneAvalista02;
	}

	public void setTelefoneAvalista02(String telefoneAvalista02) {
		this.telefoneAvalista02 = telefoneAvalista02;
	}

	@Column(name = "obs_telefone_avalista_02", length = 20)
	public String getObsTelefoneAvalista02() {
		return obsTelefoneAvalista02;
	}

	public void setObsTelefoneAvalista02(String obsTelefoneAvalista02) {
		this.obsTelefoneAvalista02 = obsTelefoneAvalista02;
	}

	@Column(name = "profissao_avalista", length = 30)
	public String getProfissaoAvalista() {
		return profissaoAvalista;
	}

	public void setProfissaoAvalista(String profissaoAvalista) {
		this.profissaoAvalista = profissaoAvalista;
	}

	@Column(name = "remuneracao_avalista", precision = 18, scale = 4)
	public BigDecimal getRemuneracaoAvalista() {
		return remuneracaoAvalista;
	}

	public void setRemuneracaoAvalista(BigDecimal remuneracaoAvalista) {
		this.remuneracaoAvalista = remuneracaoAvalista;
	}

	@Column(name = "empresa_onde_trabalha_avalista", length = 120)
	public String getEmpresaOndeTrabalhaAvalista() {
		return empresaOndeTrabalhaAvalista;
	}

	public void setEmpresaOndeTrabalhaAvalista(String empresaOndeTrabalhaAvalista) {
		this.empresaOndeTrabalhaAvalista = empresaOndeTrabalhaAvalista;
	}

	@Column(name = "cep_comercial_avalista", length = 10)
	public String getCepComercialAvalista() {
		return cepComercialAvalista;
	}

	public void setCepComercialAvalista(String cepComercialAvalista) {
		this.cepComercialAvalista = cepComercialAvalista;
	}

	@Column(name = "logradouro_comercial_avalista", length = 100)
	public String getLogradouroComercialAvalista() {
		return logradouroComercialAvalista;
	}

	public void setLogradouroComercialAvalista(String logradouroComercialAvalista) {
		this.logradouroComercialAvalista = logradouroComercialAvalista;
	}

	@Column(name = "numero_comercial_avalista", length = 10)
	public String getNumeroComercialAvalista() {
		return numeroComercialAvalista;
	}

	public void setNumeroComercialAvalista(String numeroComercialAvalista) {
		this.numeroComercialAvalista = numeroComercialAvalista;
	}

	@Column(name = "complemento_comercial_avalista", length = 30)
	public String getComplementoComercialAvalista() {
		return complementoComercialAvalista;
	}

	public void setComplementoComercialAvalista(String complementoComercialAvalista) {
		this.complementoComercialAvalista = complementoComercialAvalista;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_bairro_comercial_avalista", length = 20)
	public TipoBairro getTipoBairroComercialAvalista() {
		return tipoBairroComercialAvalista;
	}

	public void setTipoBairroComercialAvalista(TipoBairro tipoBairroComercialAvalista) {
		this.tipoBairroComercialAvalista = tipoBairroComercialAvalista;
	}

	@Column(name = "bairro_comercial_avalista", length = 50)
	public String getBairroComercialAvalista() {
		return bairroComercialAvalista;
	}

	public void setBairroComercialAvalista(String bairroComercialAvalista) {
		this.bairroComercialAvalista = bairroComercialAvalista;
	}

	@Column(name = "telefone_comercial_01_avalista", length = 20)
	public String getTelefoneComercial01Avalista() {
		return telefoneComercial01Avalista;
	}

	public void setTelefoneComercial01Avalista(String telefoneComercial01Avalista) {
		this.telefoneComercial01Avalista = telefoneComercial01Avalista;
	}

	@Column(name = "nome_pai_avalista", length = 100)
	public String getNomePaiAvalista() {
		return nomePaiAvalista;
	}

	public void setNomePaiAvalista(String nomePaiAvalista) {
		this.nomePaiAvalista = nomePaiAvalista;
	}

	@Column(name = "nome_mae_avalista", length = 100)
	public String getNomeMaeAvalista() {
		return nomeMaeAvalista;
	}

	public void setNomeMaeAvalista(String nomeMaeAvalista) {
		this.nomeMaeAvalista = nomeMaeAvalista;
	}

	@Column(name = "limite_credito", precision = 18, scale = 4)
	public BigDecimal getLimiteCredito() {
		return limiteCredito;
	}

	public void setLimiteCredito(BigDecimal limiteCredito) {
		this.limiteCredito = limiteCredito;
	}

	@Column(name = "saldo_credito", precision = 18, scale = 4)
	public BigDecimal getSaldoCredito() {
		return saldoCredito;
	}

	public void setSaldoCredito(BigDecimal saldoCredito) {
		this.saldoCredito = saldoCredito;
	}

	@Column(name = "referencia_onde_comprou_01", length = 150)
	public String getReferenciaOndeComprou01() {
		return referenciaOndeComprou01;
	}

	public void setReferenciaOndeComprou01(String referenciaOndeComprou01) {
		this.referenciaOndeComprou01 = referenciaOndeComprou01;
	}

	@Column(name = "referencia_onde_comprou_02", length = 150)
	public String getReferenciaOndeComprou02() {
		return referenciaOndeComprou02;
	}

	public void setReferenciaOndeComprou02(String referenciaOndeComprou02) {
		this.referenciaOndeComprou02 = referenciaOndeComprou02;
	}

	@Column(name = "referencia_conde_comprou_03", length = 150)
	public String getReferenciaOndeComprou03() {
		return referenciaOndeComprou03;
	}

	public void setReferenciaOndeComprou03(String referenciaOndeComprou03) {
		this.referenciaOndeComprou03 = referenciaOndeComprou03;
	}

	@Column(name = "informa_iss_digital")
	public boolean isInformaIssDigital() {
		return informaIssDigital;
	}

	public void setInformaIssDigital(boolean informaIssDigital) {
		this.informaIssDigital = informaIssDigital;
	}

	@Column(name = "informa_dief")
	public boolean isInformaDief() {
		return informaDief;
	}

	public void setInformaDief(boolean informaDief) {
		this.informaDief = informaDief;
	}

	@Column(name = "informa_dic")
	public boolean isInformaDic() {
		return informaDic;
	}

	public void setInformaDic(boolean informaDic) {
		this.informaDic = informaDic;
	}

	@Column(name = "informa_demms")
	public boolean isInformaDemms() {
		return informaDemms;
	}

	public void setInformaDemms(boolean informaDemms) {
		this.informaDemms = informaDemms;
	}

	@Column(name = "orgao_publico")
	public boolean isOrgaoPublico() {
		return orgaoPublico;
	}

	public void setOrgaoPublico(boolean orgaoPublico) {
		this.orgaoPublico = orgaoPublico;
	}

	@Column(name = "informa_livro_eletronico")
	public boolean isInformaLivroEletronico() {
		return informaLivroEletronico;
	}

	public void setInformaLivroEletronico(boolean informaLivroEletronico) {
		this.informaLivroEletronico = informaLivroEletronico;
	}

	@Column(name = "sociedade_simples")
	public boolean isSociedadeSimples() {
		return sociedadeSimples;
	}

	public void setSociedadeSimples(boolean sociedadeSimples) {
		this.sociedadeSimples = sociedadeSimples;
	}

	@Column(name = "substituto_iss")
	public boolean isSubstitutoIss() {
		return substitutoIss;
	}

	public void setSubstitutoIss(boolean substitutoIss) {
		this.substitutoIss = substitutoIss;
	}

	@Column(name = "isento_icms")
	public boolean isIsentoIcms() {
		return isentoIcms;
	}

	public void setIsentoIcms(boolean isentoIcms) {
		this.isentoIcms = isentoIcms;
	}

	@Column(name = "fornecedor_produto_primario")
	public boolean isFornecedorProdutoPrimario() {
		return fornecedorProdutoPrimario;
	}

	public void setFornecedorProdutoPrimario(boolean fornecedorProdutoPrimario) {
		this.fornecedorProdutoPrimario = fornecedorProdutoPrimario;
	}

	
	
	@Column(name = "obs", columnDefinition = "text")
	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}
	
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<Equipamento> getEquipamentos() {
		return equipamentos;
	}

	public void setEquipamentos(List<Equipamento> equipamentos) {
		this.equipamentos = equipamentos;
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
	
	@Column(name = "inadimplente")
	public boolean isInadimplente() {
		return inadimplente;
	}

	public void setInadimplente(boolean inadimplente) {
		this.inadimplente = inadimplente;
	}

	@Column(name = "bloqueado")
	public boolean isBloqueado() {
		return bloqueado;
	}

	public void setBloqueado(boolean bloqueado) {
		this.bloqueado = bloqueado;
	}

	@Column(name = "especial")
	public boolean isEspecial() {
		return especial;
	}

	public void setEspecial(boolean especial) {
		this.especial = especial;
	}

	@Column(name = "revenda")
	public boolean isRevenda() {
		return revenda;
	}

	public void setRevenda(boolean revenda) {
		this.revenda = revenda;
	}
	
	@Column(name = "spc")
	public boolean isSpc() {
		return spc;
	}

	public void setSpc(boolean spc) {
		this.spc = spc;
	}

	@Column(name = "motivo_spc", length = 100)
	public String getMotivoSpc() {
		return motivoSpc;
	}

	public void setMotivoSpc(String motivoSpc) {
		this.motivoSpc = motivoSpc;
	}

	@Column(name = "serasa")
	public boolean isSerasa() {
		return serasa;
	}

	public void setSerasa(boolean serasa) {
		this.serasa = serasa;
	}

	@Column(name = "motivo_serasa")
	public String getMotivoSerasa() {
		return motivoSerasa;
	}

	public void setMotivoSerasa(String motivoSerasa) {
		this.motivoSerasa = motivoSerasa;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fase_id")
	public FaseFunilVendas getFase() {
		return fase;
	}

	public void setFase(FaseFunilVendas fase) {
		this.fase = fase;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "persona_id")
	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<Acao> getAcoes() {
		return acoes;
	}

	public void setAcoes(List<Acao> acoes) {
		this.acoes = acoes;
	}
	
	@Column(name = "em_treinamento")
	public boolean isEmTreinamento() {
		return emTreinamento;
	}

	public void setEmTreinamento(boolean emTreinamento) {
		this.emTreinamento = emTreinamento;
	}
	
	@Column(name = "segmento")
	public String getSegmento() {
		return segmento;
	}

	public void setSegmento(String segmento) {
		this.segmento = segmento;
	}

	@Column(name = "usa_fiscal")
	public boolean isUsaFiscal() {
		return usaFiscal;
	}

	public void setUsaFiscal(boolean usaFiscal) {
		this.usaFiscal = usaFiscal;
	}

	@Column(name = "paf_ecef")
	public boolean isPafEcef() {
		return pafEcef;
	}

	public void setPafEcef(boolean pafEcef) {
		this.pafEcef = pafEcef;
	}

	@Column(name = "nfe")
	public boolean isNfe() {
		return nfe;
	}

	public void setNfe(boolean nfe) {
		this.nfe = nfe;
	}

	@Column(name = "nfce")
	public boolean isNfce() {
		return nfce;
	}

	public void setNfce(boolean nfce) {
		this.nfce = nfce;
	}

	@Column(name = "mfe")
	public boolean isMfe() {
		return mfe;
	}

	public void setMfe(boolean mfe) {
		this.mfe = mfe;
	}

	@Column(name = "sat_cf")
	public boolean isSatCf() {
		return satCf;
	}

	public void setSatCf(boolean satCf) {
		this.satCf = satCf;
	}

	@Column(name = "nivel")
	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	
	@Column(name = "dia_pagamento_mensalidade")
	public String getDiaPagamentoMensalidade() {
		return diaPagamentoMensalidade;
	}

	public void setDiaPagamentoMensalidade(String diaPagamentoMensalidade) {
		this.diaPagamentoMensalidade = diaPagamentoMensalidade;
	}

	@Column(name = "valor_mensalidade")
	public BigDecimal getValorMensalidade() {
		return valorMensalidade;
	}

	public void setValorMensalidade(BigDecimal valorMensalidade) {
		this.valorMensalidade = valorMensalidade;
	}
	
	@Column(name = "referencia", length = 200)
	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	
	@Transient
	public boolean isCliente() {
		if (tipoParticipante == TipoParticipante.CLIENTE) {
			return true;
		} else {
			return false;
		}
	}
	
	@Transient
	public boolean isPessoaFisica() {
		if (tipoPessoa == TipoPessoa.FISICA) {
			return true;
		} else {
			return false;
		}
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
		/**
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Participante other = (Participante) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
		*/
		
		Participante participante = (Participante) obj;
		return this.id == participante.getId();
		
	}

}
