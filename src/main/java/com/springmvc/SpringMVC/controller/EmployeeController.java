package com.springmvc.SpringMVC.controller;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.SpringMVC.entity.Employee;
import com.springmvc.SpringMVC.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {
	private final EmployeeService employeeService;
	
	@GetMapping()
    public String list(Model model) {
        model.addAttribute("employees", employeeService.getAll());
        return "employee-list";
    }
	
	@GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "employee-form";
    }

    @PostMapping
    public String save(@ModelAttribute("employee") Employee emp,
                       @RequestParam("dobStr") String dobStr) {
    	if (dobStr != null && !dobStr.isBlank()) {
            emp.setDob(
                java.time.LocalDate.parse(dobStr)
                    .atStartOfDay(java.time.ZoneId.systemDefault())
                    .toInstant()
            );
        }
        employeeService.create(emp);
        return "redirect:/api/employees";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("employee", employeeService.getById(id));
        return "employee-form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
    	employeeService.delete(id);
        return "redirect:/api/employees";
    }
}
