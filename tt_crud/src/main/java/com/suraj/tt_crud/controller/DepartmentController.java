package com.suraj.tt_crud.controller;

import com.suraj.tt_crud.entity.Department;
import com.suraj.tt_crud.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/departments")
    public ResponseEntity<Department> saveDepartment( @Validated @RequestBody Department department){
        return new ResponseEntity<Department>(departmentService.saveDepartment(department),HttpStatus.CREATED) ;
    }

    @GetMapping("/departments")
    public ResponseEntity<List<Department>> getalldepartmentList(){
        return ResponseEntity.ok(departmentService.getalldepartmentList());
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
