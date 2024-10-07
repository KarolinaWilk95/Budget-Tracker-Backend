package kw.budget.tracker.backend.controller;

import kw.budget.tracker.backend.bean.Income;
import kw.budget.tracker.backend.repository.IncomeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class IncomeController {

    private final IncomeRepository incomesRepository;

    public IncomeController(IncomeRepository incomesRepository) {
        this.incomesRepository = incomesRepository;
    }

    @GetMapping("/api/incomes")
    public List<Income> getAllIncomes() {
        return incomesRepository.findAll();
    }

    @GetMapping("/api/incomes/{id}")
    public Income getIncome(@PathVariable Long id) {
        Optional<Income> income = incomesRepository.findById(id);

        return income.get();

    }

    @PostMapping("/api/incomes")
    public Income addOneIncome(@RequestBody Income income) {
        return this.incomesRepository.save(income);
    }

    @PutMapping("/api/incomes/{id}")
    public void updateIncomes(@PathVariable Long id, @RequestBody Income income) {
        incomesRepository.save(income);
    }

    @DeleteMapping("/api/incomes/{id}")
    public void deleteIncome(@PathVariable Long id) {
        incomesRepository.deleteById(id);
    }
}
