package org.example;

public class BankAccount {
    int sum;

    public BankAccount(int sum) {
        this.sum = sum;
    }

    public synchronized void deposit(int amount) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        sum += amount;
        System.out.println("+ " + amount);
        System.out.println("Account balance: " + sum+"\n");
    }

    public synchronized void withdraw(int amount) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (sum >= amount) {
            sum -= amount;
            System.out.println("- " + amount);
            System.out.println("Account balance: " + sum+"\n");

        } else {
            System.out.println("Not enough money on the card");
            System.out.println("Account balance: " + sum+"\n");
        }
    }
}
