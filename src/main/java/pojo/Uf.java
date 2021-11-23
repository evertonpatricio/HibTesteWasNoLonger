package pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;


@Entity
public class Uf implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String sigla;
	private String nome;
	private String codigoIbge;
	private boolean ativo = true;
	private String nomeUsuario;
	private Date dataInativacao;
	private Date horaInativacao;
	private boolean estouAqui;
	private BigDecimal aliquotaInternaIcms = BigDecimal.ZERO;

	@Id
	@Column(name = "id")
	@GeneratedValue(generator = "uf_id_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "uf_id_seq", sequenceName = "uf_id_seq", allocationSize = 1)
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "sigla", length = 2)
	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	@Column(name = "nome", length = 50)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name = "codigo_ibge", length = 2)
	public String getCodigoIbge() {
		return codigoIbge;
	}
	
	public void setCodigoIbge(String codigoIbge) {
		this.codigoIbge = codigoIbge;
	}
	
	@Column(name = "inativo")
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
	
	@Column(name = "estou_aqui")
	public boolean isEstouAqui() {
		return estouAqui;
	}

	public void setEstouAqui(boolean estouAqui) {
		this.estouAqui = estouAqui;
	}
	
	@Column(name = "aliquota_interna_icms")
	public BigDecimal getAliquotaInternaIcms() {
		return aliquotaInternaIcms;
	}

	public void setAliquotaInternaIcms(BigDecimal aliquotaInternaIcms) {
		this.aliquotaInternaIcms = aliquotaInternaIcms;
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
		Uf other = (Uf) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
