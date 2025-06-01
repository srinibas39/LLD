

# SOLID Principles Overview

The SOLID principles were introduced to improve the **maintainability**, **readability**, and **scalability** of object-oriented code.

---

## 1. Single Responsibility Principle (SRP)

> **Definition**: Every class should have a single responsibility or purpose.

### ❌ Violation Example:

We are building a shopping cart:

* `Product` class → holds `name`, `price`.
* `ShoppingCart` class → contains:

  * `calculateCartTotal()`
  * `printInvoice()`
  * `saveToDB()`

This violates the SRP because `ShoppingCart` is handling **calculation**, **printing**, and **persistence** — **three responsibilities**.

### ✅ Correct Implementation:

* **`ShoppingCart`** → `calculateCartTotal()`
* **`InvoicePrinter`** → `printInvoice(ShoppingCart cart)`
* **`CartStorage`** → `saveToDB(ShoppingCart cart)`

> **Note**: People often confuse SRP with having only **one method per class**. That’s incorrect. A class can have **multiple methods**, but they should all be part of **one responsibility**.

---

## 2. Open/Closed Principle (OCP)

> **Definition**: A class should be **open for extension** but **closed for modification**.

### ❌ Violation Example:

You want to save cart data in multiple places:

```java
class DBStorage {
    void saveToDB() { ... }
    void saveToFile() { ... }
    void saveToMongoDB() { ... }
}
```

This violates OCP — modifying the existing class to add new functionality.

### ✅ Correct Implementation:

* Create an abstract class or interface:

```java
interface Persistence {
    void save(ShoppingCart cart);
}
```

* Extend it in multiple classes:

```java
class SaveToSQL implements Persistence { ... }
class SaveToMongoDB implements Persistence { ... }
class SaveToFile implements Persistence { ... }
```

> Later, to support saving to Cassandra, just create a new `SaveToCassandra` class implementing `Persistence`.

---

## 3. Liskov Substitution Principle (LSP)

> **Definition**: Subclasses should be **substitutable** for their parent classes without altering the correctness of the program.

### ❌ Violation Example:

```java
abstract class Account {
    abstract void deposit();
    abstract void withdraw();
}

class FDAccount extends Account {
    void deposit() { ... }
    void withdraw() {
        // Throws exception — FD doesn't support withdrawal
    }
}
```

This violates LSP — the client expects `withdraw()` to work, but it fails in `FDAccount`.

### ✅ Correct Implementation:

Separate interfaces:

```java
interface NonWithdrawableAccount {
    void deposit();
}

interface WithdrawableAccount extends NonWithdrawableAccount {
    void withdraw();
}
```

* `FDAccount` implements `NonWithdrawableAccount`
* `SavingsAccount` and `CurrentAccount` implement `WithdrawableAccount`

> This way, clients depending on `WithdrawableAccount` can safely call both methods.

---

## Summary Diagram References

You can refer to the following diagrams to visualize each principle:

1. **SRP**: Class split into Invoice and Storage.
2. **OCP**: Abstraction with `Persistence` interface and multiple implementations.
3. **LSP**: Interface segregation for account types.

