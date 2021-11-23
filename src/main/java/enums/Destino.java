package enums;

public enum Destino {
	
	LOJA("Loja"),
	DEPOSITO("Deposito");
	
	private String descricao;
	
	private Destino(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
}
