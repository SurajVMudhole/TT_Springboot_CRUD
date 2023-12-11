package com.suraj.tt_crud.controller;

import com.suraj.tt_crud.entity.Department;
import com.suraj.tt_crud.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/departments")
    public Department saveDepartment( @Validated @RequestBody Department department){
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> getalldepartmentList(){
        return departmentService.getalldepartmentList();
    }

    @GetMapping("/departments/{id}")
    public Optional<Department> seedepartmentbyid(@PathVariable("id") Long departmentId){
        return departmentService.seedepartmentbyid(departmentId);
    }
    @DeleteMapping("/departments/{id}")
    public String deletedepartmentbyid(@PathVariable("id") Long departmentId){
        departmentService.deletedepartmentbyid(departmentId);
        return "Deleted Successfully!!";
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId , @RequestBody Department department){
        return departmentService.updateDepartment(departmentId,department);
    }
}
