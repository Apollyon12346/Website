package com.project.budget.Service.impl;

import com.project.budget.Service.CategoryService;
import com.project.budget.domain.CreateCategoryRequest;
import com.project.budget.domain.entity.BudgetCategory;
import com.project.budget.repository.CategoryRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;


@Service
public class CategoryServiceImpl implements CategoryService{
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    //function accepts the createcategoryrequest record that has all the info
    @Override
    public BudgetCategory createCategory(CreateCategoryRequest request) {
        //create a new category with the info
        BudgetCategory category = new BudgetCategory(
                //id is null because it generates a unique one by itself
                null,
                request.categoryName(),
                request.categoryName1(),
                request.description1(),
                request.budgetcat1(),
                request.categoryName2(),
                request.description2(),
                request.budgetcat2(),
                request.categoryName3(),
                request.description3(),
                request.budgetcat3(),
                request.totalbudget()
        );
        //save it to the repo
    return categoryRepository.save(category);
    }

    @Override
    public List<BudgetCategory> listCategories() {
        return categoryRepository.findAll(Sort.by(Sort.Direction.DESC, "categoryName"));
    }
}
