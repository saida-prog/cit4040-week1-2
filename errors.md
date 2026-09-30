# Errors

## Task 2.3 — Breaking Main.java on purpose

### 1. Removed the semicolon after println

```
Main.java:3: error: ';' expected
        System.out.println("Hello, backend!")
                                             ^
1 error
```

The compiler reached the end of the statement on line 3 and expected a `;` to finish it, and the `^` points to exactly where it is missing.

### 2. Changed `println` to `printline`

```
Main.java:3: error: cannot find symbol
        System.out.printline("Hello, backend!");
                  ^
  symbol:   method printline(String)
  location: variable out of type PrintStream
1 error
```

`System.out` is a `PrintStream`, and that class has no method called `printline` that takes a String, so the compiler cannot find what I am calling.

### 3. Renamed the class to `Application` but kept the file `Main.java`

```
Main.java:1: error: class Application is public, should be declared in a file named Application.java
public class Application {
       ^
1 error
```

In Java a public class must live in a file with exactly the same name, so either the file must be renamed or the class name changed back.

### 4. Deleted `static` from the main method

Compiling succeeded (`javac Main.java` printed nothing), but running failed:

```
Error: Main method is not static in class Main, please define the main method as:
   public static void main(String[] args)
```

The code is valid Java, so it compiles, but the JVM needs a `static` main to start the program without creating an object first, so the error only appears at run time.

## Task 3.4 — NullPointerException stack trace

Code in `Calculator.java` (runs when started with `java Calculator npe`):

```java
String missing = null;
System.out.println(missing.length());
```

Full stack trace:

```
Exception in thread "main" java.lang.NullPointerException: Cannot invoke "String.length()" because "<local9>" is null
	at Calculator.main(Calculator.java:87)
```

(`<local9>` appears instead of the name `missing` because javac does not store local
variable names by default; compiling with `javac -g Calculator.java` shows `"missing"`.)

**Which file and line caused the exception?**
`Calculator.java`, line 87 — the line `System.out.println(missing.length());`.

**Which line of the trace is the first one that mentions code I wrote?**
`at Calculator.main(Calculator.java:87)` — here it is the first (and only) `at` line,
because the exception happened directly in my `main` method, not inside a library.

**What single change would prevent it?**
Give the variable a real value instead of `null`, e.g. `String missing = "";`
(or check `if (missing != null)` before calling `length()`).
