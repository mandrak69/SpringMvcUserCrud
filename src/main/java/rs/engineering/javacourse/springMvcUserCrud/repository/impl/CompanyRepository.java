package rs.engineering.javacourse.springMvcUserCrud.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;

import rs.engineering.javacourse.springMvcUserCrud.domain.Company;
import rs.engineering.javacourse.springMvcUserCrud.repository.IRepository;

@Controller
public class CompanyRepository implements IRepository<Company> {
	@Autowired
	DbUtil template;
	
	
	public CompanyRepository(DbUtil template) {
		super();
		this.template = template;
	}

	public CompanyRepository() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public void setTemplate(DbUtil template) {
		this.template = template;
	}
	

	public int save(Company p) {
		String sql = "insert into Company (name,address) values(?,?)";

		return template.getConn().update(sql, p.getName(), p.getAddress());
	}

	public int update(Company p) {
		String sql = "update Company set name=? , address=?  where id=?";

		return template.getConn().update(sql, p.getName(), p.getAddress(), p.getId());
	}

	public int delete(long id) {
		String sql = "delete from Company where id=" + id + "";
		return template.getConn().update(sql);
	}

	public Company getById(long id) {
		String sql = "select * from Company where id=?";
		return template.getConn().queryForObject(sql, new Object[] { id }, new BeanPropertyRowMapper<Company>(Company.class));
	}

	public List<Company> getAll() {
		return template.getConn().query("select * from Company", new RowMapper<Company>() {
			public Company mapRow(ResultSet rs, int row) throws SQLException {
				Company e = new Company();
				e.setId(rs.getLong(1));
				e.setName(rs.getString(2));
				e.setAddress(rs.getString(3));
				return e;
			}
		});
	}

	

	

	
}