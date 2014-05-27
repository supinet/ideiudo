package br.mil.eb.rm.ideiudo.util.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.mil.eb.rm.ideiudo.model.IdeiaProblema;
import br.mil.eb.rm.ideiudo.util.jpa.Transactional;
import br.mil.eb.rm.ideiudo.util.repository.IdeiasProblemas;

public class CadastroIdeiaProblemaService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private IdeiasProblemas ideiasProblemas;

	@Transactional
	public IdeiaProblema salvar(IdeiaProblema ideiaProblema) {

		return ideiasProblemas.guardar(ideiaProblema);
		

	}

}
