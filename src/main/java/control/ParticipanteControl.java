package control;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.model.LazyDataModel;

import enums.*;
import filter.*;
import pojo.*;
import service.*;

@Named
@ViewScoped
public class ParticipanteControl implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ParticipanteService participanteService;

	private Participante participanteSelecionado = new Participante();
	private LazyDataModel<Participante> modelParticipantes;
	
	private ParticipanteFilter filtro;

	private String tipoDePesquisa;

	private Equipamento equipamento = new Equipamento();
	
	private Long participanteBuscarId = 0l;
	
	public ParticipanteControl() {
		limpar();
	}
	
	public void limpar() {
		participanteSelecionado = new Participante();
		filtro = new ParticipanteFilter();
	}

	public ParticipanteFilter getFiltro() {
		return filtro;
	}

	public void setFiltro(ParticipanteFilter filtro) {
		this.filtro = filtro;
	}

	public String getTipoDePesquisa() {
		return tipoDePesquisa;
	}

	public void setTipoDePesquisa(String tipoDePesquisa) {
		this.tipoDePesquisa = tipoDePesquisa;
	}

	public Participante getParticipanteSelecionado() {
		return participanteSelecionado;
	}

	public void setParticipanteSelecionado(Participante participanteSelecionado) {
		this.participanteSelecionado = participanteSelecionado;
	}

	public LazyDataModel<Participante> getModelParticipantes() {
		return modelParticipantes;
	}

	public void setModelParticipantes(LazyDataModel<Participante> modelParticipantes) {
		this.modelParticipantes = modelParticipantes;
	}

	public Equipamento getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}
	
	public TipoPagamento[] getTiposPagamento() {
		return TipoPagamento.values();
	}
	
	public Long getParticipanteBuscarId() {
		return participanteBuscarId;
	}

	public void setParticipanteBuscarId(Long participanteBuscarId) {
		this.participanteBuscarId = participanteBuscarId;
	}

	// Métodos principais
	public void salvar() {

		Participante participanteRetornado = new Participante();
		participanteRetornado = participanteService
				.salvar(participanteSelecionado);

		if (participanteRetornado.getId() != null) {
			this.participanteSelecionado = participanteService.buscarObjetoCompleto(participanteRetornado.getId());
		}
	}

	public void buscarObjetoCompleto() {
		if (participanteBuscarId != 0l) {
			participanteSelecionado = participanteService.buscarObjetoCompleto(participanteBuscarId);
		}
	}
	
}
