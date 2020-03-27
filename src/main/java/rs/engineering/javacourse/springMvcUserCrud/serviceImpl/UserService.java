package rs.engineering.javacourse.springMvcUserCrud.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.engineering.javacourse.springMvcUserCrud.domain.User;
import rs.engineering.javacourse.springMvcUserCrud.dto.UserDto;
import rs.engineering.javacourse.springMvcUserCrud.repository.impl.UserRepository;
import rs.engineering.javacourse.springMvcUserCrud.service.IService;

@Service
public class UserService implements IService<UserDto, User> {
	@Autowired
	UserRepository userDao;
	@Autowired
	private ModelMapper modelMapper;

	public UserService(UserRepository userDao) {
		super();
		this.userDao = userDao;
	}

	public UserService() {

	}

	@Override
	public UserDto convertToDto(User u) {
		UserDto userDto = modelMapper.map(u, UserDto.class);
		;
		return userDto;
	}

	@Override
	public User convertToEntity(UserDto t) {

		User user = modelMapper.map(t, User.class);
		return user;
	}

	@Override
	public boolean validate(UserDto t) {
		System.out.println("---- treba implementirati proveru DTO prema Entity objektu");
		return true;
	}

	@Override
	public void save(UserDto userDto) {
		if (validate(userDto)) {
			userDao.save(convertToEntity(userDto));
		}

	}

	@Override
	public void update(UserDto userDto) {
		if (validate(userDto)) {
			userDao.update(convertToEntity(userDto));
		}

	}

	@Override
	public void remove(UserDto userDto) {
		if (validate(userDto)) {
			userDao.delete(convertToEntity(userDto).getId());
		}

	}

	@Override
	public UserDto findByObject(UserDto userDto) {
		if (validate(userDto)) {
			User user = userDao.getById(convertToEntity(userDto).getId());
			return convertToDto(user);
		} else {
			return null;
		}
	}

	@Override
	public List<UserDto> getAll() {
		List<UserDto> listOfUsersDto = new ArrayList<>();
		List<User> listOfUsers = userDao.getAll();
		for (User u : listOfUsers) {
			UserDto udto = new UserDto();
			udto = convertToDto(u);
			listOfUsersDto.add(udto);
		}
		return listOfUsersDto;
	}

	@Override
	public UserDto findById(long id) {

		User user = userDao.getById(id);
		return convertToDto(user);

	}

	public void removeById(int id) {
		userDao.delete(id);

	}

}