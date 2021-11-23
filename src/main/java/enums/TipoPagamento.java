package enums;

public enum TipoPagamento {
	DINHEIRO("Dinheiro"),
	CARTEIRA("Carteira"),
	CARTAO_DE_CREDITO("Cartão de Crédito"),
	CARTAO_DE_DEBITO("Cartão de Débito"),
	CHEQUE("Cheque"),
	BOLETO("Boleto"),
	CONTA_CORRENTE("Conta corrente");
	
	private String descricao;
	
	private TipoPagamento(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}	
}
