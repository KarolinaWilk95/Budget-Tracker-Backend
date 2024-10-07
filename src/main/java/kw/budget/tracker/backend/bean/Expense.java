package kw.budget.tracker.backend.bean;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table (name = "Expenses")
public class Expense {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String userName;

    @Column
    private String category;

    @Column
    private BigDecimal amountOfMoney;

    @Column
    private LocalDate date;


    public Expense(){}

    public Expense(Long id, String category, String userName, BigDecimal amountOfMoney, LocalDate date) {
        this.id = id;
        this.category = category;
        this.userName = userName;
        this.amountOfMoney = amountOfMoney;
        this.date = date;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BigDecimal getAmountOfMoney() {
        return amountOfMoney;
    }

    public void setAmountOfMoney(BigDecimal amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }


    @Override
    public String toString() {
        return "Expense{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", category='" + category + '\'' +
                ", amountOfMoney=" + amountOfMoney +
                ", date=" + date +
                '}';
    }
}
