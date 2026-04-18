package com.project.budget.domain.dto;

import java.util.UUID;

//response for API
//no vaildation because this is the API return
public record CategoryDto (
        UUID id,
        String categoryName,
        String categoryName1,
        String description1,
        int budgetcat1,
        String categoryName2,
        String description2,
        int budgetcat2,
        String categoryName3,
        String description3,
        int budgetcat3,
        int totalbudget
){

}
