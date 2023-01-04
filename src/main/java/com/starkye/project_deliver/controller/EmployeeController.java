package com.starkye.project_deliver.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.starkye.project_deliver.common.R;
import com.starkye.project_deliver.entity.Employee;
import com.starkye.project_deliver.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@Slf4j
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /**
     * 员工登录
     * @param request
     * @param employee
     * @return
     */
    @PostMapping("/login")
    public R<Employee> login(HttpServletRequest request, @RequestBody Employee employee){
        /**
         * 1.将页面提交的密码进行md5加密处理
         * 2.根据页面提交的用户名查询数据库
         * 3.如果没有查询到贼返回登录失败结果
         * 4.密码比对,如果不一致则返回登录失败结果
         * 5.查看员工状态,如果为禁用状态,则返回员工已禁用结果
         * 6.登录成功,将员工ID存入session并返回登录成功结果
         */

        //1.将页面提交的密码进行md5加密处理
        String password = employee.getPassword();
        password = DigestUtils.md5DigestAsHex(password.getBytes());

        //2.根据页面提交的用户名查询数据库
        LambdaQueryWrapper<Employee> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Employee::getUsername,employee.getUsername());
        Employee emp = employeeService.getOne(queryWrapper);

        //3.如果没有查询到贼返回登录失败结果
        if (emp == null){
            return R.error("login fail");
        }

        //4.密码比对,如果不一致则返回登录失败结果
        if (!emp.getPassword().equals(password)){
            return R.error("login fail");
        }

        //5.查看员工状态,如果为禁用状态,则返回员工已禁用结果
        //0是禁用
        if (emp.getStatus() == 0){
            return R.error("account locked");
        }

        //6.登录成功,将员工ID存入session并返回登录成功结果
        request.getSession().setAttribute("employee",emp.getId());
        return R.success(emp);
    }

    /**
     * LOG OUT
     * @param request
     * @return
     */
    @PostMapping("/logout")
    public R<String> logout(HttpServletRequest request){
        // 清理session中保存的当前员工的ID
        request.getSession().removeAttribute("employee");
        return R.success("Logout successful");
    }

    /**
     * 新增员工
     * @param employee
     * @return
     */
    @PostMapping
    public R<String> save(HttpServletRequest request, @RequestBody Employee employee){
        log.info("新增员工,员工信息:{}",employee.toString());

        //设置初始密码123456,需要进行md5加密处理
        employee.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));

        employee.setCreateTime(LocalDateTime.now());
        employee.setUpdateTime(LocalDateTime.now());

        //获得当前登录用户的ID
        Long empID = (Long) request.getSession().getAttribute("employee");

        employee.setCreateUser(empID);
        employee.setUpdateUser(empID);

        employeeService.save(employee);

        return R.success("添加员工成功");
    }
}
