> source 🌐 : https://bitly.com.vn/j2w0jq
## Singleton
## 🚗 Real-World Analogy
The government is an excellent example of the Singleton pattern. A country can have only one official government. Regardless of the personal identities of the individuals who form governments, the title, “The Government of X”, is a global point of access that identifies the group of people in charge.

## Intent
**Singleton** is a creational design pattern that lets you ensure a class has only one instance, while providing a global access point to this instance
![image](https://user-images.githubusercontent.com/80462415/165422019-922d6700-07ef-4b77-8e04-5ef0cccf8519.png)

## Problem
The singleton pattern solve two problems at the sametime, violating the _SIngle Responsibility Principle_

1. Ensure that a class has just a single instance
2. Provide a global access point to that instance

### Solution
All implementations of the Singleton have these two steps in common:
1. Make the default constructor private: to prevent other objects from using the **new** operator with the Singleton class
2. Create a static creation mthod that acts as a constructor. Under the hood, this method calls the private constructor to create an object and saves it in a static field. All following calls to this method return the cached object.

If your code has access to the Singleton class, then it's able to call the Singleton's static method. So whenever that method is called, the same object is always returned.
