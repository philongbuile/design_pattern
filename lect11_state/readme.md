ℹ️ Source : https://refactoring.guru/design-patterns/state
ℹ️ Source : https://gpcoder.com/4785-huong-dan-java-design-pattern-state/

## What is State Pattern ? 
State Pattern is one eof the Behavior Patterns. It allows one object chnage its state when its internal state change.
Object will appear to change its class
## ⁉️ Prolem
The State pattern is related to the concept of Finite-State Machine
![image](https://user-images.githubusercontent.com/80462415/164145988-1843b2fb-8ac6-4bcb-bc8f-508b42866921.png)
- The main idea is at any time, there is a finite number of states which a program can be in
- Within any unique statem the program behaves differentlym and the program can be switched from one state to another instantaneously
- However, depending on a current state, the program may or may not switch to certain other states
- The **switching rules** called _transitions_ are also finite and predetermined.
## 😄 Solution
 To talk about this solution, I have generalized the structure of this State Pattern
 1. There are 3 types of classes for this pattern, a Context, an interface called 'State', and some other 'Concrete State'
 2. Context will represent the real object that we want to put the State in, for example, if we want to write a program for a keyboard ( like in my example ), the 'Context' represents the Keyboard 
 3. The interface 'State' is responsible for structuralizing any of the 'States' that the Context  gonna have. The **State interface** declares the state-specific methods, and these should make sense for all concrete states since we don't want some of our states have any useless method
 4. The 'concrete state' classes is instances of interface 'state', those are where we **define** the status of our context.
 5. Both **context** and **concrete states** can set the next state of the context and perform the actual state transition by replacing the state object linked to the context.
 
 
 ![image](https://user-images.githubusercontent.com/80462415/164146794-42073e9d-e5c5-4e03-a501-3c7e435f543e.png)

## 😱 end
check out some example
