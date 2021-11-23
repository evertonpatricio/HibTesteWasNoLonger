package enums;

public enum Prioridade {
	
	ALTA("Alta"),
	MEDIA("Média"),
	BAIXA("Baixa");
	
	private String descricao;
	
	private Prioridade(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
}
