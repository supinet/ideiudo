package br.mil.eb.rm.ideiudo.util.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.mil.eb.rm.ideiudo.model.IdeiaProblema;
import br.mil.eb.rm.ideiudo.util.jpa.Transactional;
import br.mil.eb.rm.ideiudo.util.repository.filter.IdeiaProblemaFilter;
import br.mil.eb.rm.ideiudo.util.service.NegocioException;

public class IdeiasProblemas implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public IdeiaProblema guardar(IdeiaProblema ideiaProblema) {
		return ideiaProblema = manager.merge(ideiaProblema);
	}

	@Transactional
	public void remover(IdeiaProblema IdeiaProblema) {
		try {
			IdeiaProblema = porId(IdeiaProblema.getId());
			manager.remove(IdeiaProblema);
			manager.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("IdeiaProblema não pode ser excluída");
		}
	}

	@SuppressWarnings("unchecked")
	public List<IdeiaProblema> filtrados(IdeiaProblemaFilter filtro) {

		Session session = manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(IdeiaProblema.class);

		// where chassi like '%12321%' = ANYWHERE
		if (StringUtils.isNotBlank(filtro.getAssunto())) {
			criteria.add(Restrictions.ilike("assunto", filtro.getAssunto(),
					MatchMode.ANYWHERE));
		}

		if (filtro.getDataCadastroDe() != null) {
			criteria.add(Restrictions.ge("dataCadastro",
					filtro.getDataCadastroDe()));
		}

		if (filtro.getDataCadastroAte() != null) {
			criteria.add(Restrictions.le("dataCadastro",
					filtro.getDataCadastroAte()));
		}

		if (filtro.getTipos() != null && filtro.getTipos().length > 0) {
			criteria.add(Restrictions.in("tipo", filtro.getTipos()));
		}

		return criteria.addOrder(Order.asc("assunto")).list();

	}

	public IdeiaProblema porId(Integer id) {
		return manager.find(IdeiaProblema.class, id);
	}
}
