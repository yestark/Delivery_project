package com.starkye.project_deliver.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.starkye.project_deliver.entity.Category;

public interface CategoryService extends IService<Category> {
    public void remove(Long ids);
}
