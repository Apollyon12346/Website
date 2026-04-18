package com.project.budget.controller;


import com.project.budget.Service.CategoryService;
import com.project.budget.domain.CreateCategoryRequest;
import com.project.budget.domain.dto.CategoryDto;
import com.project.budget.domain.dto.CreateCategoryRequestDto;
import com.project.budget.domain.entity.BudgetCategory;
import com.project.budget.mapper.CategoryMapper;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//this is where the API is interacting with backend
@RestController
@RequestMapping(path = "/api/v1/budget")
public class CategoryController {
    private final CategoryService categoryService;
    private final CategoryMapper  categoryMapper;


    public CategoryController(CategoryService categoryService, CategoryMapper categoryMapper) {
        this.categoryService = categoryService;
        this.categoryMapper = categoryMapper;
    }

    //API call to create a category
    //POST call
    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(
            //RequestBody turns the json/xml package from api to a java object
            @RequestBody @Valid CreateCategoryRequestDto dto
    ) {
        //Map the dto to a Create task Request object
            CreateCategoryRequest createCategoryRequest = categoryMapper.fromDto(dto);
            //stores the info into a BudgetCategory Object and adds it into the repo
            BudgetCategory category = categoryService.createCategory(createCategoryRequest);
            //remap the info into a CategoryDto for the API to return
            CategoryDto createdCategoryDto = categoryMapper.toDto(category);
            //returns the info if there is no error
            return new ResponseEntity<>(createdCategoryDto, HttpStatus.CREATED);
    }

    public ResponseEntity<List<CategoryDto>> listCategories() {
        //get the list of category objects
        List<BudgetCategory> categories = categoryService.listCategories();
        //map category to categorydto
        List<CategoryDto> categoryDtos = categories.stream().map(categoryMapper::toDto).toList();
        //return HTTP 200 response with the list of tasks
        return ResponseEntity.ok(categoryDtos);
    }

}














