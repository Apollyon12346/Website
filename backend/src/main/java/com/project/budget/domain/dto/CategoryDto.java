package com.project.budget.domain.dto;

import java.util.UUID;

//response for API
//no vaildation because this is the API return
public record CategoryDto (
        UUID id,
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
){

}
