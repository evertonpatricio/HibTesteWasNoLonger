package enums;

public enum TipoBairro {
	
	BAIRRO("Bairro"),
	BOSQUE("Bosque"),
	CHACARA("Chácara"),
	CONJUNTO("Conjunto"),
	DESMEMBRAMENTO("Desmembramento"),
	DISTRITO("Distrito"),
	FAVELA("Favela"),
	FAZENDA("Fazenda"),
	GLEBA("Gleba"),
	HORTO("Horto"),
	JARDIM("Jardim"),
	LOTEAMENTO("Loteamento"),
	NUCLEO("Núcleo"),
	PARQUE("Parque"),
	RESIDENCIAL("Residencial"),
	SITIO("Sítio"),
	TROPICAL("Tropical"),
	VILA("Vila"),
	ZONA("Zona");
	
	private String descricao;
	
	private TipoBairro(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
}
