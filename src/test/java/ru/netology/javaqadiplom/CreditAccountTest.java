package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {


    // Создание кредитного счета.
    // initialBalance


    @Test  //Установка отрицательного значения начального баланса (невалидное значение).

    public void SettingANegativeInitialBalanceValue() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    -1,
                    5_000,
                    1
            );
        });
    }
    // Ошибка, должно выкидываться исключения вида IllegalArgumentException.


    @Test  // Установка начального баланса: 0.

    public void SettingTheInitialBalance0() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                1
        );

        Assertions.assertEquals(0, account.getBalance());
    }


    @Test  // Установка начального баланса: 1 (нижнее граничное значение).

    public void SettingTheInitialBalance1() {
        CreditAccount account = new CreditAccount(
                1,
                5_000,
                1
        );

        Assertions.assertEquals(1, account.getBalance());
    }


    @Test  // Установка начального баланса: 3000 (среднее значение).

    public void SettingTheInitialBalance3000() {
        CreditAccount account = new CreditAccount(
                3_000,
                5_000,
                1
        );

        Assertions.assertEquals(3_000, account.getBalance());
    }


    @Test  // Установка начального баланса равного кредитному лимиту.

    public void SettingTheInitialBanceEqualToTheCreditLimit() {
        CreditAccount account = new CreditAccount(
                5_000,
                5_000,
                1
        );

        Assertions.assertEquals(5_000, account.getBalance());
    }


    @Test  // Установка начального баланса свыше кредитного лимита.

    public void SettingTheInitialBalanceAboveTheCreditLimit() {
        CreditAccount account = new CreditAccount(
                7_000,
                5_000,
                1
        );

        Assertions.assertEquals(7_000, account.getBalance());
    }


    // creditLimit


    @Test  //Установка отрицательного значения кредитного лимита (невалидное значение).

    public void SettingANegativeCreditLimitValue() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    5_000,
                    -1,
                    1
            );
        });
    }
    //Ошибка, должно выкидываться исключения вида IllegalArgumentException.


    @Test  // Установка кредитного лимита: 0.

    public void SettingTheCreditLimit0() {
        CreditAccount account = new CreditAccount(
                0,
                0,
                1
        );

        Assertions.assertEquals(0, account.getCreditLimit());
    }


    @Test  // Установка кредитного лимита: 1.

    public void SettingTheCreditLimit1() {
        CreditAccount account = new CreditAccount(
                0,
                1,
                1
        );

        Assertions.assertEquals(1, account.getCreditLimit());
    }


    @Test  // Установка кредитного лимита: 10000.
    public void SettingTheCreditLimit10000() {
        CreditAccount account = new CreditAccount(
                0,
                10_000,
                1
        );

        Assertions.assertEquals(10_000, account.getCreditLimit());
    }


    //rate


    @Test  //Установка отрицательного значения ставки (невалидное значение).

    public void SettingANegativeRateValue() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    5_000,
                    5_000,
                    -1
            );
        });
    }


    @Test  // Установка нижнего граничного значения ставки.

    public void SettingTheLowerLimitValueOfTheRate() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                1
        );

        Assertions.assertEquals(1, account.getRate());
    }


    @Test  // Установка верхнего граничного значения ставки.

    public void SettingTheUpperLimitValueOfTheRate() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                100
        );

        Assertions.assertEquals(100, account.getRate());
    }


    @Test  // Установка среднего значения ставки.

    public void SettingTheAverageRateValue() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        Assertions.assertEquals(15, account.getRate());
    }


    @Test  // Установка ставки: 0.

    public void RateSetting0() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                0
        );

        Assertions.assertEquals(0, account.getRate());
    }

    //Ошибка. Ставка не может быть отрицательно, но может быть равной 0.


    //Операция оплаты с карты - pay


    @Test  // Покупка на сумму: 0.

    public void PurchaseAmount0() {
        CreditAccount account = new CreditAccount(
                10_000,
                10_000,
                15
        );

        account.pay(0);

        Assertions.assertEquals(10_000, account.getBalance());
    }


    @Test  // Покупка на сумму: 5000.

    public void PurchaseAmount5000() {
        CreditAccount account = new CreditAccount(
                10_000,
                10_000,
                15
        );

        account.pay(5_000);

        Assertions.assertEquals(5_000, account.getBalance());
    }
    //Ошибка, не учтены деньги на счету.


    @Test  // Покупка на сумму: 10000 (сумма покупки равна сумме на баклансе)

    public void PurchaseAmount10000() {
        CreditAccount account = new CreditAccount(
                10_000,
                10_000,
                15
        );

        account.pay(10_000);

        Assertions.assertEquals(0, account.getBalance());
    }
    //Ошибка, не учтены деньги на счету.


    @Test  // Покупка на сумму: 15000 (сумма покупки превышает сумму на балансе).

    public void PurchaseAmount15000() {
        CreditAccount account = new CreditAccount(
                10_000,
                10_000,
                15
        );

        account.pay(15_000);

        Assertions.assertEquals(-5_000, account.getBalance());
    }
    //Ошибка, не учтены деньги на счету.


    @Test  // Покупка на сумму: -1 (граничное невалидное значение ссуммы покупки).

    public void PurchaseForANegativeAmount() {
        CreditAccount account = new CreditAccount(
                10_000,
                10_000,
                15
        );

        account.pay(-1);

        Assertions.assertEquals(10_000, account.getBalance());
    }


    @Test  // Покупка на сумму: -100 (невалидное значение ссуммы покупки).

    public void PurchaseForANegativeAmount2() {
        CreditAccount account = new CreditAccount(
                10_000,
                10_000,
                15
        );

        account.pay(-100);

        Assertions.assertEquals(10_000, account.getBalance());
    }


    @Test  // Покупка на сумму 1 при нулевом балансе (граничное значение)

    public void PurchaseInTheAmountOf1WithZeroBalance() {
        CreditAccount account = new CreditAccount(
                0,
                10_000,
                15
        );

        account.pay(1);

        Assertions.assertEquals(-1, account.getBalance());
    }


    @Test  // Покупка на сумму 100 при нулевом балансе.

    public void PurchaseInTheAmountOf100WithZeroBalance() {
        CreditAccount account = new CreditAccount(
                0,
                10_000,
                15
        );

        account.pay(100);

        Assertions.assertEquals(-100, account.getBalance());
    }


    //Операция пополнения карты - add


    @Test  // Пополняем нулевой баланс на 0 рублей.

    public void TopUpTheZeroBalanceBy0() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(0);

        Assertions.assertEquals(0, account.getBalance());
    }


    @Test  // Пополняем нулевой баланс на 1 рубль.

    public void TopUpTheZeroBalanceBy1() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(1);

        Assertions.assertEquals(1, account.getBalance());
    }


    @Test  // Пополняем нулевой баланс на -1 (невалидное значение).

    public void AddingAnInvalidAmountToTheZeroBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(-1);

        Assertions.assertEquals(0, account.getBalance());
    }


    @Test  // Пополняем нулевой баланс на 3000.

    public void TopUpTheZeroBalanceBy3000() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(3_000, account.getBalance());
    }


    @Test  // Пополняем ненулевой баланс на 0 рублей.

    public void ToppingUpTheBalanceBy0() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );

        account.add(0);

        Assertions.assertEquals(1_000, account.getBalance());
    }


    @Test  // Пополняем ненулевой баланс на 3000.

    public void ToppingUpTheBalanceBy3000() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(4_000, account.getBalance());
    }
    //Ошибка, не учтены деньги на балансе.


    @Test  // Пополняем ненулевой баланс на -1000 (невалидное значение).

    public void AddingAnInvalidAmountToTheBalance() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );

        account.add(-1_000);

        Assertions.assertEquals(1_000, account.getBalance());
    }


    @Test  // Пополняем отрицательный баланс счета до положительного.

    public void TopUpANegativeBalanceToAPositive() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.pay(3_000);
        account.add(4_000);

        Assertions.assertEquals(1_000, account.getBalance());
    }
    //Ошибка, не учтена предыдущая сумма на балансе.


    //Операция расчёта процентов на отрицательный баланс счёта - yearChange


    @Test //Вычисляем процент на положительный баланс.

    public void CalculatingThePercentageOnThePositiveBalance() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );

        account.pay(500);


        Assertions.assertEquals(0, account.yearChange());
    }
    //Ошибка. Возникает из-за ошибки в методе pay.


    @Test //Вычисляем процент на положительный баланс (граничное значение).

    public void CalculateThePercentageForAPositiveBalance() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );

        account.pay(999);


        Assertions.assertEquals(0, account.yearChange());
    }
    //Ошибка. Возникает из-за ошибки в методе pay.


    @Test //Вычисляем процент на нулевой баланс.

    public void CalculateThePercentageForAZeroBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.pay(0);


        Assertions.assertEquals(0, account.yearChange());
    }


    @Test //Вычисляем процент на отрицательный баланс (граничное значение)

    public void CalculateThePercentageForANegativeBalance() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );

        account.pay(1_001);


        Assertions.assertEquals(0, account.yearChange());
    }
    //Ошибка. Возникает из-за ошибки в методе pay.


    @Test //Вычисляем процент на отрицательный баланс.

    public void CalculateThePercentageForANegativeBalance2() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );

        account.pay(5_000);


        Assertions.assertEquals(600, account.yearChange());
    }
    //Ошибка. Возникает из-за ошибки в методе pay.
}

