package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {

    //Тесты метода add

    @Test
    public void shouldAddLessThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(3_000);

        Assertions.assertEquals(2_000 + 3_000, account.getBalance());
    }

    @Test
    public void shouldAddMoreThanMaxBalance() {
        int initialBalance = 4_000;
        int minBalance = 100;
        int maxBalance = 5_000;
        int rate = 5;

        SavingAccount account = new SavingAccount(initialBalance, minBalance, maxBalance, rate);

        // Пополняем счет balance > maxBalance
        account.add(3_000);
        Assertions.assertEquals(initialBalance, account.getBalance()); // Начальный баланс не должен измениться

    }

    @Test
    public void shouldAddMoreNegativeAmount() {
        int initialBalance = 1_000;

        SavingAccount account = new SavingAccount(initialBalance, 0, 5_000, 5);

        account.add(-100); // Попытка пополнить на отрицательную сумму
        Assertions.assertEquals(initialBalance, account.getBalance()); // Начальный баланс не должен измениться
    }


    //Тест метода yearChange

    @Test
    public void testYearChange() {

        SavingAccount account = new SavingAccount(
                150,
                0,
                15_000,
                15);

        // Проверка расчета процентов
        int expected = 22;
        int actual = account.yearChange();

        // Проверка, что фактический результат равен ожидаемому
        Assertions.assertEquals(expected, actual);
    }


    // Тест метода SavingAccount

    @Test
    public void testNewSavingAccountMinEqualsMax() {

        int initialBalance = 1_000;
        int minBalance = 1_000; // minBalance = maxBalance
        int maxBalance = 1_000;
        int rate = 5;

        // Проверяем, что конструктор работает корректно, если initialBalance равен minBalance и maxBalance
        SavingAccount account = new SavingAccount(initialBalance, minBalance, maxBalance, rate);
        Assertions.assertEquals(initialBalance, account.getBalance());
        Assertions.assertEquals(minBalance, account.getMinBalance());
        Assertions.assertEquals(maxBalance, account.getMaxBalance());
    }

    @Test
    public void testNewSavingAccountInvalidInitialBalanceLessMinBalance() {
        // Проверяем, что конструктор выбрасывает исключение, если initialBalance меньше minBalance;
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(500, 1_000, 2_000, 5);
        });
    }

    @Test
    public void testNewSavingAccountInvalidInitialBalanceMoreMaxBalance() {
        // Проверяем, что конструктор выбрасывает исключение, если initialBalance больше maxBalance;
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(3000, 1_000, 2_000, 5);
        });
    }


    @Test
    public void testNewSavingAccountInvalidInitialBalance() {
        // Проверяем, что конструктор выбрасывает исключение, если initialBalance меньше 0;
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(-100, 1_000, 2_000, 5);
        });
    }

    @Test
    public void testNewSavingAccountInvalidRate() {

        // Проверяем, что конструктор выбрасывает исключение, если rate < 0
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(100, 50, 200, -5);
        });
    }

    @Test
    public void testNewSavingAccountMinBalanceGreaterThanMaxBalance() {

        //Проверяем, что конструктор выбрасывает исключение, если minBalance > maxBalance.
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(500, 2000, 1000, 5);
        });
    }

    //Тест метода pay

    @Test
    public void testPay() {
        SavingAccount account = new SavingAccount(1_000, 0, 10_000, 0);

        account.pay(500);

        Assertions.assertEquals(1_000 - 500, account.getBalance());

    }

    @Test
    public void testPayMoreThanMinBalance() {
        int initialBalance = 1_000;

        SavingAccount account = new SavingAccount(initialBalance, 500, 10_000, 0);

        account.pay(600);

        Assertions.assertEquals(initialBalance, account.getBalance()); // Начальный баланс не должен измениться

    }

    @Test
    public void testPayMoreNegativeAmount() {
        int initialBalance = 1_000;

        SavingAccount account = new SavingAccount(initialBalance, 500, 10_000, 0);

        account.pay(-100);

        Assertions.assertEquals(initialBalance, account.getBalance()); // Начальный баланс не должен измениться

    }
}
