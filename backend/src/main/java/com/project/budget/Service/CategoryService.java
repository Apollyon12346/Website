package com.project.budget.Service;

import com.project.budget.domain.CreateCategoryRequest;
import com.project.budget.domain.entity.BudgetCategory;

import java.util.List;

//create the interface for the creating task method
public interface CategoryService {
    BudgetCategory createCategory(CreateCategoryRequest request);
    List<BudgetCategory> listCategories();
}
