package com.project.budget.mapper.Impl;

import com.project.budget.domain.CreateCategoryRequest;
import com.project.budget.domain.UpdateCategoryRequest;
import com.project.budget.domain.dto.CategoryDto;
import com.project.budget.domain.dto.CreateCategoryRequestDto;
import com.project.budget.domain.dto.UpdateCategoryRequestDto;
import com.project.budget.domain.entity.BudgetCategory;
import com.project.budget.mapper.CategoryMapper;
import org.springframework.stereotype.Component;

//implementation of the mapper class
@Component
public class CategoryMapperImpl implements CategoryMapper {

    //creates a CreateCategoryRequest object from the info gathered by API
    @Override
    public CreateCategoryRequest fromDto(CreateCategoryRequestDto dto) {
        return new CreateCategoryRequest(
                dto.categoryName(),
                dto.categoryName1(),
                dto.description1(),
                dto.budgetcat1(),
                dto.categoryName2(),
                dto.description2(),
                dto.budgetcat2(),
                dto.categoryName3(),
                dto.description3(),
                dto.budgetcat3(),
                dto.totalbudget()
        );
    }

    //Create an object that the API returns from the category object
    @Override
    public CategoryDto toDto(BudgetCategory category) {
        return new CategoryDto(
                category.getId(),
                category.getCategoryName(),
                category.getCategoryName1(),
                category.getDescription1(),
                category.getBudgetcat1(),
                category.getCategoryName2(),
                category.getDescription2(),
                category.getBudgetcat2(),
                category.getCategoryName3(),
                category.getDescription3(),
                category.getBudgetcat3(),
                category.getTotalbudget()
        );
    }

    @Override
    public UpdateCategoryRequest fromDto(UpdateCategoryRequestDto dto) {
        return new UpdateCategoryRequest(
                dto.categoryName(),
                dto.categoryName1(),
                dto.description1(),
                dto.budgetcat1(),
                dto.categoryName2(),
                dto.description2(),
                dto.budgetcat2(),
                dto.categoryName3(),
                dto.description3(),
                dto.budgetcat3()
        );
    }
}
