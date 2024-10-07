package kw.budget.tracker.backend.repository;


import kw.budget.tracker.backend.bean.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Long>{


}
