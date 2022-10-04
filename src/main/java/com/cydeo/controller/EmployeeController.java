package com.cydeo.controller;

import com.cydeo.bootstrap.DataGenerator;
import com.cydeo.model.Employee;
import com.cydeo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/register")
    public String createEmployee(Model model) {

        model.addAttribute("employee", new Employee());
        model.addAttribute("stateList", DataGenerator.getAllStates());

        return "employee/employee-create";

    }

    @PostMapping("/insert")
    public String insertEmployee(@ModelAttribute("employee") @Valid Employee employee, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("stateList", DataGenerator.getAllStates());
            return "employee/employee-create";
        }

        employeeService.saveEmployee(employee);
        return "redirect:/employee/list";   // With redirect we are using endpoints
    }

    @GetMapping("/list")
    public String listEmployees(Model model) {
        model.addAttribute("employeeList", employeeService.readAllEmployees());
        return "employee/employee-list";   // Without redirect we are using html file paths
    }

}
/*

@PostMapping("/insert")
public String insertEmployee(@ModelAttribute("employee") Employee employee) {
employeeService.saveEmployee(employee);
return "redirect:/employee/list";   // It is redirecting to method NOT to html file
redirect use end point NOT html file
}

@GetMapping("/list")
public String listEmployees(Model model) {
model.addAttribute("employeeList", employeeService.readAllEmployees());
return "employee/employee-list";

Without redirecting we are using html file paths
we read all list with readAllEmployee method ad use that method inside /insert
with this GetMapping
}

Once we click Register I want to save data in List with saveEmployee(employee) method then I want to go
page where I see list, or employee that I created inside form. If I directly go to employee/employee-list.html
instead of redirect:/employee/list then I won't be able to see any list/data in that employee list form table
because we separated model.addAttribute("employeeList", employeeService.readAllEmployees()); part which is
carrying data to our view list




*/