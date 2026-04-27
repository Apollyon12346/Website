package com.project.budget.domain.dto;


import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import org.hibernate.validator.constraints.Length;

//object the API use to create a category/call the service layer
//separate from the CreateCategoryRequest because we want to separate the presentation and service layer
//stores all nesscary info
public record CreateCategoryRequestDto(
        //checks if first title is not null but others can, then checks if the title is less than 255 char
        //checks if the description is less than 1000 char
        //checks if entered balance is greater or equal to 0
        @NotBlank(message = ERROR_MESSAGE_TITLE)
        @Length(max=255,message = ERROR_MESSAGE_TITLE)
        String categoryName,

        @Length(max = 255, message = ERROR_MESSAGE_CATEGORYNAME_LENGTH)
        String categoryName1,

        @Length(max = 100,message =ERROR_MESSAGE_DESCRIPTION_LENGTH)
        @Nullable
        String description1,

        @PositiveOrZero(message = ERROR_MESSAGE_NEGATIVE_BUDGET)
        double budgetcat1,

        @Length(max = 255, message = ERROR_MESSAGE_CATEGORYNAME_LENGTH)
        @Nullable
        String categoryName2,

        @Length(max = 100,message =ERROR_MESSAGE_DESCRIPTION_LENGTH)
        @Nullable
        String description2,

        @PositiveOrZero(message = ERROR_MESSAGE_NEGATIVE_BUDGET)
        double budgetcat2,

        @Length(max = 255, message = ERROR_MESSAGE_CATEGORYNAME_LENGTH)
        String categoryName3,

        @Length(max = 100,message =ERROR_MESSAGE_DESCRIPTION_LENGTH)
        @Nullable
        String description3,

        @PositiveOrZero(message = ERROR_MESSAGE_NEGATIVE_BUDGET)
        double budgetcat3,

        int totalbudget
) {
    private static final String ERROR_MESSAGE_TITLE =
            "Category title must be length between 1 to 255 characters.";
    private static final String ERROR_MESSAGE_CATEGORYNAME_LENGTH =
            "Category name length must be between 1 and 255 characters.";
    private static final String ERROR_MESSAGE_DESCRIPTION_LENGTH =
            "Description length must be less than 1000 characters.";
    private static final String ERROR_MESSAGE_NEGATIVE_BUDGET =
            "Budget amount must be greater than 0.";
}
