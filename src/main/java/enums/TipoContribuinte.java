package enums;

public enum TipoContribuinte {
	
	CONTRIBUINTE_ICMS("Contribuinte ICMS"),
	CONTRIBUINTE_ISENTO("Contribuinte Isento"),
	NAO_CONTRIBUINTE("Não Contribuinte");
	
	private String descricao;
	
	private TipoContribuinte(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
}
