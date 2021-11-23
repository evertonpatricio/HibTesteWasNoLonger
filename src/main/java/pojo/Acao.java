package pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import enums.Prioridade;
import enums.ResultadoAcao;
import enums.StatusAcao;

@Entity
public class Acao implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String observacao;
	private Date dataAcao;
	private Date horaAcao;
	private TipoAcao tipoAcao;
	private ResultadoAcao resultadoAcao;
	private Participante cliente;
	private String titulo;
	private String detalhamento;
	private StatusAcao status;
	private String acao;
	private Prioridade prioridade;
	private Date dataInicio;
	private Date dataTermino;
	private Funcionario responsavel;
	private String descricaoConclusao;
	private boolean inativo;
	private String nomeUsuario;
	private Date dataInativacao;
	private Date horaInativacao;

	@Id
	@Column(name = "id")
	@GeneratedValue(generator = "acao_id_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "acao_id_seq", sequenceName = "acao_id_seq", allocationSize = 1)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "cliente_id")
	public Participante getCliente() {
		return cliente;
	}

	public void setCliente(Participante cliente) {
		this.cliente = cliente;
	}

	@Column(name = "observacao", length = 100, columnDefinition = "text")
	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "data_da_acao")
	public Date getDataAcao() {
		return dataAcao;
	}

	public void setDataAcao(Date dataAcao) {
		this.dataAcao = dataAcao;
	}

	@Temporal(TemporalType.TIME)
	@Column(name = "hora_da_acao")
	public Date getHoraAcao() {
		return horaAcao;
	}

	public void setHoraAcao(Date horaAcao) {
		this.horaAcao = horaAcao;
	}

	@ManyToOne
	@JoinColumn(name = "tipo_acao_id")
	public TipoAcao getTipoAcao() {
		return tipoAcao;
	}

	public void setTipoAcao(TipoAcao tipoAcao) {
		this.tipoAcao = tipoAcao;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "resultado_acao", length = 11)
	public ResultadoAcao getResultadoAcao() {
		return resultadoAcao;
	}

	public void setResultadoAcao(ResultadoAcao resultadoAcao) {
		this.resultadoAcao = resultadoAcao;
	}

	@Column(name = "titulo")
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@Column(name = "detalhamento", columnDefinition = "text")
	public String getDetalhamento() {
		return detalhamento;
	}

	public void setDetalhamento(String detalhamento) {
		this.detalhamento = detalhamento;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "status_acao", length = 15)
	public StatusAcao getStatus() {
		return status;
	}

	public void setStatus(StatusAcao status) {
		this.status = status;
	}

	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
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
	public Prioridade getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(Prioridade prioridade) {
		this.prioridade = prioridade;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "data_inicio")
	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "data_termino")
	public Date getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(Date dataTermino) {
		this.dataTermino = dataTermino;
	}

	@ManyToOne
	@JoinColumn(name = "responsavel_id")
	public Funcionario getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Funcionario responsavel) {
		this.responsavel = responsavel;
	}

	@Column(name = "descricao_conclusao")
	public String getDescricaoConclusao() {
		return descricaoConclusao;
	}

	public void setDescricaoConclusao(String descricaoConclusao) {
		this.descricaoConclusao = descricaoConclusao;
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
		Acao other = (Acao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
