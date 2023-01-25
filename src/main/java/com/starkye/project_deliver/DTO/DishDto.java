package com.starkye.project_deliver.DTO;

import com.starkye.project_deliver.entity.Dish;
import com.starkye.project_deliver.entity.DishFlavor;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class DishDto extends Dish {

    private List<DishFlavor> flavors = new ArrayList<>();

    private String categoryName;

    private Integer copies;
}
