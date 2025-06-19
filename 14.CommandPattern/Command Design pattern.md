# Command Design pattern

- The Command Pattern turns a request into an object, so you can pass it around, store it, or undo it later.
- Basically we have source -->(req) receiver, we turn the req into object
- Real life Application
- Undo" last action.
    - "Schedule" commands for later.
    - "Group" commands (turn on all devices at once).
    - "Save and replay" scenes (e.g., Night Mode, Party Mode).
- Design a smart home application

![image.png](Command%20Design%20pattern/image.png)

- UML

![image.png](Command%20Design%20pattern/image%201.png)