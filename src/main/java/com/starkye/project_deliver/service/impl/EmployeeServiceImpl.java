package com.starkye.project_deliver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.starkye.project_deliver.entity.Employee;
import com.starkye.project_deliver.mapper.EmployeeMapper;
import com.starkye.project_deliver.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {
}
