package com.starkye.project_deliver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.starkye.project_deliver.entity.Setmeal;
import com.starkye.project_deliver.mapper.SetmealMapper;
import com.starkye.project_deliver.service.SetmealService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SetmealServiceImpl extends ServiceImpl<SetmealMapper, Setmeal> implements SetmealService {
}
