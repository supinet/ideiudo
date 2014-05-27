package br.mil.eb.rm.ideiudo.util.repository.filter;

import java.io.Serializable;
import java.util.Date;

import br.mil.eb.rm.ideiudo.domain.Situacao;
import br.mil.eb.rm.ideiudo.domain.Tipo;

public class IdeiaProblemaFilter implements Serializable {

	private static final long serialVersionUID = 1L;

	private String assunto;
	private Date dataCadastroDe;
	private Date dataCadastroAte;
	private Tipo[] tipos;
	private Situacao situacao;

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto == null ? null : assunto.toUpperCase();
	}

	public Date getDataCadastroDe() {
		return dataCadastroDe;
	}

	public void setDataCadastroDe(Date dataCadastroDe) {
		this.dataCadastroDe = dataCadastroDe;
	}

	public Date getDataCadastroAte() {
		return dataCadastroAte;
	}

	public void setDataCadastroAte(Date dataCadastroAte) {
		this.dataCadastroAte = dataCadastroAte;
	}

	public Tipo[] getTipos() {
		return tipos;
	}

	public void setTipos(Tipo[] tipos) {
		this.tipos = tipos;
	}

	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}

}
