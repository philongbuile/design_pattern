## Final conclusion
Builder is just like a complex version of the factory methods.

Remeber from the factory method, we provide clients a factory that they can go there and ask for some products, but, those products are kinda boring in term of version.

If they want to customize some of the products that the factory has produced, we would give them a thing called **'builder'** for them to freely customize their products.

# Example
Suppose the clients want to buy some cakes 🍰
- If we provide them a factory, we just have some types of cake that could be sold to the client. For example: cheese cake, apple cake, tiramisu,...
- What would happen if some clients say he/she want to have some customized cakes such as: rounded cheese cake, square apple cake, super large extra sugar plus chocolate tiramisu ?
-> The solution is we not gonna give them a normal factory anymore, we will give them a better **_factory_** called 'builder'. This builder can help them customize their product as how uniquely as they want 
![image](https://user-images.githubusercontent.com/80462415/165350915-2813601d-0b45-4ea2-9d48-e2393b1db3c3.png)
-> Our work, the developers' work, is to create more and more concrete builder to satisfy the clients' demands
- Like in this example, we will have an interface called "CakeBuilder", and the implementations of it should be like : "CheeseCake", "RoundedCheeseCake","SquareCheeseCake",... and so on
