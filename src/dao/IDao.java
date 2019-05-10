package dao;

import java.util.Collection;

public interface IDao {
	public <T> T add(T entity);

	public <T> T find(Class<T> clazz, Object id);

	public <T> T update(T entity);

	public <T> void remove(Class<T> clazz, Object pk);

	public <T> Collection<T> findAll(Class<T> clazz);
	
	public <T> Collection<T> findByName(String name, Class<T> clazz);
}
