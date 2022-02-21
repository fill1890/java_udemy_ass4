package org.fill1890;

public class Account {
    private int max_overdraft;
    // maximim $$$
    private long value;

    // initialise with max overdraft from bank globally
    // and set initial value to deposit
    public Account(long deposit) {
        this.max_overdraft = Bank.max_overdraft;
        this.value = deposit;
    }

    // deposit $$$
    // return the new value of the account
    public long deposit(long amount) {
        //TODO: assert amount > 0, throw error? if not

        this.value += amount;
        return this.value;
    }

    // withdraw $$$
    // return the amount withdrawn
    // will return less than requested if taking the requested would go past overdraft
    public long withdraw(long amount) {
        //TODO: assert amount > 0, throw error? if not

        long max_withdraw = value + max_overdraft;
        if(amount < max_withdraw) {
            value -= amount;
            return amount;
        } else {
            value -= max_withdraw;
            return max_withdraw;
        }
    }

    // get account balance
    public long get_balance() {
        return value;
    }

    // Request a change of the max overdraft for this account
    // More complex implementations would do verification/checking beforehand
    // and return true if changed, false if not
    // Further complexity would be to add a decline reason
    public boolean request_overdraft_change(int to) {
        this.max_overdraft = to;
        return true;
    }

    // make them display nicely
    @Override
    public String toString() {
        return "$" + this.value;
    }
}
