package dao;

import java.util.List;

public interface DAO<T> {
	public abstract T getById(int id);
	public abstract List<T> getAll();
	public abstract void create(T objet);
	public abstract void update(T objet);
	public abstract void delete(T objet);
}
