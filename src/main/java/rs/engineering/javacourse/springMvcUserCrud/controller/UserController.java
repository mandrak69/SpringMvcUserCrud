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

import rs.engineering.javacourse.springMvcUserCrud.dto.UserDto;
import rs.engineering.javacourse.springMvcUserCrud.serviceImpl.UserService;

@Controller
@RequestMapping(value = "/users")
public class UserController {
	@Autowired
	UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView home(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView("redirect:/users/getAll");
		List<UserDto> list = userService.getAll();
		modelAndView.addObject("list", list);
		return modelAndView;
	}

	@RequestMapping("/add")
	public String showform(Model m) {
		m.addAttribute("command", new UserDto());
		return "user/add";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("user") UserDto user) {
		userService.save(user);
		return "redirect:/users/getAll";
	}

	@RequestMapping("/getAll")
	public String viewemp(Model m) {
		List<UserDto> list = userService.getAll();
		m.addAttribute("list", list);
		return "user/getAll";
	}

	@RequestMapping(value = "/editemp/{id}")
	public String edit(@PathVariable int id, Model m) {
		UserDto user = userService.findById(id);
		m.addAttribute("command", user);
		return "user/edit";
	}

	/* It updates model object. */
	@RequestMapping(value = "/editsave", method = RequestMethod.POST)
	public String editsave(@ModelAttribute("user") UserDto user) {
		userService.update(user);
		return "redirect:/users/getAll";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable int id) {
		userService.removeById(id);
		return "redirect:/users/getAll";
	}

	@RequestMapping(value = "/addModel", method = RequestMethod.GET)
	public String addModel(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("action", "Action: add new user");
		return "user/addModel";
	}

	@ModelAttribute(name = "userDto")
	public UserDto user() {
		return new UserDto("guest", "guest", "", "");
	}

	@RequestMapping(value = "/saveModel", method = RequestMethod.POST)
	public String saveModel(@ModelAttribute(name = "userDto") UserDto user) {
		System.out.println(user);
		userService.save(user);
		return "redirect:/users/getAll";
	}

}
