package com.starkye.project_deliver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.starkye.project_deliver.DTO.SetmealDto;
import com.starkye.project_deliver.entity.SetmealDish;
import com.starkye.project_deliver.mapper.SetmealDishMapper;
import com.starkye.project_deliver.service.SetmealDishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class SetmealDishServiceImpl extends ServiceImpl<SetmealDishMapper, SetmealDish> implements SetmealDishService {


}
