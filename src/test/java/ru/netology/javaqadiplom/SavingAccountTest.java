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

        account.add(8_000);

        Assertions.assertEquals(2_000 + 8_000, account.getBalance());
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
                1600,
                1_000,
                10_000,
                5
        );

        boolean expected = true;
        boolean actual = saving.pay(500);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldPayEqualsThanMinBalance() {
        SavingAccount saving = new SavingAccount(
                1500,
                1_000,
                10_000,
                5
        );

        boolean expected = false;
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
}
