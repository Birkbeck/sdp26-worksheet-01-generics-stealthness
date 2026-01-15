import bank.BankAccount;
import bank.Storage;

public class Example1 {
    public static void main(String... args) {

        Storage<bank.BankAccount> bankAccountStorage = new Storage<bank.BankAccount>();
        bank.Storage<String> stringStorage = new bank.Storage<String>();

        // Both storage are constructed successfully, however they are both empty containing null values.

        System.out.println("BankAccount Storage contains: " + bankAccountStorage.getItem());
        System.out.println("String Storage contains: " + stringStorage.getItem());

        bankAccountStorage.setItem(new BankAccount(1234));
        stringStorage.setItem("Hello, Generics!");

        System.out.println("BankAccount Storage now contains account number: " + bankAccountStorage.getItem().getAccountNumber());
        System.out.println("String Storage now contains: " + stringStorage.getItem());

        /* uncompilable code examples
        Storage<BankAccount> anotherBankAccountStorage = Storage<String>; // Error: incompatible types

        Object account = new bank.BankAccount(2025);
        bankAccountStorage.setItem(account);  // Error: incompatible types account is not of Object type.

        Object account1 = bankAccountStorage.getItem();
        account1.deposit(15); // Error: cannot find symbol method deposit(int) on Object type

        ((BankAccount) account1).deposit(15); // This works after casting but is not type safe.
        */

        // Correct way to create and use a BankAccount
        BankAccount bankAccount = new BankAccount(2025);
        bankAccount.deposit(15);

    }
}
