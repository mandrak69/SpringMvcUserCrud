package rs.engineering.javacourse.springMvcUserCrud.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.engineering.javacourse.springMvcUserCrud.domain.Company;
import rs.engineering.javacourse.springMvcUserCrud.dto.CompanyDto;
import rs.engineering.javacourse.springMvcUserCrud.repository.impl.CompanyRepository;
import rs.engineering.javacourse.springMvcUserCrud.service.IService;



@Service
public class CompanyService implements IService<CompanyDto, Company> {
	@Autowired
	CompanyRepository companyDao;
	@Autowired
	private ModelMapper modelMapper;

	public CompanyService(CompanyRepository companyDao) {
		super();
		this.companyDao = companyDao;
	}

	public CompanyService() {

	}

	@Override
	public CompanyDto convertToDto(Company u) {
		CompanyDto CompanyDto = modelMapper.map(u, CompanyDto.class);
		;
		return CompanyDto;
	}

	@Override
	public Company convertToEntity(CompanyDto t) {

		Company Company = modelMapper.map(t, Company.class);
		return Company;
	}

	@Override
	public boolean validate(CompanyDto t) {
		System.out.println("---- treba implementirati proveru DTO prema Entity objektu");
		return true;
	}

	@Override
	public void save(CompanyDto CompanyDto) {
		if (validate(CompanyDto)) {
			companyDao.save(convertToEntity(CompanyDto));
		}

	}

	@Override
	public void update(CompanyDto CompanyDto) {
		if (validate(CompanyDto)) {
			companyDao.update(convertToEntity(CompanyDto));
		}

	}

	@Override
	public void remove(CompanyDto CompanyDto) {
		if (validate(CompanyDto)) {
			companyDao.delete(convertToEntity(CompanyDto).getId());
		}

	}

	@Override
	public CompanyDto findByObject(CompanyDto CompanyDto) {
		if (validate(CompanyDto)) {
			Company Company = companyDao.getById(convertToEntity(CompanyDto).getId());
			return convertToDto(Company);
		} else {
			return null;
		}
	}

	@Override
	public List<CompanyDto> getAll() {
		List<CompanyDto> listOfCompanysDto = new ArrayList<>();
		List<Company> listOfCompanys = companyDao.getAll();
		for (Company u : listOfCompanys) {
			CompanyDto udto = new CompanyDto();
			udto = convertToDto(u);
			listOfCompanysDto.add(udto);
		}
		return listOfCompanysDto;
	}

	@Override
	public CompanyDto findById(long id) {

		Company Company = companyDao.getById(id);
		return convertToDto(Company);

	}

	public void removeById(int id) {
		companyDao.delete(id);

	}

}