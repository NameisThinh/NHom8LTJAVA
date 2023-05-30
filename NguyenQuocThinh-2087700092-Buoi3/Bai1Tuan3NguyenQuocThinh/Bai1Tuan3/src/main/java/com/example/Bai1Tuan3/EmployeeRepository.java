package com.example.Bai1Tuan3;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import com.example.Bai1Tuan3.Employee;
@Repository
public interface EmployeeRepository  extends JpaRepository<Employee,Long>  {
}


