package dao;

import java.util.Date;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import pojo.Participante;
import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;

@Stateless
public class ParticipanteDao {

	@PersistenceContext
	EntityManager em;

	public Participante salvarAtualizar(Participante participante) {
		participante.setDataCadastro(new Date());
		return em.merge(participante);
	}

	public Participante salvarCommitandoNoService(Participante participante) {
		participante.setDataCadastro(new Date());
		return em.merge(participante);
	}
	
	public Participante getPorId(Long id) {
		return em.find(Participante.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public Participante buscarObjetoCompleto(Long id) {

		Session session = em.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Participante.class);

		criteria.add(Restrictions.eq("ativo", true));

		criteria.setFetchMode("setor", FetchMode.JOIN);
		criteria.setFetchMode("municipio", FetchMode.JOIN);
		criteria.setFetchMode("municipio.uf", FetchMode.JOIN);
		criteria.setFetchMode("setorAnterior", FetchMode.JOIN);
		criteria.setFetchMode("municipioAvalista", FetchMode.JOIN);
		criteria.setFetchMode("fase", FetchMode.JOIN);
		criteria.setFetchMode("persona", FetchMode.JOIN);
		
		criteria.add(Restrictions.idEq(id));
		
		Participante participanteRetornar = (Participante) criteria.addOrder(Order.asc("id")).uniqueResult();
		
		if (participanteRetornar != null) {
			if (participanteRetornar.getAcoes() != null) {
				participanteRetornar.getAcoes().size();
			}
			if (participanteRetornar.getEquipamentos() != null) {
				participanteRetornar.getEquipamentos().size();
			}
		}
		
		return participanteRetornar;
	}
	
}
