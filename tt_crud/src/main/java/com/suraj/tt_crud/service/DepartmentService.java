package com.suraj.tt_crud.service;

import com.suraj.tt_crud.entity.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
   public Department saveDepartment(Department department);
   public List<Department>  getalldepartmentList();


   public Optional<Department> seedepartmentbyid(Long departmentId);

   public void deletedepartmentbyid(Long departmentId);

   public Department updateDepartment(Long departmentId, Department department);
}
