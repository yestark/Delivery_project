package com.starkye.project_deliver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.starkye.project_deliver.entity.Dish;
import com.starkye.project_deliver.mapper.DishMapper;
import com.starkye.project_deliver.service.DishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DishServiceImpl extends ServiceImpl<DishMapper, Dish> implements DishService {
}
