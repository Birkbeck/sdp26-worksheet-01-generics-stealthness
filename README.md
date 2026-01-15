# Worksheet One

## Java Generics

+ This worksheet examines your existing knowledge on Java Generics to reinforce 
the concepts from your previous studies.
+ It is essential that you commit regularly any changes to your source code 
(to the respective `GitHub Classroom` repository).
+ Where the questions make incremental changes to the code you **do not** need to keep 
separate versions of your code, as your commits will deal with that situation. 
+ Text-based questions should be answered inline by modifying this document.

You are provided with some source files under `src/`.

## Learning Goals

When you have completed this worksheet you should have achieved the following learning goals:

+ To understand the basic benefits of using generics.
+ To understand the difference between type invariance and covariance.
+ To understand when to use upper-bounded and lower-bounded wildcards.

You should be able to finish most of the exercises during the lab session given your prior knowledge of the topic.

## The Exercises

1. Add the following code snippet to the `Example1` class `main` method, 
creating two different storage objects with two different type specialisations:
  
   ```.java
   bank.Storage<bank.BankAccount> bankAccountStorage = new bank.Storage<bank.BankAccount>();
   bank.Storage<String> stringStorage = new bank.Storage<String>();
   ```
   + What are the reasons for using generics here?
   
     ** YOUR ANSWER HERE **
   
   + What are the benefits?
   
     ** YOUR ANSWER HERE **

Add the following code to your `Example1` class:

   ```.java
   Object account = new bank.BankAccount(2025);
   bankAccountStorage.setItem(account);

   Object account1 = bankAccountStorage.getItem();
   account1.deposit(15);
   ```
   + Compile and analyse the compiler output.
   
   + What is the cause of the problems reported by the compiler, if any?
   
     2 issues:
     - First, in the line `bankAccountStorage.setItem(account);`, the variable `account` is of type `Object`, but the method `setItem` expects a parameter of type `bank.BankAccount`. Since `Object` is a supertype of `bank.BankAccount`, this causes a type mismatch error.
     - Second, in the line `account1.deposit(15);`, the variable `account1` is also of type `Object`, which does not have a `deposit` method. This results in a compilation error because the compiler cannot find the method `deposit` in the `Object` class.

Now replace:

   ```
   Object account = new bank.BankAccount(2025);
   ```
   with
   ```
   bank.BankAccount account = new bank.BankAccount(2025);
   ```
   + How does this affect the compilation process?
   
     ** YOUR ANSWER HERE **
   
   + What is the problem, if any?
   
     ** YOUR ANSWER HERE **
   
Now replace 

   ```.java
   bank.Storage<bank.BankAccount> bankAccountStorage = new bank.Storage<bank.BankAccount>();
   bank.Storage<String> stringStorage = new bank.Storage<String>();
   ```
with
   ```.java
   bank.Storage<bank.BankAccount> bankAccountStorage = new bank.Storage<>();
   bank.Storage<String> stringStorage = new bank.Storage<>();
   ```

   + Does it still compile?

     ** YOUR ANSWER HERE **

Finally, replace

   ```.java
   bank.Storage<bank.BankAccount> bankAccountStorage = new bank.Storage<>();
   bank.Storage<String> stringStorage = new bank.Storage<>();
   ```
with
   ```.java
   var bankAccountStorage = new bank.Storage<>();
   var stringStorage = new bank.Storage<>();
   ```

   + Does it still compile? If not, explain why.

     ** YOUR ANSWER HERE **

   + How would you fix the error?

     ** YOUR ANSWER HERE **


2. In Java, arrays are **covariant**, which means that an array of type `T1[]` can be used in a context where 
an array of type `T2[]` is expected (in other words, `T1[]` is a subtype of `T2[]`) whenever `T1` is a subtype of `T2`. Consider class `Example2`: 
its method `test` is declared to accept an array of any objects, in particular, an array of `bank.BankAccount` 
(as `bank.BankAccount` is a subtype of `Object`). 
Inside method `test`, the parameter array `a` has type `Object[]` and so, we can store a new `bank.BankAccount` in 
the parameter array. Compile and run the code to ensure it can be executed successfully.

Replace now

   ```.java
   bank.BankAccount[] array = new bank.BankAccount[2];
   array[0] = new bank.BankAccount(2024);
   ```
with
   ```.java
   String[] array = new String[2];
   array[0] = "hi there";
   ```

+ Compile and run the code again. Does it still compile? Does it run? What is the output?

  ** YOUR ANSWER HERE **

3. Generics in Java, in contrast, are **invariant**, which means that the type parameters need to match exactly:
`C<T1>` is **not** a subtype of `C<T2>` when `T1` is a subtype of `T2` (unless, of course, `T1` is the same as `T2`).
Consider class `Example3`, which is very similar to `Example2` except that it uses the `bank.Storage` generic class
instead of an array. Compile and run the code to ensure it can be executed successfully.

Replace now

   ```.java
   bank.Storage<bank.BankAccount> storage = new bank.Storage<>();
   storage.setItem(new bank.BankAccount(2024));
   ```
with
   ```.java
   bank.Storage<String> storage = new bank.Storage<>();
   storage.setItem("Happy 2025!");
   ```

+ Compile the code again. Does it still compile? Why not?

  ** YOUR ANSWER HERE **

4. Study the code in class `Example4`.

+ What is the type of variable `storage1`?

  ** YOUR ANSWER HERE **

+ Compile and run the code to make sure it can be executed successfully. What is the printed output?

  ** YOUR ANSWER HERE **

Add the following 3 lines to method `main`:

   ```.java
   var storage2 = new bank.Storage<bank.SavingsAccount>();
   storage2.setItem(new bank.SavingsAccount(2025, 2));
   process(storage2);
   ```

+ What is the type of variable `storage2`?

  ** YOUR ANSWER HERE **

+ Compile the code. Does it compile? If not, what is the problem?

  ** YOUR ANSWER HERE **

+ Fix the compile-time error, without changing the contents of method `main` and without any code duplication. 
In other words, assume that users of your 
method `process` may want to invoke it with `bank.Storage<bank.BankAccount>`, `bank.Storage<bank.SavingsAccount>` or indeed with
any `bank.Storage<T>` for a subtype `T` of `bank.BankAccount`.

5. Study the code in class `Example5`.

+ What is the type of variable `storage1`? 

  ** YOUR ANSWER HERE **

+ Compile and run the code to make sure it can be executed successfully. What is the printed output?

  ** YOUR ANSWER HERE **

Add the following 4 lines to method `main`:

   ```.java
   var storage2 = new bank.Storage<bank.BankAccount>();
   store(storage2, account);

   var storage3 = new bank.Storage<Object>();
   store(storage3, account);
   ```

+ What is the type of variable `storage2`? What is the type of variable `storage3`?

  ** YOUR ANSWER HERE **

+ Compile the code. Does it compile? If not, what is the problem?

  ** YOUR ANSWER HERE **

+ Fix the compile-time error, without changing the contents of method `main` and without any code duplication.
  In other words, assume that users of your
  method `store` may want to invoke it with `bank.Storage<bank.SavingsAccount>` or with
  any `bank.Storage<T>` for a supertype `T` of `bank.SavingsAccount` (in particular, with `bank.Storage<bank.BankAccount>` and `bank.Storage<Object>`).

The last two exercises illustrate the PECS abbreviation: **P**roducer **e**xtends, **C**onsumer **s**uper.

------

