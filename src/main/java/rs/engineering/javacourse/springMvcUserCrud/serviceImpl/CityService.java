package rs.engineering.javacourse.springMvcUserCrud.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.engineering.javacourse.springMvcUserCrud.repository.impl.CityRepository;
import rs.engineering.javacourse.springMvcUserCrud.service.IService;
import rs.engineering.javacourse.springMvcUserCrud.domain.City;
import rs.engineering.javacourse.springMvcUserCrud.dto.CityDto;



@Service
public class CityService implements IService<CityDto, City> {
	@Autowired
	CityRepository CityDao;
	@Autowired
	private ModelMapper modelMapper;

	public CityService(CityRepository CityDao) {
		super();
		this.CityDao = CityDao;
	}

	public CityService() {

	}

	@Override
	public CityDto convertToDto(City u) {
		CityDto CityDto = modelMapper.map(u, CityDto.class);
		;
		return CityDto;
	}

	@Override
	public City convertToEntity(CityDto t) {

		City City = modelMapper.map(t, City.class);
		return City;
	}

	@Override
	public boolean validate(CityDto t) {
		System.out.println("---- treba implementirati proveru DTO prema Entity objektu");
		return true;
	}

	@Override
	public void save(CityDto CityDto) {
		if (validate(CityDto)) {
			CityDao.save(convertToEntity(CityDto));
		}

	}

	@Override
	public void update(CityDto CityDto) {
		if (validate(CityDto)) {
			CityDao.update(convertToEntity(CityDto));
		}

	}

	@Override
	public void remove(CityDto CityDto) {
		if (validate(CityDto)) {
			CityDao.delete(convertToEntity(CityDto).getId());
		}

	}

	@Override
	public CityDto findByObject(CityDto CityDto) {
		if (validate(CityDto)) {
			City City = CityDao.getById(convertToEntity(CityDto).getId());
			return convertToDto(City);
		} else {
			return null;
		}
	}

	@Override
	public List<CityDto> getAll() {
		List<CityDto> listOfCitysDto = new ArrayList<>();
		List<City> listOfCitys = CityDao.getAll();
		for (City u : listOfCitys) {
			CityDto udto = new CityDto();
			udto = convertToDto(u);
			listOfCitysDto.add(udto);
		}
		return listOfCitysDto;
	}

	@Override
	public CityDto findById(long id) {

		City City = CityDao.getById(id);
		return convertToDto(City);

	}

	public void removeById(int id) {
		CityDao.delete(id);

	}


}
