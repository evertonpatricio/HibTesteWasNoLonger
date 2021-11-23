package pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
public class Equipamento implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private TipoEquipamento tipoEquipamento;
	private Marca marca;
	private Modelo modelo;
	private Participante cliente;
	private String numeroDeSerie;
	private String adicional;
	private boolean ativo = true;
	private String nomeUsuario;
	private Date dataInativacao;
	private Date horaInativacao;

	@Id
	@Column(name = "id")
	@GeneratedValue(generator = "equipamento_id_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "equipamento_id_seq", sequenceName = "equipamento_id_seq", allocationSize = 1)
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@ManyToOne
	@JoinColumn(name="tipo_equipamento_id")
	public TipoEquipamento getTipoEquipamento() {
		return tipoEquipamento;
	}

	public void setTipoEquipamento(TipoEquipamento tipoEquipamento) {
		this.tipoEquipamento = tipoEquipamento;
	}
	
	@ManyToOne
	@JoinColumn(name="marca_id")
	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	
	@ManyToOne
	@JoinColumn(name="modelo_id")
	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	public Participante getCliente() {
		return cliente;
	}

	public void setCliente(Participante cliente) {
		this.cliente = cliente;
	}

	@Column(name = "numero_de_serie", length = 100)
	public String getNumeroDeSerie() {
		return numeroDeSerie;
	}

	public void setNumeroDeSerie(String numeroDeSerie) {
		this.numeroDeSerie = numeroDeSerie;
	}
	
	@Column(name = "adicional", length=100)
	public String getAdicional() {
		return adicional;
	}

	public void setAdicional(String adicional) {
		this.adicional = adicional;
	}
	
	@Column(name = "ativo")
	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	@Column(name = "nome_usuario")
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
		Equipamento other = (Equipamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
