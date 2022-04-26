> source 🌐 https://refactoring.guru/design-patterns/factory-method
> Also known as: Virtual Constructor
## Intent
**Factory method** is a creational design pattern that provides an interface for creating objects in a superclass, buit allows subclasses to alter the type of object that will be created
## Structure 
![image](https://user-images.githubusercontent.com/80462415/165102544-5faaa9b1-10cd-48ff-a398-d1fe08f2b476.png)
1. Product declares the inteface, which is common to all objects that can be produced by the creator and its subclasses
2. Concrete PRoductsa re different implementations of the product interface
3. The Creator class declares the factory method that returns new product objects. It's important that the return type of this method matches the product interface

## Final Conclusion
- The thing we are doing is OBVIOUSLY **HIDING** some information, actually the code for some classes or method that we or clients do not want to touch or to know. Simply, we provide the client a **factory** and the client just need to come to the factory to ask for some products without acknowledging any of the processes that factory used.
