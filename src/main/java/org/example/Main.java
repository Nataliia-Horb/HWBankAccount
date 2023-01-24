package org.example;

import java.util.Random;

/**
 * Имеется счет BankAccount, на котором хранится определенная сумма денег int sum.
 * Реализовать потокобезопасный метод пополнения счета - deposit(int amount), снятия со счета - withdraw(int amount).
 */
public class Main {
    public static void main(String[] args) {
        BankAccount account=new BankAccount(100);
        Random random=new Random();
        System.out.println("Account balance at the start: " + account.sum);
        Thread thread1=new Thread(()-> {
            for (int i=0; i<100; i++) {
                account.deposit(random.nextInt(100));
            }
        });
        Thread thread2=new Thread(()-> {
            for (int i=0; i<100; i++) {
                account.withdraw(random.nextInt(100));
            }
        });
        thread1.start();
        thread2.start();
    }
}