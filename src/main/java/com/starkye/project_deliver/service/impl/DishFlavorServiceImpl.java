package com.starkye.project_deliver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.starkye.project_deliver.entity.DishFlavor;
import com.starkye.project_deliver.mapper.DishFlavorMapper;
import com.starkye.project_deliver.service.DishFlavorService;
import org.springframework.stereotype.Service;

@Service
public class DishFlavorServiceImpl extends ServiceImpl<DishFlavorMapper, DishFlavor> implements DishFlavorService {
}
