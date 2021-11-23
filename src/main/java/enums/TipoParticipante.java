package enums;

public enum TipoParticipante {
	PROSPECT("Prospect"),
	CLIENTE("Cliente"),
	FORNECEDOR("Fornecedor");
	
	private String descricao;
	
	private TipoParticipante(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
}
