package com.wanchopi.spring.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.wanchopi.spring.entity.Employee;
import com.wanchopi.spring.exception.ResourceNotFoundException;
import com.wanchopi.spring.service.IEmployeeService;

/**
 * Main controller
 * 
 * @author Wanchopi
 *
 */
@Controller
public class EmployeeController {
	
	@Autowired
	private IEmployeeService employeeService;
	
	@InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
	
	@RequestMapping("/")
	public String listEmployees(Model model) {
		List<Employee> employees = employeeService.getAllEmployees();
		model.addAttribute("employees", employees);
		return "index";
	}
	
	@GetMapping("/form")
	public String showFormForAdd(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "employee-form";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@Valid @ModelAttribute("employee") Employee employee,
			BindingResult theBindingResult) {
		if (theBindingResult.hasErrors()) {
			return "employee-form";
		} else {
			employeeService.saveEmployee(employee);
			return "redirect:/";
		}
	}
	
	@GetMapping("/delete")
	public String deleteOne(@RequestParam("id") long id) throws ResourceNotFoundException {
		employeeService.deleteEmployee(id);
		return "redirect:/";
	}
	
	@GetMapping("/update")
	public String showFormForUpdate(@RequestParam("id") long id, 
			Model model) throws ResourceNotFoundException {
		Employee employee = employeeService.getEmployeeById(id);
		model.addAttribute("employee", employee);
		return "employee-update-form";
	}
		
	@PostMapping("/search")
	public ModelAndView search(@RequestParam String keyword) throws ResourceNotFoundException {
		ModelAndView mav = new ModelAndView("search");
		
		List<Employee> result = employeeService.search(keyword);
		mav.addObject("result", result);
		
		return mav;
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	private String handleResourceNotFoundException(ResourceNotFoundException e) {
		return "error";
	}
	
}









