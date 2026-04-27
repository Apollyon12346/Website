package com.project.budget.domain;

//stores all the info we need to create a new category
public record CreateCategoryRequest(
        String categoryName,
        String categoryName1,
        String description1,
        double budgetcat1,
        String categoryName2,
        String description2,
        double budgetcat2,
        String categoryName3,
        String description3,
        double budgetcat3,
        double totalbudget
) {

}
