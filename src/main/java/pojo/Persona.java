package pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import enums.EstadoCivil;
import enums.NivelEscolaridade;
import enums.Sexo;

@Entity
public class Persona implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nomePersona;
	private Sexo sexo;
	private String idade;
	private EstadoCivil estadoCivil;
	private String cargoOcupacao;
	private String segmentoMercado;
	
	private String ondeTrabalha;
	private NivelEscolaridade escolaridade;
	private String meiosComunicacaoUtiliza;
	
	private String principaisObjetivos;
	private String principaisProblemasDesafios;
	
	private String situacaoResidencial;
	private String idiomas;
	private String religiao;
	
	private List<Participante> clientes = new ArrayList<>();
	private boolean inativo;
	private String nomeUsuario;
	private Date dataInativacao;
	private Date horaInativacao;
	
	private String comoMinhaEmpresaPodeAjusar;

	@Id
	@Column(name = "id")
	@GeneratedValue(generator = "persona_id_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "persona_id_seq", sequenceName = "persona_id_seq", allocationSize = 1)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "nome_persona")
	public String getNomePersona() {
		return nomePersona;
	}

	public void setNomePersona(String nomePersona) {
		this.nomePersona = nomePersona;
	}

	@OneToMany(mappedBy = "persona", cascade = CascadeType.ALL, orphanRemoval = false)
	public List<Participante> getClientes() {
		return clientes;
	}

	public void setClientes(List<Participante> clientes) {
		this.clientes = clientes;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "sexo", length = 10)
	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	@Column(name = "inativo")
	public boolean isInativo() {
		return inativo;
	}

	public void setInativo(boolean inativo) {
		this.inativo = inativo;
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

	@Enumerated(EnumType.STRING)
	@Column(name = "estado_civil", length = 20)
	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	@Column(name = "situacao_residencial")
	public String getSituacaoResidencial() {
		return situacaoResidencial;
	}

	public void setSituacaoResidencial(String situacaoResidencial) {
		this.situacaoResidencial = situacaoResidencial;
	}

	@Column(name = "idiomas")
	public String getIdiomas() {
		return idiomas;
	}

	public void setIdiomas(String idiomas) {
		this.idiomas = idiomas;
	}

	@Column(name = "religiao")
	public String getReligiao() {
		return religiao;
	}

	public void setReligiao(String religiao) {
		this.religiao = religiao;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "nivel_escolaridade", length = 20)
	public NivelEscolaridade getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(NivelEscolaridade escolaridade) {
		this.escolaridade = escolaridade;
	}
	
	@Column(name = "idade", length = 50)
	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	@Column(name = "cargo_ocupacao", length = 100)
	public String getCargoOcupacao() {
		return cargoOcupacao;
	}

	public void setCargoOcupacao(String cargoOcupacao) {
		this.cargoOcupacao = cargoOcupacao;
	}

	@Column(name = "segmento_mercado", length = 100)
	public String getSegmentoMercado() {
		return segmentoMercado;
	}

	public void setSegmentoMercado(String segmentoMercado) {
		this.segmentoMercado = segmentoMercado;
	}

	@Column(name = "onde_trabalha", length = 100)
	public String getOndeTrabalha() {
		return ondeTrabalha;
	}

	public void setOndeTrabalha(String ondeTrabalha) {
		this.ondeTrabalha = ondeTrabalha;
	}

	@Column(name = "meios_comunicacao_utiliza", length = 200)
	public String getMeiosComunicacaoUtiliza() {
		return meiosComunicacaoUtiliza;
	}

	public void setMeiosComunicacaoUtiliza(String meiosComunicacaoUtiliza) {
		this.meiosComunicacaoUtiliza = meiosComunicacaoUtiliza;
	}

	@Column(name = "principais_objetivos", length = 500)
	public String getPrincipaisObjetivos() {
		return principaisObjetivos;
	}

	public void setPrincipaisObjetivos(String principaisObjetivos) {
		this.principaisObjetivos = principaisObjetivos;
	}

	@Column(name = "principais_problemas_desafios", length = 500)
	public String getPrincipaisProblemasDesafios() {
		return principaisProblemasDesafios;
	}

	public void setPrincipaisProblemasDesafios(String principaisProblemasDesafios) {
		this.principaisProblemasDesafios = principaisProblemasDesafios;
	}
	
	@Column(name = "como_minha_empresa_pode_ajudar")
	public String getComoMinhaEmpresaPodeAjusar() {
		return comoMinhaEmpresaPodeAjusar;
	}

	public void setComoMinhaEmpresaPodeAjusar(String comoMinhaEmpresaPodeAjusar) {
		this.comoMinhaEmpresaPodeAjusar = comoMinhaEmpresaPodeAjusar;
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
		Persona other = (Persona) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
