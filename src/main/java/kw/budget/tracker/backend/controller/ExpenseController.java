package kw.budget.tracker.backend.controller;

import kw.budget.tracker.backend.bean.Expense;
import kw.budget.tracker.backend.repository.ExpenseRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ExpenseController {

    private final ExpenseRepository expensesRepository;

    public ExpenseController(ExpenseRepository expensesRepository) {
        this.expensesRepository = expensesRepository;
    }

    @GetMapping("/api/expenses")
    public List<Expense> getAllExpenses() {
        return expensesRepository.findAll();
    }

    @GetMapping("/api/expenses/{id}")
    public Expense getExpense(@PathVariable Long id) {
        Optional<Expense> expense = expensesRepository.findById(id);

        return expense.get();

    }

    @PostMapping("/api/expenses")
    public Expense addOneExpense(@RequestBody Expense expense) {
        return this.expensesRepository.save(expense);
    }

    @PutMapping("/api/expenses/{id}")
    public void updateExpense(@PathVariable Long id, @RequestBody Expense expense) {
        expensesRepository.save(expense);
    }

    @DeleteMapping("/api/expenses/{id}")
    public void deleteExpense(@PathVariable Long id) {
        expensesRepository.deleteById(id);
    }
}
