package com.suraj.tt_crud.service;

import com.suraj.tt_crud.entity.Department;
import com.suraj.tt_crud.repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepo departmentRepo;
    @Override
    public Department saveDepartment(Department department) {
        return departmentRepo.save(department);
    }

    @Override
    public List<Department> getalldepartmentList() {
        return departmentRepo.findAll();
    }

    @Override
    public Optional<Department> seedepartmentbyid(Long departmentId) {
        return departmentRepo.findById(departmentId);
    }

    @Override
    public void deletedepartmentbyid(Long departmentId) {
        departmentRepo.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {
       Department dbdept=departmentRepo.findById(departmentId).get();
       if(Objects.nonNull(department.getDepartmentId()) && !"".equalsIgnoreCase(department.getDepartmentName())){
           dbdept.setDepartmentName(department.getDepartmentName());
       }
        if(Objects.nonNull(department.getDepartmentId())&&!"".equalsIgnoreCase(department.getDepartmentAddress())){
            dbdept.setDepartmentAddress(department.getDepartmentAddress());
        }
        if(Objects.nonNull(department.getDepartmentId())&&!"".equalsIgnoreCase(department.getDepartmentCode())){
            dbdept.setDepartmentCode(department.getDepartmentCode());
        }
        return departmentRepo.save(dbdept);
    }


}
