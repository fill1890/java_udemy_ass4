package org.fill1890;

/* Requirements

Person: first middle and last name, age, ID
Bank: list of customers and accounts, maximum overdraw
Checking Account: value, allowance to take and deposit money

Opening a checking account should only be via a bank and need a certain initial deposit

Details:

Bank needs the capability to open a new account for a given person - might as well make it a list of accounts
- accounts by name
- ability to get list of accounts

Person names... map? individual? might as well overload for no middle name, why not (if possible)

Accounts should limit draw to maximum overdraw
 */

public class Main {

    public static void main(String[] args) {
        // let's do some basic testing
        Bank bank = new Bank();
        Person jeff = new Person("Jeff", "Bezos", 69);
        Person bob = new Person("Boberick", "Bobacious", "Bobbington", 420);

        System.out.println(jeff.get_fullname() + " (" + jeff.get_nickname() + ")");
        System.out.println(bob.get_fullname() + " (" + bob.get_nickname() + ")");

        // test opening account
        bank.addAccount(jeff, "amazon", 6942000);
        System.out.println(jeff.get_fullname() + ":");
        System.out.println(bank.getAccounts(jeff.id));
        System.out.println("value: " + bank.getAccounts(jeff.id).get("amazon").get_balance());
        // test deposit
        bank.getAccounts(jeff.id).get("amazon").deposit(22);
        System.out.println("value: " + bank.getAccounts(jeff.id).get("amazon").get_balance());
        // jeff tries to buy happiness (test overdraw)
        long withdrawal = bank.getAccounts(jeff.id).get("amazon").withdraw(1000000000000L);
        System.out.println("withdrew " + withdrawal);
        System.out.println("value: " + bank.getAccounts(jeff.id).get("amazon").get_balance());

        // test insufficient deposit
        boolean res = bank.addAccount(bob, "savings", 10);
        System.out.println("bob opened: " + res);
        System.out.println(bank.getAccounts(bob.id));
        // test multiple accounts
        bank.addAccount(bob, "savings", 2000);
        bank.addAccount(bob, "billing", 100);
        System.out.println(bank.getAccounts(bob.id));

    }
}
