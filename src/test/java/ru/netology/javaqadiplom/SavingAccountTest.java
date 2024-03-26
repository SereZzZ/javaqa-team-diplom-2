package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {
    @Test
    public void shouldAddBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(3_000);

        Assertions.assertEquals(5_000, account.getBalance());
    }

    @Test
    public void shouldNotAddNegativeNumber() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(-100);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void shouldNotAddMoreThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(10_000);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void shouldPayMoreThanMinBalance() {
        SavingAccount saving = new SavingAccount(
                1200,
                1_000,
                10_000,
                5
        );

        boolean expected = false;
        boolean actual = saving.pay(500);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldPayLessThanMinBalance() {
        SavingAccount saving = new SavingAccount(
                1_600,
                1_000,
                10_000,
                5
        );

        boolean expected = true;
        boolean actual = saving.pay(500);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldPayNegativeAmount() {
        SavingAccount saving = new SavingAccount(
                1_600,
                1_000,
                10_000,
                5
        );

        boolean expected = false;
        boolean actual = saving.pay(-500);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldPayZeroAmount() {
        SavingAccount saving = new SavingAccount(
                1_600,
                1_000,
                10_000,
                5
        );

        boolean expected = false;
        boolean actual = saving.pay(0);
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void shouldPayWhenAmountMoreInitialBalance() {
        SavingAccount saving = new SavingAccount(
                1_600,
                1_000,
                10_000,
                5
        );
        saving.pay(3000);

        Assertions.assertEquals(1_600, saving.getBalance());
    }

    @Test
    public void shouldPayEqualsThanMinBalance() {
        SavingAccount saving = new SavingAccount(
                1_500,
                1_000,
                10_000,
                5
        );

        boolean expected = true;
        boolean actual = saving.pay(500);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldChangeBalance() {
        SavingAccount saving = new SavingAccount(
                1500,
                1_000,
                10_000,
                5
        );

        int expected = 75;
        int actual = saving.yearChange();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCheckExceptionNegativeRate() { // Проверка выдачи исключения при отрицательной процентной ставке.
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    1_000,
                    3_000,
                    10_000,
                    -1
            );
        });
    }
    @Test
    public void shouldCheckExceptionZeroMaxBalance() { // Проверка выдачи исключения при нулевом максимальном балансе.
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    1_000,
                    3_000,
                    0,
                    5
            );
        });
    }
    @Test
    public void shouldCheckExceptionNegativeInitialBalance() { // Проверка выдачи исключения при отрицательном начальном балансе.
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    - 1_000,
                    3_000,
                    10_000,
                    5
            );
        });
    }
    @Test
    public void shouldCheckExceptionMinBalanceMoreMaxBalance() { // Проверка выдачи исключения если мин. баланс выше макс. баланса.
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                     1_000,
                    3_000,
                    1_000,
                    5
            );
        });
    }

    @Test
    public void shouldCheckExceptionInitialBalanceMoreMaxBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    7_000,
                    3_000,
                    6_000,
                    5
            );
        });
    }

    @Test
    public void shouldCheckExceptionNegativeMinBalance() { // Проверка выдачи исключения при нулевом максимальном балансе.
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    1_000,
                    -1_000,
                    8000,
                    5
            );
        });
    }
}
