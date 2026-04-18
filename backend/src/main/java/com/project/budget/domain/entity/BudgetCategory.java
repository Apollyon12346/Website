package com.project.budget.domain.entity;


import jakarta.persistence.*;

import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "category")
public class BudgetCategory {

    //the @ marks this variable as the ID and generates a unique id
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    //name in database is id, cannot update the id and cannot be null
    @Column(name = "id", updatable = false,nullable = false)
    private UUID id;

    @Column(name = "categoryname",nullable = false)
    private String categoryName;

    //name in database is categoryname, and cannot be null
    @Column(name = "categoryname1",nullable = false)
    private String categoryName1;

    //maxs length of descrption to 1000
    @Column(name = "description1", length = 1000)
    private String description1;

    @Column(name = "budget1")
    private int budgetcat1;

    //name in database is categoryname
    @Column(name = "categoryname2")
    private String categoryName2;

    //maxs length of descrption to 1000
    @Column(name = "description2", length = 1000)
    private String description2;

    @Column(name = "budget2")
    private int budgetcat2;

    //name in database is categoryname
    @Column(name = "categoryname3")
    private String categoryName3;

    //maxs length of descrption to 1000
    @Column(name = "description3", length = 1000)
    private String description3;

    @Column(name = "budget3")
    private int budgetcat3;

    @Column(name = "total_budget")
    private int totalbudget = budgetcat1+budgetcat2+budgetcat3;


    //constructor, getter, and setters
    public BudgetCategory() {
    }

    public BudgetCategory(UUID id, String categoryName, String categoryName1, String description1, int budgetcat1, String categoryName2, String description2, int budgetcat2, String categoryName3, String description3, int budgetcat3, int totalbudget) {
        this.id = id;
        this.categoryName = categoryName;
        this.categoryName1 = categoryName1;
        this.description1 = description1;
        this.budgetcat1 = budgetcat1;
        this.categoryName2 = categoryName2;
        this.description2 = description2;
        this.budgetcat2 = budgetcat2;
        this.categoryName3 = categoryName3;
        this.description3 = description3;
        this.budgetcat3 = budgetcat3;
        this.totalbudget = totalbudget;
    }

    public UUID getId() {
        return id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getCategoryName1() {
        return categoryName1;
    }

    public String getDescription1() {
        return description1;
    }

    public int getBudgetcat1() {
        return budgetcat1;
    }

    public String getCategoryName2() {
        return categoryName2;
    }

    public String getDescription2() {
        return description2;
    }

    public int getBudgetcat2() {
        return budgetcat2;
    }

    public String getCategoryName3() {
        return categoryName3;
    }

    public String getDescription3() {
        return description3;
    }

    public int getBudgetcat3() {
        return budgetcat3;
    }

    public int getTotalbudget() {
        return totalbudget;
    }

    public void setBudgetcat3(int budgetcat3) {
        this.budgetcat3 = budgetcat3;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setDescription3(String description3) {
        this.description3 = description3;
    }

    public void setCategoryName3(String categoryName3) {
        this.categoryName3 = categoryName3;
    }

    public void setBudgetcat2(int budgetcat2) {
        this.budgetcat2 = budgetcat2;
    }

    public void setDescription2(String description2) {
        this.description2 = description2;
    }

    public void setCategoryName2(String categoryName2) {
        this.categoryName2 = categoryName2;
    }

    public void setBudgetcat1(int budgetcat1) {
        this.budgetcat1 = budgetcat1;
    }

    public void setDescription1(String description1) {
        this.description1 = description1;
    }

    public void setCategoryName1(String categoryName1) {
        this.categoryName1 = categoryName1;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setTotalbudget(int totalbudget) {
        this.totalbudget = totalbudget;
    }

    //this makes the equals return true if two object UUID is the same
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        BudgetCategory that = (BudgetCategory) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "BudgetCategory{" +
                "id=" + id +
                ", categoryName='" + categoryName + '\'' +
                ", categoryName1='" + categoryName1 + '\'' +
                ", description1='" + description1 + '\'' +
                ", budgetcat1=" + budgetcat1 +
                ", categoryName2='" + categoryName2 + '\'' +
                ", description2='" + description2 + '\'' +
                ", budgetcat2=" + budgetcat2 +
                ", categoryName3='" + categoryName3 + '\'' +
                ", description3='" + description3 + '\'' +
                ", budgetcat3=" + budgetcat3 +
                ", totalbudget=" + totalbudget +
                '}';
    }
}
