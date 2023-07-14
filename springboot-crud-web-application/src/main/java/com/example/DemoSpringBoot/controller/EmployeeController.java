package com.example.DemoSpringBoot.controller;

import com.example.DemoSpringBoot.model.Employee;
import com.example.DemoSpringBoot.services.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {

    private final EmployeeServiceImpl employeeService;

    @Autowired
    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public String viewHomePage(Model model) {
        return findPaginated(1,"firstName","asc", model);
    	
    }

    @GetMapping("/showNewEmployeeForm")
    public String showNewEmployeeForm(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "new_employee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") Long id, Model model) {
        Employee employee = employeeService.getEmployeeByID(id);
        model.addAttribute("employee", employee);
        return "update_employee";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable(value = "id") Long id) {
        employeeService.deleteEmployeeById(id);
        return "redirect:/";
    }
    
    // /page /1?sortField=name&sortDir=asc
    
    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") Integer pageNo,
    		@RequestParam("sortField") String sortField,
    		@RequestParam("sortDir") String sortDir,
    		Model model) {
        Integer pageSize = 5;
        Page<Employee> page = employeeService.findPaginated(pageNo, pageSize,sortField,sortDir);
        List<Employee> listEmployees = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());      
        model.addAttribute("listEmployee", listEmployees);
        
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ?"desc":"asc");

        return "index";
    }
    
}
