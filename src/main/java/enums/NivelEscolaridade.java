package enums;

public enum NivelEscolaridade {
	ENSINO_FUNDAMENTAL("Ensino fundamental"),
	ENSINO_MEDIO("Ensino médio"),
	ENSINO_TECNICO("Ensino técnico"),
	ENSINO_SUPERIOR("Ensino Superior"),
	MESTRADO("Mestrado"),
	DOUTORADO("Doutorado"),
	POS_DOUTORADO("Pós-doutorado");
	
	private NivelEscolaridade(String descricao){
		this.descricao = descricao;
	}
	private String descricao;

	public String getDescricao() {
		return descricao;
	}	
}
