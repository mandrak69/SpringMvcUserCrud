package rs.engineering.javacourse.springMvcUserCrud.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface IRepository<T> {

	public int save(T p);

	public int update(T p);

	public int delete(long id);

	public T getById(long id);

	public List<T> getAll();

}