package io.devdezyn.peopleops.controller;

import io.devdezyn.peopleops.entity.Employee;
import io.devdezyn.peopleops.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;
    // private List<Employee> employees;
    
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

//    @PostConstruct
//    private void loadEmployees() {
//        // Retrieve employees
//        employees = employeeService.getEmployees();
//    }

    @GetMapping
    public String showEmployeeList(Model model) {
        // Retrieve employees
        List<Employee> employees = employeeService.findAll();

        // Add data to template model
        model.addAttribute("employees", employees);

        return "employees/index";
    }

    @GetMapping("/showCreateEmployeeForm")
    public String showCreateEmployeeForm(Model model) {
        // Create model attribute to bind create employee form data
        Employee employee = new Employee();
        model.addAttribute("employee", employee);

        return "employees/employee-form";
    }

    @GetMapping("/showUpdateEmployeeForm")
    public String showUpdateEmployeeForm(@RequestParam("employeeId") Long id, Model model) {
        // Get the employee from the service
        Employee employee = employeeService.findById(id);

        // Set employee as a model attribute to pre-populate the form
        model.addAttribute("employee", employee);

        return "employees/employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        // Save Employee data
        employeeService.save(employee);

        // Use a redirect to prevent duplicate submissions
        return "redirect:/employees";
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("employeeId") Long id) {
        // Save new Employee
        employeeService.deleteById(id);

        // Redirect to employees list page
        return "redirect:/employees";
    }

    @GetMapping("/search")
    public String searchEmployees(@RequestParam("search") String search,
                         Model theModel) {

        // search employees
        List<Employee> theEmployees = employeeService.findBySearch(search);

        // add to the spring model
        theModel.addAttribute("employees", theEmployees);

        //render employee list page
        return "/employees/index";

    }
}
