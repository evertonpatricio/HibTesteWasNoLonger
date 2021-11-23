package enums;

public enum StatusAcao {
	PENDENTE("Pendente"),
	EM_ANDAMENTO("Em andamento"),
	CONCLUIDO("Concluido");	
	
	private String descricao;
	
	private StatusAcao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
