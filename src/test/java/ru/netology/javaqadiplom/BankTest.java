package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {

    @Test
    public void testTransfer (){
        Account from = new Account();
        Account to =new Account();

        from.balance = 2_000;
        to.balance = 1_000;

        Bank bank = new Bank();
        bank.transfer(from,to,1_000);

        Assertions.assertEquals(1_000,from.getBalance());
        Assertions.assertEquals(2_000,to.getBalance());


    }
    @Test
    public void testTransferNegativeAmount (){
        Account from = new Account();
        Account to =new Account();

        from.balance = 2_000;
        to.balance = 1_000;

        Bank bank = new Bank();
        bank.transfer(from,to,-1_000);

        Assertions.assertEquals(from.balance,from.getBalance());
        Assertions.assertEquals(to.balance,to.getBalance());
    }
    @Test
    public void testTransferAmountMoreFrom (){
        Account from = new Account();
        Account to =new Account();

        from.balance = 2_000;
        to.balance = 1_000;

        Bank bank = new Bank();
        bank.transfer(from,to,3_000);

        Assertions.assertEquals(from.balance,from.getBalance());
        Assertions.assertEquals(to.balance,to.getBalance());
    }
    @Test
    public void testTransferAmountNull (){
        Account from = new Account();
        Account to =new Account();

        from.balance = 2_000;
        to.balance = 1_000;

        Bank bank = new Bank();
        bank.transfer(from,to,0);

        Assertions.assertEquals(from.balance,from.getBalance());
        Assertions.assertEquals(to.balance,to.getBalance());
    }

}