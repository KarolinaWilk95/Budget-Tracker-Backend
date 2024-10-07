package kw.budget.tracker.backend.repository;


import kw.budget.tracker.backend.bean.Income;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncomeRepository extends JpaRepository<Income, Long>{


}
