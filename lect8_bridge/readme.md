# Brigde Pattern

> Source ℹ️: https://refactoring.guru/design-patterns/bridge

## Intent 📃
**Bridge** is a structural design pattern that lets you split a large class or a set of closely related classes into two separate hiearchies - abstraction and implementation - which can be developed independently of each other
![image](https://user-images.githubusercontent.com/80462415/162028850-fb8afecd-8c90-4a19-940b-0f1dd1b9c413.png)

## Problem ⚠️ 
Say we have a **Shape** class with a pair of subclasses: **Circle** and **Square**. We want to extend this class hierarchy to incorporate colors, so, we plan to create **Red** and **Blue** shape subclasses. However, since we already have two subclasses, we will need to create four class combination such as **BlueCircle** and **RedSquare**
![image](https://user-images.githubusercontent.com/80462415/162029232-3dc7fc92-2227-4708-bb56-77a544998f7a.png)
😵 Adding new shape types and colors to the hiearchy will grow it exponentially....The further we go, the worse it becomes

## Solution 💡
This problem occurs since we're trying to extend the shape classes in two independent dimensions: form  and color. 

**The Bridge Pattern** attempt to solve this problem by switching from inheritance to object composition

This means you extract one of the dimensions into a seperate class hierarchy, so that the original classes will reference an object of the new hiearchy instead of having all of its state and behaviors within one class
![image](https://user-images.githubusercontent.com/80462415/162029868-8d38bd06-5401-458e-b807-dd830697f299.png)
## Structure 🏗️
![image](https://user-images.githubusercontent.com/80462415/162030063-08ee8f8c-c735-4d6f-bf0a-ad0e6e3f42a6.png)

1. The Abstraction provides high-level control logic. It relies on the implementation object to do the actual low-level work
2. The Implmentation declares the interface that's common for all concrete implementations. An abstraction can only communicate with an implementation object via method that are decleared there
 The abstraction may list the same methods as the implementation, but usually the abstraction declares some complex behaviors that rely on a wide variety of primitive operations declared by the implementation.

3. Concrete Implementations contain platform-specific code.

4. Refined Abstractions provide variants of control logic. Like their parent, they work with different implementations via the general implementation interface.

5. Usually, the Client is only interested in working with the abstraction. However, it’s the client’s job to link the abstraction object with one of the implementation objects.

# Pseudocode ( Example )

## How Bridge pattern can help divide the monolithic code of an app that manages devices and their controls.
![image](https://user-images.githubusercontent.com/80462415/162031340-e7d8746d-43fa-40de-a35e-8fe1b83a099c.png)


**Devices** act as the implementation, where **Remote** act as the abstraction
