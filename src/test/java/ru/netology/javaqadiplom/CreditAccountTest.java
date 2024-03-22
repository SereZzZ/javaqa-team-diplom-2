package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {

    @Test
    public void shouldAddToZeroBalance() { //пополнение счета при нулевом балансе.
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(5_000);

        Assertions.assertEquals(5_000, account.getBalance());
    }

    @Test
    public void shouldAddToNegativeBalance() {  //пополнение счета при отрецательном балансе
        CreditAccount account = new CreditAccount(
                -50,
                1_000,
                20
        );
        account.add(500);

        Assertions.assertEquals(450, account.getBalance());
    }

    @Test
    public void shouldAddToPositiveBalance() { //пополнение счета при положительном балансе
        CreditAccount account = new CreditAccount(
                1_000,
                3_000,
                10
        );
        account.add(1_000);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void shouldAddZeroToBalance() { //значение счета при пополнении на "amount = 0"
        CreditAccount account = new CreditAccount(
                2_000,
                5_000,
                10
        );
        account.add(0);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void shouldAddNegativeValueToBalance() { //значение счета при пополнении на "amount = отрицательное значение"
        CreditAccount account = new CreditAccount(
                20,
                5_000,
                10
        );

        account.add(-50);

        Assertions.assertEquals(20, account.getBalance());
    }

    @Test
    public void shouldPayWhenBalanceMoreThanAmount() {  // Оплата покупки когда сумма баланса выше, чем сумма покупки.
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                10
        );

        account.pay(700);

        Assertions.assertEquals(300, account.getBalance());
    }

    @Test
    public void shouldPayWhenAmountMoreThanBalance() { // Оплата покупки когда сумма покупки выше, чем сумма баланса.
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                10
        );

        account.pay(1_500);

        Assertions.assertEquals(-500, account.getBalance());
    }

    @Test
    public void shouldPayWhenAmountAndBalanceSame() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                10
        );

        account.pay(1_000);

        Assertions.assertEquals(0, account.getBalance());
    }

    @Test // Оплата покупки когда суммы покупки и баланса равны.
    public void shouldPayNegativeAmount() { // Оплата покупки когда суммы покупки отрицательная
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                10
        );

        account.pay(-800);

        Assertions.assertEquals(1_000, account.getBalance());
    }

    @Test
    public void shouldPayWhenAmountMoreThanCreditLimit() { // Оплата покупки при превышении кредитного лимита.
        CreditAccount account = new CreditAccount(
                1_000,
                2_000,
                10
        );

        account.pay(2_500);

        Assertions.assertEquals(1_000, account.getBalance());
    }

    @Test
    public void shouldCalculationYearChangeWhenPositiveBalance() { // Расчет процентов при положительном балансе.
        CreditAccount account = new CreditAccount(
                1_000,
                3_000,
                10
        );

        Assertions.assertEquals(0, account.yearChange());
    }

    @Test
    public void shouldCalculationYearChangeWhenZeroBalance() { // Расчет процентов при отсутствие средств на балансе.
        CreditAccount account = new CreditAccount(
                0,
                3_000,
                10
        );

        Assertions.assertEquals(0, account.yearChange());
    }

    @Test
    public void shouldCalculationYearChangeWhenNegativeBalance() { // Расчет процентов при отрицательном балансе.
        CreditAccount account = new CreditAccount(
                -1_000,
                3_000,
                10
        );

        Assertions.assertEquals(-100, account.yearChange());
    }

    @Test
    public void shouldCheckExceptionNegativeRate() { // Проверка выдачи исключения при отрицательной ставке кредита.
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    1_000,
                    3_000,
                    -10
            );
        });
    }

    @Test
    public void shouldCheckExceptionZeroRate() { // Проверка выдачи исключения при нулевой ставке кредита.
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    1_000,
                    3_000,
                    0
            );
        });
    }

    @Test
    public void shouldCheckExceptionNegativeCreditLimit() { // Проверка выдачи исключения при отрицательном кредитном лимите.
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    1_000,
                    -3_000,
                    10
            );
        });
    }

    @Test
    public void shouldCheckExceptionNegativeBalance() { // Проверка выдачи исключения при отрицательном балансе.
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    -1_000,
                    3_000,
                    10
            );
        });
    }

    @Test
    public void shouldCheckExceptionPositiveParameters() { // Проверка выдачи исключения при корректных параметрах.
        CreditAccount account = new CreditAccount(
                1_000,
                3_000,
                10
        );

        Assertions.assertEquals(1_000, account.getBalance());
        Assertions.assertEquals(3_000, account.getCreditLimit());
        Assertions.assertEquals(10, account.getRate());
    }
}
