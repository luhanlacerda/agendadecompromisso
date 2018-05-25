package lacerda.luhan.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public abstract class DAOFactory {

	private static final EntityManagerFactory factory;

	static {
		factory = Persistence.createEntityManagerFactory("ProjetoAgenda");
	}

	public static DAOCompromisso getCompromissoDAO() {
		DAOCompromisso dao = new DAOCompromisso(factory);
		return dao;
	}
}
