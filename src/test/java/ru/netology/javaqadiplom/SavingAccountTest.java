package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {

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
    public void testYearChange() {

        SavingAccount account = new SavingAccount(250,  0, 15_000,15);

        // Проверка расчета процентов
        int expected = 37;
        int actual = account.yearChange();

        // Проверка, что фактический результат равен ожидаемому
        Assertions.assertEquals(expected, actual);
    }
}
