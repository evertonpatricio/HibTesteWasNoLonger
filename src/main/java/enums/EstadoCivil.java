package enums;

public enum EstadoCivil {
	
	SOLTEIRO("Solteiro(a)"),
	VIUVO("Viuvo(a)"),
	DIVORCIADO("Divorciado(a)"),
	CASADO("Casado(a)");
	
	private String descricao;
	
	private EstadoCivil(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
}
