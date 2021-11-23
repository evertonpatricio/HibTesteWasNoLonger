package service;

import java.io.Serializable;
import java.util.Date;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.ParticipanteDao;
import pojo.Municipio;
import pojo.Participante;
import util.faces.FacesUtil;

@Stateless
public class ParticipanteService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ParticipanteDao participanteDao;
	
	public Participante salvar(Participante participante) {
		
		Participante participanteRetornar = new Participante();

		if(participante.getDataCadastro() == null){
			participante.setDataCadastro(new Date());
		}
			
		participanteRetornar = participanteDao.salvarAtualizar(participante);
		
		if (participanteRetornar.isAtivo() == false) {
			FacesUtil.addSucessMessage("Participante inativado com sucesso!");
			
		} else {
			
			if (participanteRetornar.getId() == null) {
				FacesUtil.addErrorMessage("Ocorreram erros na gravação dos dados");
			} else {
				FacesUtil.addSucessMessage("Dados salvos com sucesso.");
			}
		}
		
		return participanteRetornar;
	}
	
	public Participante getPorId(Long id){
		return participanteDao.getPorId(id);
	}
	
	public Participante buscarObjetoCompleto(Long id) {
		return participanteDao.buscarObjetoCompleto(id);
	}
	
	public Municipio obterMunicipio(String municipio, String UF) {
		return null;
	}
	
}
