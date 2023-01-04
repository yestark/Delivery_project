package com.starkye.project_deliver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.starkye.project_deliver.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {
}
