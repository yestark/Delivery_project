package com.starkye.project_deliver.DTO;


import com.starkye.project_deliver.entity.Setmeal;
import com.starkye.project_deliver.entity.SetmealDish;
import lombok.Data;
import java.util.List;

@Data
public class SetmealDto extends Setmeal {

    private List<SetmealDish> setmealDishes;

    private String categoryName;
}
