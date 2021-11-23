package pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
public class Marca implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String descricao;
	private boolean ativo = true;
	private String nomeUsuario;
	private Date dataInativacao;
	private Date horaInativacao;

	@Id
	@Column(name = "id")
	@GeneratedValue(generator = "marca_id_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "marca_id_seq", sequenceName = "marca_id_seq", allocationSize = 1)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "descricao", length = 100)
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
		Marca other = (Marca) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
