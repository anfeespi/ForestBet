package co.edu.unbosque.forestbet.master.repository;

import java.util.List;

public interface CrudRepository<T, I>{
	void create(T t);
	void update(T t, I i);
	void delete(I i);
	T findById(I i);
	int retById(I i);
	List<T> findAll();
}
