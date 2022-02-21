package org.fill1890;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bank {
    // $100 max overdraft globally
    protected static int max_overdraft = 100;
    // $20 min deposit globally
    // in a more advanced world we would be able to change this by customer
    protected static int min_deposit = 20;
    // CUSTOMER SECURITY AND PRIVACY.
    private Map<Person, Map<String, Account>> customers;

    public Bank() {
        customers = new HashMap<>();
    }

    // Add an account for a person
    // returns true if added, false if deposit insufficient
    public boolean addAccount(Person person, String account_name, long deposit) {
        // check deposit is enough
        if(deposit < min_deposit) return false;

        // set up a new account
        Account new_account = new Account(deposit);
        // if the owner is already bank customer, add to their list of accounts
        if(customers.containsKey(person)) {
            customers.get(person).put(account_name, new_account);
        } else {
            // if not, set up a new customer profile
            Map<String, Account> new_customer = new HashMap<>();
            new_customer.put(account_name, new_account);
            customers.put(person, new_customer);
        }

        // presumably if we get to here it's fine
        return true;
    }

    // Get checking accounts for a given ID
    public Map<String, Account> getAccounts(int id) {
        // Get list of people, iterate through till we find the person with the right id
        // there is probably a cleaner way to do this, but i don't know Java well enough
        List<Person> people = new ArrayList<>(customers.keySet());
        // IntelliJ reckons I can put an enhanced for here
        // but i don't understand it yet so i'm going to leave it
        for(int i = 0; i < people.size(); i++) {
            if(people.get(i).id == id) {
                return customers.get(people.get(i));
            }
        }

        // No person found by that ID
        return null;
    }

    // Request a change of the initial max overdraft for all accounts
    // More complex implementations would do verification/checking beforehand
    // and return true if changed, false if not
    // Further complexity would be to add a decline reason
    public boolean request_overdraft_change(int to) {
        max_overdraft = to;
        return true;
    }

}
