package rs.engineering.javacourse.springMvcUserCrud.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import rs.engineering.javacourse.springMvcUserCrud.dto.CompanyDto;
import rs.engineering.javacourse.springMvcUserCrud.serviceImpl.CompanyService;

@Controller
@RequestMapping(value = "/companies")
public class CompanyController {
	@Autowired
	CompanyService companyService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView home(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView("redirect:/companies/getAll");
		List<CompanyDto> list = companyService.getAll();
		modelAndView.addObject("list", list);
		return modelAndView;
	}

	@RequestMapping("/add")
	public String showform(Model m) {
		m.addAttribute("command", new CompanyDto());
		return "company/add";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("company") CompanyDto company) {
		companyService.save(company);
		return "redirect:/companies/getAll";
	}

	@RequestMapping("/getAll")
	public String viewemp(Model m) {
		List<CompanyDto> list = companyService.getAll();
		m.addAttribute("list", list);
		return "company/getAll";
	}

	@RequestMapping(value = "/editemp/{id}")
	public String edit(@PathVariable int id, Model m) {
		CompanyDto company = companyService.findById(id);
		m.addAttribute("command", company);
		return "company/edit";
	}

	/* It updates model object. */
	@RequestMapping(value = "/editsave", method = RequestMethod.POST)
	public String editsave(@ModelAttribute("company") CompanyDto company) {
		companyService.update(company);
		return "redirect:/companies/getAll";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable int id) {
		companyService.removeById(id);
		return "redirect:/companies/getAll";
	}

	@RequestMapping(value = "/addModel", method = RequestMethod.GET)
	public String addModel(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("action", "Action: add new Company");
		return "company/addModel";
	}

	@ModelAttribute(name = "companyDto")
	public CompanyDto company() {
		return new CompanyDto("Bestragija", "Negde");
	}

	@RequestMapping(value = "/saveModel", method = RequestMethod.POST)
	public String saveModel(@ModelAttribute(name = "user") CompanyDto company) {
		System.out.println(company);
		companyService.save(company);
		return "redirect:/companies/getAll";
	}

}
