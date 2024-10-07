package kw.budget.tracker.backend.controller;

import kw.budget.tracker.backend.bean.Expense;
import kw.budget.tracker.backend.bean.Income;
import kw.budget.tracker.backend.repository.ExpenseRepository;
import kw.budget.tracker.backend.repository.IncomeRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class BalanceController {

    private final ExpenseRepository expenseRepository;
    private final IncomeRepository incomeRepository;

    public BalanceController(ExpenseRepository expenseRepository, IncomeRepository incomeRepository) {
        this.expenseRepository = expenseRepository;
        this.incomeRepository = incomeRepository;
    }

    //THE DIFFERENCE
    @GetMapping("/balance")
    public BigDecimal getBalance() {
        //get expenses

        List<Expense> expenses = expenseRepository.findAll();

        //get incomes

        List<Income> incomes = incomeRepository.findAll();
        //calculate

        BigDecimal sumOfExpenses = expenses.stream()
                .map(Expense::getAmountOfMoney)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal sumOfIncomes = incomes.stream()
                .map(Income::getAmountOfMoney)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return sumOfIncomes.subtract(sumOfExpenses);
    }

    //THE DIFFERENCE PER USERNAME
    @GetMapping("/balance/{userName}")
    public BigDecimal getBalanceUserName(@PathVariable String userName) {
        //get expenses

        List<Expense> expenses = expenseRepository.findAll();

        //get incomes

        List<Income> incomes = incomeRepository.findAll();

        //calculate expenses for user Wojtek

        BigDecimal sumOfExpenses = expenses.stream()
                .filter(expense -> expense.getUserName().equals(userName))
                .map(Expense::getAmountOfMoney)
                .reduce(BigDecimal.ZERO, BigDecimal::add);


        //calculate incomes for user Wojtek
        BigDecimal sumOfIncomes = incomes.stream()
                .filter(expense -> expense.getUserName().equals(userName))
                .map(Income::getAmountOfMoney)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return sumOfIncomes.subtract(sumOfExpenses);
    }

    //THE DIFFERENCE PER CATEGORY
    @GetMapping("/balance/category/{category}")
    public BigDecimal getBalanceCategory(@PathVariable String category) {
        //get expenses

        List<Expense> expenses = expenseRepository.findAll();

        //get incomes

        List<Income> incomes = incomeRepository.findAll();

        //calculate expenses for category

        BigDecimal sumOfExpenses = expenses.stream()
                .filter(expense -> expense.getCategory().equals(category))
                .map(Expense::getAmountOfMoney)
                .reduce(BigDecimal.ZERO, BigDecimal::add);


        //calculate incomes for category
        BigDecimal sumOfIncomes = incomes.stream()
                .filter(expense -> expense.getCategory().equals(category))
                .map(Income::getAmountOfMoney)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return sumOfIncomes.subtract(sumOfExpenses);
    }

}



