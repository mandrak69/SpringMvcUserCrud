package rs.engineering.javacourse.springMvcUserCrud.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;

import rs.engineering.javacourse.springMvcUserCrud.domain.User;
import rs.engineering.javacourse.springMvcUserCrud.repository.IRepository;

@Controller
public class UserRepository implements IRepository<User> {
	@Autowired
	DbUtil template;
	
	public UserRepository(DbUtil template) {
		super();
		this.template = template;
	}

	public UserRepository() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void setTemplate(DbUtil template) {
		this.template = template;
	}

	public int save(User p) {
		String sql = "insert into User (firstname,lastname,username,password) values(?,?,?,?)";

		return template.getConn().update(sql, p.getFirstname(), p.getLastname(), p.getUsername(), p.getPassword());
	}

	public int update(User p) {
		String sql = "update User set firstname=? , lastname=? , username=?, password=? where id=?";

		return template.getConn().update(sql, p.getFirstname(), p.getLastname(), p.getUsername(), p.getPassword(), p.getId());
	}

	public int delete(long id) {
		String sql = "delete from User where id=" + id + "";
		return template.getConn().update(sql);
	}

	public User getById(long id) {
		String sql = "select * from User where id=?";
		return template.getConn().queryForObject(sql, new Object[] { id }, new BeanPropertyRowMapper<User>(User.class));
	}

	public List<User> getAll() {
		return template.getConn().query("select * from User", new RowMapper<User>() {
			public User mapRow(ResultSet rs, int row) throws SQLException {
				User e = new User();
				e.setId(rs.getLong(1));
				e.setFirstname(rs.getString(2));
				e.setLastname(rs.getString(3));
				e.setUsername(rs.getString(4));

				e.setPassword(rs.getString(5));
				return e;
			}
		});
	}

	

	

	
}