package lacerda.luhan.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

public class DAOGeneric<Entity> {

	private EntityManagerFactory entityManagerFactory;
	private Class<Entity> persistentClass;

	@SuppressWarnings("unchecked")
	public DAOGeneric(EntityManagerFactory emf) {
		this.setEntityManagerFactory(emf);
		this.entityManagerFactory = emf;
		ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();
		persistentClass = (Class<Entity>) parameterizedType.getActualTypeArguments()[0];
	}

	/**
	 * Executa o merge do objeto que se encontra em mem�ria.
	 * 
	 * @param objeto
	 *            a ser realizado o merge
	 * @return objeto que foi executado o merge
	 */
	public Entity update(Entity objeto) {

		EntityManager em = this.entityManagerFactory.createEntityManager();

		EntityTransaction tx = em.getTransaction();
		tx.begin();

		objeto = em.merge(objeto);

		tx.commit();

		em.close();

		return objeto;
	}

	@SuppressWarnings("unchecked")
	public final List<Entity> getAll() {
		List<Entity> instance = null;
		EntityManager em = this.entityManagerFactory.createEntityManager();
		try {
			instance = ((List<Entity>) em.createQuery("from " + getPersistentClass().getName()).getResultList());
		} catch (RuntimeException re) {
			re.printStackTrace();
		}
		em.close();
		return instance;
	}

	/**
	 * Salva o objeto atual na base de dados.
	 * 
	 * @param objeto
	 *            a ser salvo
	 */
	public void insert(Entity objeto) {
		EntityManager em = this.entityManagerFactory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(objeto);
			tx.commit();
			em.close();
		} catch (PersistenceException e) {
			tx.rollback();
		}
	}

	/**
	 * Salva o objeto atual na base de dados.
	 * 
	 * @param objeto
	 *            a ser salvo
	 */
	public final void insertCollection(Collection<Entity> colecao) {
		EntityManager em = this.entityManagerFactory.createEntityManager();
		try {
			EntityTransaction tx = em.getTransaction();
			tx.begin();

			for (Entity entidade : colecao) {
				em.persist(entidade);
			}

			tx.commit();

			em.close();
		} catch (PersistenceException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Remove o objeto da base de dados.
	 * 
	 * @param objeto
	 *            a ser removido
	 */
	public final void remove(Entity objeto) {
		EntityManager em = this.entityManagerFactory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		// Este merge foi incluido para permitir a exclusao de objetos no estado
		// Detached
		objeto = em.merge(objeto);

		em.remove(objeto);

		tx.commit();

		em.close();
	}

	/**
	 * Busca o objeto uma vez passado sua chave como par�metro.
	 * 
	 * @param chave
	 *            identificador
	 * @return Objeto do tipo T
	 */
	public final Entity searchByKey(Serializable chave) {
		Entity instance = null;
		EntityManager em = this.entityManagerFactory.createEntityManager();
		try {
			instance = (Entity) em.find(getPersistentClass(), chave);
		} catch (RuntimeException re) {
			re.printStackTrace();
		}
		em.close();
		return instance;
	}

	/**
	 * Atualiza o objeto que se encontra em mem�ria.
	 * 
	 * @param object
	 *            objeto a ser atualizado
	 */
	public final void refresh(Entity object) {
		EntityManager em = this.entityManagerFactory.createEntityManager();
		em.refresh(object);
		em.close();
	}

	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}

	public Class<Entity> getPersistentClass() {
		return persistentClass;
	}

	public void setPersistentClass(Class<Entity> persistentClass) {
		this.persistentClass = persistentClass;
	}
	
	protected String getTableName(Entity entity) {
		return entity.getClass().getSimpleName();
	}
	
}
