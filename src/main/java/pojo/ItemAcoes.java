package pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
public class ItemAcoes implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String descricaoAcao;
	private Date dataAcao;
	private Date horaAcao;
	private Persona persona;
	private Participante cliente;
	private boolean itemAdicionado;

	@Id
	@Column(name = "id")
	@GeneratedValue(generator = "item_acao_id_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "item_acao_id_seq", sequenceName = "item_acao_id_seq", allocationSize = 1)
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

	@Column(name = "descricao_acao")
	public String getDescricaoAcao() {
		return descricaoAcao;
	}

	public void setDescricaoAcao(String descricaoAcao) {
		this.descricaoAcao = descricaoAcao;
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
	@JoinColumn(name = "persona_id")
	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	@Column(name = "item_adicionado")
	public boolean isItemAdicionado() {
		return itemAdicionado;
	}

	public void setItemAdicionado(boolean itemAdicionado) {
		this.itemAdicionado = itemAdicionado;
	}
	
	@Transient
	public boolean isClienteAssociado() {
		return this.getCliente() != null && this.getCliente().getId() != null;
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
		ItemAcoes other = (ItemAcoes) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
