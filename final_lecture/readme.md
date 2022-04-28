## refactoring
- change the code to improve the design => to understand, maintain, test easier

## cohesiveness

Cohesion is used to indicate the degree to which a class has a single, well-focused purpose. Coupling is all about how classes interact with each other, on the other hand cohesion focuses on how single class is designed. Higher the cohesiveness of the class, better is the OO design.

**Benefits of Higher Cohesion:**

- Highly cohesive classes are much easier to maintain and less frequently changed.
- Such classes are more usable than others as they are designed with a well-focused purpose.

## Coupling
Coupling is the degree to which one class knows about another class. Let us consider two classes class A and class B. If class A knows class B through its interface only i.e it interacts with class B through its API then class A and class B are said to be loosely coupled.

If on the other hand class A apart from interacting class B by means of its interface also interacts through the non-interface stuff of class B then they are said to be tightly  coupled. Suppose the developer changes the class B‘s non-interface part i.e non API stuff then in case of loose coupling class A does not breakdown but tight coupling causes the class A to break.

So its always a good OO design principle to use loose coupling between the classes i.e all interactions between the objects in OO system should use the APIs. An aspect of good class and API design is that classes should be well encapsulated.

## Testing
1. need to know what you are testing
2. set up the scenario
3. interpret the result

### SOLID Principle 
1. Single Responsibility Principle
One class does one thing and every class or module only has responsibility for one part of the software's functionality
2. Open-Closed Principle
- Open for extension
- Close for modification
-> through abstractions -> using inheritance or interfaces
