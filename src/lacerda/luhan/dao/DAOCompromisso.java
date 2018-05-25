package lacerda.luhan.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import lacerda.luhan.modelo.Compromisso;

public class DAOCompromisso extends DAOGeneric<Compromisso> {

	public DAOCompromisso(EntityManagerFactory emf) {
		super(emf);
	}

	@SuppressWarnings("unchecked")
	public List<Compromisso> getAllByOrdemCronologica() {
		EntityManager em = this.getEntityManagerFactory().createEntityManager();
		List<Compromisso> listaCompromissos = null;
		String consulta = "FROM Compromisso c order by date(data)";
		Query query = em.createQuery(consulta);
		listaCompromissos = query.getResultList();
		return listaCompromissos;
	}

}
