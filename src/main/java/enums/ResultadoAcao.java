package enums;

public enum ResultadoAcao {
	
	POSITIVO("Positivo"),
	NEGATIVO("Negativo"),
	INDEFINIDO("Indefinido");
	
	private String descricao;
	
	private ResultadoAcao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
}
