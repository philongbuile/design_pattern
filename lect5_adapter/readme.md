
## Adapter Patterm
> source 🌐:https://bitly.com.vn/vcatne
# Real-World Analogy 🚙
![image](https://user-images.githubusercontent.com/80462415/165436351-096b7eae-7376-4447-8a54-3a9da36f3f24.png)
When you travel from the US to Europe for the first time, you may get a surprise when trying to charge your laptop. The power plug and sockets standards are different in different countries. That’s why your US plug won’t fit a German socket. The problem can be solved by using a power plug adapter that has the American-style socket and the European-style plug.

#Intent
Apdapter is a structural design pattern that allows objects with incompatible interfaces to collaborate

# 🏗️Structure
**Object adapter**


This implementation uses the object composition principle: the adapter implements the interface of one object and wraps the other one. It can be implemented in all popular programming languages


![image](https://user-images.githubusercontent.com/80462415/164279936-eba202ca-ce61-497b-92e2-cb05373c7d5a.png)

The Client is a class that contains the existing business logic of the program.

The Client Interface describes a protocol that other classes must follow to be able to collaborate with the client code.

The Service is some useful class (usually 3rd-party or legacy). The client can’t use this class directly because it has an incompatible interface.

The Adapter is a class that’s able to work with both the client and the service: it implements the client interface, while wrapping the service object. The adapter receives calls from the client via the adapter interface and translates them into calls to the wrapped service object in a format it can understand.

The client code doesn’t get coupled to the concrete adapter class as long as it works with the adapter via the client interface. Thanks to this, you can introduce new types of adapters into the program without breaking the existing client code. This can be useful when the interface of the service class gets changed or replaced: you can just create a new adapter class without changing the client code.

## #Pseudocode
This example of the Adapter pattern is based on the classic conflict between square pegs and round holes.
![image](https://user-images.githubusercontent.com/80462415/165437973-4f9a79eb-d448-4b02-b9c2-647e39ece8f4.png)

