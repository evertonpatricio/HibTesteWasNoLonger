package enums;

public enum TipoLogradouro {
	ACESSO("Acesso"),
	ALAMEDA("Alameda"),
	ALTO("Alto"),
	ATALHO("Atalho"),
	AVENIDA("Avenida"),
	BAIXA("Baixa"),
	BALNEARIO("Balneario"),
	BECO("Beco"),
	BLOCO("Bloco"),
	BOSQUE("Bosque"),
	CONJUNTO("Conjunto"),
	CAMINHO("Caminho"), 
	CONDOMINIO("Condomínio"),
	CORREDOR("Corredor"),
	CAMPO("Campo"),
	DISTRITO("Distrito"),
	ESTRADA("Estrada"),
	ESTACAO("Estação"),
	FAVELA("Favela"), 
	FAZENDA("Fazenda"),
	FERROVIA("Ferrovia"),
	LOTEAMENTO("Loteamento"),
	PACEIO("Paceio"),
	PRACA("Praça"),
	PRAIA("Praia"),
	PARQUE("Parque"),
	PASSARELA("Passarela"),
	PASSAGEM("Passagem"),
	PONTE("Ponte"),
	RODOVIA("Rodovia"),
	RUA("Rua"),
	SITIO("Sítio"),
	TERMINAL("Terminal"),
	TRAVESA("Travessa"),
	VIA("Via"),
	VIADUTO("Viaduto"),
	VILA("Vila"),
	VIELA("Viela"),
	VALE("Vale");
	
	private String descricao;
	
	private TipoLogradouro(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
}
