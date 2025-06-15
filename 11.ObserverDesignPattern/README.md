# Observable Design pattern

This pattern involves if subscriber is subscribed to a youtube channel , if a new video is released , then how it will be notified to its subscribers

The first tchnique is polling —> but polling involves continues calling from obersvers to observersable at a certain freq ehich may not feasible

The seond technique pushing —> obeservable Design pattern

**UML Diagram**

![image.png](Observable%20Design%20pattern%2021116c3ab0a5809abdc3e950a6964dd9/image.png)

Defination of Observer design pattern

![image.png](Observable%20Design%20pattern%2021116c3ab0a5809abdc3e950a6964dd9/image%201.png)

Youtube example

![image.png](Observable%20Design%20pattern%2021116c3ab0a5809abdc3e950a6964dd9/image%202.png)

- Observer Design pattern breaks Single Responsibilty Principle because it it subscribing / unscubscribing but also notifying the users.
- Its a tradeoff , we can also fix it by making IChannel class and implementing the class , and concrete class will have noitfication logic.