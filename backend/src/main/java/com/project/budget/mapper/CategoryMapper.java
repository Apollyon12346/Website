package com.project.budget.mapper;

import com.project.budget.domain.CreateCategoryRequest;
import com.project.budget.domain.dto.CategoryDto;
import com.project.budget.domain.dto.CreateCategoryRequestDto;
import com.project.budget.domain.entity.BudgetCategory;


public interface CategoryMapper {

    //takes in a createCategoryRequestDto from the API and maps it into a CreateCategoryRequest
    //that can be used by the service layer (createCategoryRequest)
    CreateCategoryRequest fromDto(CreateCategoryRequestDto dto);

    //takes a category object and maps it on the CategoryDto object that is return by API
    CategoryDto toDto(BudgetCategory category);
}
