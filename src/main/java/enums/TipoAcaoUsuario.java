package enums;

public enum TipoAcaoUsuario {
	
	CADASTROU("Cadastrou"),
	ALTEROU("Alterou"),
	INATIVOU("Inativou"),
	INVALIDOU("Invalidou"),
	VISUALIZOU("Visualizou");
	
	private String descricao;
	
	private TipoAcaoUsuario(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
