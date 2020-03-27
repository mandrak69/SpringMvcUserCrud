package rs.engineering.javacourse.springMvcUserCrud.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import rs.engineering.javacourse.springMvcUserCrud.domain.City;
import rs.engineering.javacourse.springMvcUserCrud.repository.IRepository;

@Repository

public class CityRepository implements IRepository<City> {
	@Autowired
	DbUtil template;
	
	public CityRepository(DbUtil template) {
		super();
		this.template = template;
	}

	public CityRepository() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setTemplate(DbUtil template) {
		this.template = template;
	}
	
	
	public int save(City p) {
		String sql = "insert into City (number,name) values(?,?)";

		return template.getConn().update(sql, p.getNumber(), p.getName());
	}

	public int update(City p) {
		String sql = "update City set number=? , name=?  where id=?";

		return template.getConn().update(sql, p.getNumber(), p.getName(), p.getId());
	}

	public int delete(long id) {
		String sql = "delete from City where id=" + id + "";
		return template.getConn().update(sql);
	}

	public City getById(long id) {
		String sql = "select * from City where id=?";
		return template.getConn().queryForObject(sql, new Object[] { id }, new BeanPropertyRowMapper<City>(City.class));
	}

	public List<City> getAll() {
		return template.getConn().query("select * from City", new RowMapper<City>() {
			public City mapRow(ResultSet rs, int row) throws SQLException {
				City e = new City();
				e.setId(rs.getLong(1));
				e.setName(rs.getString(2));
				e.setNumber(rs.getString(3));

				return e;
			}
		});
	}

	

	

	
}