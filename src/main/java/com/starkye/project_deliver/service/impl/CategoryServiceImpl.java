package com.starkye.project_deliver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.starkye.project_deliver.common.CustomException;
import com.starkye.project_deliver.entity.Category;
import com.starkye.project_deliver.entity.Dish;
import com.starkye.project_deliver.entity.Setmeal;
import com.starkye.project_deliver.mapper.CategoryMapper;
import com.starkye.project_deliver.service.CategoryService;
import com.starkye.project_deliver.service.DishService;
import com.starkye.project_deliver.service.SetmealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Autowired
    private DishService dishService;

    @Autowired
    private SetmealService setmealService;

    /**
     * 根据ID删除分类,删除之前需要进行判断
     * @param id
     */
    @Override
    public void remove(Long ids) {

        //查询当前分类是否关联了菜品.如果已经关联,直接抛出一个业务异常
        LambdaQueryWrapper<Dish> dishLambdaQueryWrapper = new LambdaQueryWrapper<>();
        //添加查询条件,根据分类ID进行查询
        dishLambdaQueryWrapper.eq(Dish::getCategoryId,ids);
        int CountDish = dishService.count(dishLambdaQueryWrapper);
        if (CountDish > 0){
            //已经关联菜品,抛出一个业务异常
            throw new CustomException("当前分类下关联了菜品.不能删除");
        }

        //查询当前分类是否关联了套餐.如果已经关联,直接抛出一个业务异常
        LambdaQueryWrapper<Setmeal> setmealLambdaQueryWrapper = new LambdaQueryWrapper<>();
        //添加查询条件,根据分类ID进行查询
        setmealLambdaQueryWrapper.eq(Setmeal::getCategoryId,ids);
        int CountSetmeal = setmealService.count(setmealLambdaQueryWrapper);
        if (CountSetmeal > 0){
            //已经关联套餐,抛出一个业务异常
            throw new CustomException("当前分类下关联了套餐.不能删除");
        }

        //正常删除
        super.removeById(ids);
    }
}
