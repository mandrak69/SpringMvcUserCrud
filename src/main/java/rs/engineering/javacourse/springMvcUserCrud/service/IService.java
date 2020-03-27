package rs.engineering.javacourse.springMvcUserCrud.service;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public interface IService<T, U> {

	public T findById(long id);

	public void save(T t);

	public void update(T t);

	public void remove(T t);

	public List<T> getAll();

	public T findByObject(T t);

	public T convertToDto(U u);

	public U convertToEntity(T t);

	public boolean validate(T t);

}
