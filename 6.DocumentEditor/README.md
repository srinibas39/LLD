# 📚 Design Approaches in Software Development

We can follow either a **top-down** approach or a **bottom-up** approach when designing software systems.  
With time and experience, you'll figure out what works best in a given situation.

---

For Images
https://www.notion.so/Document-Editor-20716c3ab0a5809f9bacd5293ff692b4

## ❌ Bad Design

![Bad Design]
![image.png](attachment:0d80c6ee-bc45-4f0e-b3e3-7de71f75f9e5:image.png)

---

## ✅ Document Editor Design (Initial Version)

![Initial Design](https://www.notion.so/image/21ed1e58-bd33-4523-bf94-524649031131)

- This design follows **SOLID principles** and is modular.
- However, there is a **design issue**:
  - The **client** has to know how to call `addText()`, `addImage()`, and `render()`.
  - The `Document` class is handling both **data storage** and **rendering**, which may blur responsibilities.

---

## ⚠️ Law of Demeter Violation

![Demeter Violation](https://www.notion.so/image/5958f977-6e07-4333-a3aa-91e7a21b88ff)

- The above design **violates the Principle of Least Knowledge (Law of Demeter)**.
- A class should **only talk to its immediate friends**, not deep internal structures.
- The client is accessing and managing too much detail from the internals of the `Document` class.

---
