package rs.engineering.javacourse.springMvcUserCrud.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import rs.engineering.javacourse.springMvcUserCrud.dto.CityDto;
import rs.engineering.javacourse.springMvcUserCrud.serviceImpl.CityService;



@Controller
@RequestMapping(value = "/city")
public class CityController {
	private final CityService cityService;
	
	CityController(CityService cityService){
		this.cityService = cityService;
	}
	
	@GetMapping
	public String home() {
		System.out.println("====================================================================");
		System.out.println("====================   CityController: home()    ===================");
		System.out.println("====================================================================");
		return "city/home";
	}
	/*
	@GetMapping(value = "add")
	public String add(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("====================================================================");
		System.out.println("====================   CityController: add()     ===================");
		System.out.println("====================================================================");
		CityDto cityDto = new CityDto(0l, "-");
		request.setAttribute("cityDto", cityDto);
		return "city/add";
	}
	*/
	
	@GetMapping(value = "add")
	public ModelAndView add(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("====================================================================");
		System.out.println("====================   CityController: add()     ===================");
		System.out.println("====================================================================");
		ModelAndView modelAndView = new ModelAndView("city/add");
		
		CityDto cityDto = new CityDto(0l, "N/A");
		modelAndView.addObject("cityDto",cityDto);
		
		return modelAndView;
	}
	
	
	/*
	@PostMapping(value = "save")
	public String save(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("====================================================================");
		System.out.println("====================   CityController: save()    ===================");
		System.out.println("====================================================================");
		
		Long number = Long.parseLong(request.getParameter("number"));
		String name = request.getParameter("name");
		
		CityDto cityDto = new CityDto(number,name);
		
		System.out.println(cityDto);
		return "redirect:/city/add";
	}
	*/
	
	/*
	@PostMapping(value = "save")
	public String save(@RequestParam(name="number") Long number,@RequestParam(name="name") String name) {
		System.out.println("====================================================================");
		System.out.println("====================   CityController: save()    ===================");
		System.out.println("====================================================================");
		
		CityDto cityDto = new CityDto(number,name);
		
		System.out.println(cityDto);
		return "redirect:/city/add";
		
	}
	*/
	
	@PostMapping(value = "save")
	//public String save(@ModelAttribute(name="cityDto") CityDto cityDto) {
	public String save (CityDto cityDto) {
		System.out.println("===================================================================================");
		System.out.println("====================   CityController: save(@ModelAttribute)    ===================");
		System.out.println("===================================================================================");
		
		System.out.println(cityDto);
		
		cityService.save(cityDto);
		
		return "redirect:/city/add";
		
	}
	
}
