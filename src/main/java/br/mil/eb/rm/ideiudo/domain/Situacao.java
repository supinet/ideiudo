package br.mil.eb.rm.ideiudo.domain;

public enum Situacao {
	
	LIDO  ("Lido") ,
	NAO_LIDO  ("Não Lido");

	private String descricao;
	
	private Situacao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
}

