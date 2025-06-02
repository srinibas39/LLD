# SOLID Principles - Part 2

## Liskov Substitution Principle (LSP) - Continued

### Signature Rules

- **Method Argument Rule**:  
  If the parent class has a method `void solve(int data)`, the child class should override it with the same signature or a narrower (more specific) argument type.

- **Return Type Rule**:  
  The overridden method in the child class must return the same type or a subtype (narrower type).

- **Runtime Exception Rule**:  
  The child class's overridden method should throw the same or a narrower (more specific) exception.

---

### Property Rule

- **Class Invariant**:  
  If the parent class enforces an invariant (e.g., balance in a `BankAccount` must not be negative), the child class must also enforce the same.

- **Property Rule**:  
  A child class must be able to use all methods of the parent class without altering behavior. If it can’t, it breaks the property rule.

- **Immutable Design Considerations**:
  - **Immutable Class**: A class that cannot be inherited.
  - **Immutable Method**: A method that cannot be overridden.

> Avoid introducing mutability that would violate the parent's behavior or contract.

---

### Method Rules

- **Pre-condition Rule**:  
  The child method can weaken pre-conditions but should not remove them.  
  _Example_: If the parent requires a `num >= 5`, the child may allow `num >= 3`, but not eliminate the check entirely.

- **Post-condition Rule**:  
  A child method can strengthen the outcome but must fulfill the parent’s expectation.  
  _Example_:  
  `Car.brake()` → reduces speed  
  `ElectricCar.brake()` → reduces speed **and** charges the battery.

---

## Interface Segregation Principle (ISP)

It is better to have many specific interfaces than a single general-purpose one.

- A client should not be forced to depend on methods it does not use.

---

## Dependency Inversion Principle (DIP)

- High-level modules should not depend on low-level modules.
- Both should depend on abstractions (e.g., interfaces).
- Abstractions should not depend on details; details should depend on abstractions.

