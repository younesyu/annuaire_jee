package projet;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Repository
@Transactional
public class Dao implements IDao {
	@PersistenceContext(type = PersistenceContextType.TRANSACTION)
	EntityManager em;

	public <T> T add(T entity) {
		em.persist(entity);
		return (entity);
	}

	public <T> T find(Class<T> clazz, Object id) {
		return em.find(clazz, id);
	}

	public <T> T update(T entity) {
		entity = em.merge(entity);
		return entity;
	}

	public <T> void remove(Class<T> clazz, Object pk) {
		T entity = em.find(clazz, pk);
		if (entity != null) {
			em.remove(entity);
		}
	}

	public <T> Collection<T> findAll(Class<T> clazz) {
		TypedQuery<T> q = em.createQuery("select r from " + clazz.getSimpleName() + " r", clazz);
		return q.getResultList();
	}
}
