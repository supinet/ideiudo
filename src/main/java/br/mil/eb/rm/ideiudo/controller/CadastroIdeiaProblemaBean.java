package br.mil.eb.rm.ideiudo.controller;

import java.io.Serializable;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.mil.eb.rm.ideiudo.domain.Tipo;
import br.mil.eb.rm.ideiudo.model.IdeiaProblema;
import br.mil.eb.rm.ideiudo.util.jsf.FacesUtil;
import br.mil.eb.rm.ideiudo.util.service.CadastroIdeiaProblemaService;

@Named
@ViewScoped
public class CadastroIdeiaProblemaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CadastroIdeiaProblemaService cadastroIdeiaProblemaService;

	private IdeiaProblema ideiaProblema;

	public CadastroIdeiaProblemaBean() {
		limpar();
	}

	public void inicializar() {

		if (FacesUtil.isNotPostback()) {
			System.out.println("Inicializando ...");
		}
	}

	public void salvarIdeia() {

		this.ideiaProblema.setTipo(Tipo.IDEIA);

		this.ideiaProblema = cadastroIdeiaProblemaService
				.salvar(this.ideiaProblema);
		limpar();

		FacesUtil.addInfoMessage("Ideia enviada com sucesso!");
	}

	public void salvarProblema() {
		this.ideiaProblema.setTipo(Tipo.PROBLEMA);

		this.ideiaProblema = cadastroIdeiaProblemaService.salvar(ideiaProblema);
		limpar();

		FacesUtil.addInfoMessage("Problema resgistrado com sucesso!");
	}

	private void limpar() {
		ideiaProblema = new IdeiaProblema();
	}

	public IdeiaProblema getIdeiaProblema() {
		return ideiaProblema;
	}

	public void setIdeiaProblema(IdeiaProblema ideiaProblema) {
		this.ideiaProblema = ideiaProblema;
	}
}
