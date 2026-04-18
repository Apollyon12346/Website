package com.project.budget.repository;

import com.project.budget.domain.entity.BudgetCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

//creates the repository
@Repository
public interface CategoryRepository extends JpaRepository<BudgetCategory, UUID> {
}
