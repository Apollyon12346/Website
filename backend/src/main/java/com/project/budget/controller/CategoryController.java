package com.project.budget.controller;


import com.project.budget.Service.CategoryService;
import com.project.budget.domain.CreateCategoryRequest;
import com.project.budget.domain.UpdateCategoryRequest;
import com.project.budget.domain.dto.CategoryDto;
import com.project.budget.domain.dto.CreateCategoryRequestDto;
import com.project.budget.domain.dto.UpdateCategoryRequestDto;
import com.project.budget.domain.entity.BudgetCategory;
import com.project.budget.mapper.CategoryMapper;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

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

    @GetMapping
    public ResponseEntity<List<CategoryDto>> listCategories() {
        //get the list of category objects
        List<BudgetCategory> categories = categoryService.listCategories();
        //map category to categorydto
        List<CategoryDto> categoryDtos = categories.stream().map(categoryMapper::toDto).toList();
        //return HTTP 200 response with the list of tasks
        return ResponseEntity.ok(categoryDtos);
    }

    @PutMapping(path = "/{categoryid}")
    public ResponseEntity<CategoryDto> updateCategory(
            @PathVariable UUID categoryid,
            @Valid @RequestBody UpdateCategoryRequestDto updateCategoryRequestDto
            ) {
           UpdateCategoryRequest updateCategoryRequest =  categoryMapper.fromDto(updateCategoryRequestDto);
           BudgetCategory category = categoryService.updateCategory(categoryid, updateCategoryRequest);
           CategoryDto CategoryDto = categoryMapper.toDto(category);
           return ResponseEntity.ok(CategoryDto);
    }
    @DeleteMapping(path = "/{categoryId}")
    public ResponseEntity<CategoryDto> deleteCategory(
            @PathVariable UUID categoryid
    ){
        categoryService.deleteCategory(categoryid);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }





}














