# Decorator Design pattern

- It is used when want to add additional functionality during runtime.
- But we can do same thing using inheritance but inheritance causes hierarchy issue , class explosion etc.
- Lets understand DDP using mario game
- Mario need to level up during gameplay like height inc , star power , shooting ability
- using inheritance (but will cause problems when we want to inherit combinationd of levels ip)

![image.png](Decorator%20Design%20pattern%2021316c3ab0a580adbbd5fd634468bfaa/image.png)

- Decorator pattern is lika a wrapper over the base class

![image.png](Decorator%20Design%20pattern%2021316c3ab0a580adbbd5fd634468bfaa/image%201.png)

- Mario game UML using decorator
- Decorator is a combination of is-a and has a relationship

![image.png](Decorator%20Design%20pattern%2021316c3ab0a580adbbd5fd634468bfaa/image%202.png)

- Easy when we will use combinations of powerups, it will do something like recursion.

![image.png](Decorator%20Design%20pattern%2021316c3ab0a580adbbd5fd634468bfaa/image%203.png)

- Standard UML

![image.png](Decorator%20Design%20pattern%2021316c3ab0a580adbbd5fd634468bfaa/image%204.png)

- Defination

![image.png](Decorator%20Design%20pattern%2021316c3ab0a580adbbd5fd634468bfaa/image%205.png)

- Real world usecase of decroarator design pattern —>

Text Edtior , Form check validator