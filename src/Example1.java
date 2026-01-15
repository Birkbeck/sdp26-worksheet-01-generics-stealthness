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
        */

    }
}
