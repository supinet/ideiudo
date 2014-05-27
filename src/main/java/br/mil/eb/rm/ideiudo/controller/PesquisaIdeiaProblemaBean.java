package br.mil.eb.rm.ideiudo.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.mil.eb.rm.ideiudo.domain.Tipo;
import br.mil.eb.rm.ideiudo.model.IdeiaProblema;
import br.mil.eb.rm.ideiudo.util.jsf.FacesUtil;
import br.mil.eb.rm.ideiudo.util.repository.IdeiasProblemas;
import br.mil.eb.rm.ideiudo.util.repository.filter.IdeiaProblemaFilter;

@Named
@ViewScoped
public class PesquisaIdeiaProblemaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private IdeiasProblemas ideiasProblemas;

	private IdeiaProblemaFilter filtro;

	private List<IdeiaProblema> ideiasProblemasFiltrados;
	private IdeiaProblema ideiaProblemaSelecionado;

	public PesquisaIdeiaProblemaBean() {
		filtro = new IdeiaProblemaFilter();
	}

	public void pesquisar() {
		ideiasProblemasFiltrados = ideiasProblemas.filtrados(filtro);
	}

	public void excluir() {
		ideiasProblemas.remover(ideiaProblemaSelecionado);
		ideiasProblemasFiltrados.remove(ideiaProblemaSelecionado);

		FacesUtil.addInfoMessage("Ideia ou problema "
				+ ideiaProblemaSelecionado.getAssunto()
				+ " exluído com sucesso.");
	}

	public IdeiaProblemaFilter getFiltro() {
		return filtro;
	}

	public List<IdeiaProblema> getIdeiasProblemasFiltrados() {
		return ideiasProblemasFiltrados;
	}

	public IdeiaProblema getIdeiaProblemaSelecionado() {
		return ideiaProblemaSelecionado;
	}

	public void setIdeiaProblemaSelecionado(
			IdeiaProblema ideiaProblemaSelecionado) {
		this.ideiaProblemaSelecionado = ideiaProblemaSelecionado;
	}

	public Tipo[] getTipos() {
		return Tipo.values();

	}

}
