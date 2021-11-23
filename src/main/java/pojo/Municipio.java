package pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;


@Entity
public class Municipio implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String descricao;
	private String codigoIBGE;
	private Uf uf;
	private boolean ativo = true;
	private String nomeUsuario;
	private Date dataInativacao;
	private Date horaInativacao;

	@Id
	@Column(name = "id")
	@GeneratedValue(generator = "municipio_id_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "municipio_id_seq", sequenceName = "municipio_id_seq", allocationSize = 1)
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "descricao", length = 50)
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Column(name = "codigo_ibge", length = 7)
	public String getCodigoIBGE() {
		return codigoIBGE;
	}

	public void setCodigoIBGE(String codigoIBGE) {
		this.codigoIBGE = codigoIBGE;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "uf_id")
	public Uf getUf() {
		return uf;
	}
	
	public void setUf(Uf uf) {
		this.uf = uf;
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
	
	@Transient
	public boolean isExistente() {
		return getId() != null;
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
		Municipio other = (Municipio) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
