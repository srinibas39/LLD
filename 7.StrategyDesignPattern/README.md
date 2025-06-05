# Strategy Design Pattern – Robot Example

## 🧠 Introduction

Design patterns are common solutions that developers rely on to solve recurring design challenges. In most real-world applications, we deal with code that changes frequently and some that remains stable. [Design patterns](http://constantly.Design) help us manage the parts that are expected to change without breaking the rest of the system.

The **Strategy Design Pattern** is one of those patterns that favors **composition over inheritance**. It helps you encapsulate a family of related behaviors and lets you change them at runtime.

---

## 🛠️ Stage 1: Basic Robot Design (Using Inheritance)

```java
class Robot {
    void walk();
    void talk();
    void projection(); // This behavior doesn’t change
}
```

We start with a simple class structure. Now, imagine we want to build a few specific robots:

* `CompanionRobot` → has its own `projection()` logic
* `WorkerRobot` → same
* `SparrowRobot` → can `fly()` in addition to the above
* `CrowRobot` → also needs to `fly()`

At this point, we might be tempted to use inheritance and add `fly()` directly to some subclasses. But this breaks the **DRY principle** and quickly gets messy.

![Stage 1 Design](attachment:92771cc3-2505-4414-a2fe-0cbdd6361118\:image.png)

---

## 🧩 Stage 2: Introducing Interfaces

To clean things up, we introduce interfaces like `Flyable`. So `SparrowRobot` and `CrowRobot` can implement that interface.

But then we need to add `Talkable`, `Walkable`, etc. Every new behavior means more interfaces, and the inheritance hierarchy becomes hard to manage.

![Stage 2 Design](attachment\:b8fa0e0b-97ea-4d6e-bb09-b3f802a0f986\:image.png)

---

## ⚠️ Stage 3: Explosion of Interfaces

Now we’re heading into dangerous territory. Each new behavior requires a new interface. Suddenly our clean design starts to look more like a tangled web. Code reuse becomes tricky, and flexibility goes out the window.

![Stage 3 Design](attachment:8fd6a3f6-456a-42fe-817e-0608bc381fd9\:image.png)

---

## ❌ Problems with Inheritance

Why does this approach become a problem?

* It limits **code reuse**
* Adding new features means **modifying many classes**
* It breaks the **Open/Closed Principle (OCP)** – classes should be open for extension but closed for modification

![Inheritance Problems](attachment:9f132f91-ea45-44f2-b26e-3a3b314ffcba\:image.png)

---

## ✅ Strategy Design Pattern to the Rescue

Here’s a better way.

> The Strategy Pattern defines a family of algorithms, encapsulates each one, and makes them interchangeable. This lets you change behaviors at runtime without touching the main logic.

### Final Design Structure

We refactor the `Robot` class to contain references to strategies:

* `Talkable` → `talk()`
* `Walkable` → `walk()`
* `Flyable` → `fly()`

These are interfaces. We then create different concrete implementations like:

* `NormalTalk`, `NonTalk`
* `NormalWalk`, `NonWalk`
* `NormalFly`, `NonFly`, `JetFly`

This gives us flexibility. Now, when creating a robot, we just plug in the desired behaviors.

### Example

```java
Robot robot = new CompanionRobot(
    new NormalTalk(),
    new NormalWalk(),
    new NonFlyable()
);
```

Simple and clean. We can even swap behaviors at runtime if needed.

![Strategy Pattern Final](attachment:2e5dd0da-809b-4142-a167-ec94e5b6b21c\:image.png)

---

## 📌 Key Takeaways

* Use **interfaces** to define a family of interchangeable behaviors
* Let concrete classes implement each strategy
* Let the main object (like `Robot`) delegate behavior to these strategy classes
* This pattern follows **composition over inheritance**, making your code more flexible and easier to extend

---

That’s the essence of the Strategy Pattern – give your objects the power to decide their behavior at runtime.

Happy coding 🤖✨
