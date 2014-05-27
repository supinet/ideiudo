package br.mil.eb.rm.ideiudo.domain;

public enum Tipo {
	
	IDEIA  ("Idéia") ,
	PROBLEMA  ("Problema");

	private String descricao;
	
	private Tipo(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
}

