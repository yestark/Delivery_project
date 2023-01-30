package com.starkye.project_deliver.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.starkye.project_deliver.DTO.SetmealDto;
import com.starkye.project_deliver.entity.Setmeal;

public interface SetmealService extends IService<Setmeal> {
    /**
     * 新增套餐,同时需要保存套餐和菜品的关联关系
     * @param setmealDto
     */
    public void saveWithDish(SetmealDto setmealDto);
}
