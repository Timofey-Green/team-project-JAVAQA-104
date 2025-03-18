package ru.netology.javaqadiplom;

public class Account {
    protected int balance;
    protected int rate;

    public boolean pay(int amount) {
        if (amount <= 0 || amount > balance) {
            return false; // Проверка на некорректные суммы
        }
        balance -= amount; // Списание средств
        return true;
    }

    public boolean add(int amount) {
        if (amount > 0) {
            balance += amount; // Зачисление средств
            return true;
        }
        return false;
    }

    public int yearChange() {
        return 0;
    }

    public int getBalance() {
        return balance;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}
