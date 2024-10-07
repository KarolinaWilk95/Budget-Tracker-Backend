package kw.budget.tracker.backend.bean;


import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "Incomes")
public class Income {

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

    public Income(){}

    public Income(Long id,String userName, String category, BigDecimal amountOfMoney, LocalDate date) {
        this.id = id;
        this.userName = userName;
        this.category = category;
        this.amountOfMoney = amountOfMoney;
        this.date = date;
    }
//
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

    public BigDecimal getAmountOfMoney() {
        return amountOfMoney;
    }

    public void setAmountOfMoney(BigDecimal amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
//
    @Override
    public String toString() {
        return "Income{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", category='" + category + '\'' +
                ", amountOfMoney=" + amountOfMoney +
                ", date=" + date +
                '}';
    }
}
