## Visitor Pattern 

# Real-World Analogy
![image](https://user-images.githubusercontent.com/80462415/164970891-c5867f9a-dfce-4878-8576-95a45861343e.png)
Imagine a seasoned insurance agent who’s eager to get new customers. He can visit every building in a neighborhood, trying to sell insurance to everyone he meets. Depending on the type of organization that occupies the building, he can offer specialized insurance policies:

If it’s a residential building, he sells medical insurance.
If it’s a bank, he sells theft insurance.
If it’s a coffee shop, he sells fire and flood insurance.

# Intent 
Visitor is a behavioral design pattern that lets you separate algorithms from the objects on which they operate

# Solution
The Visitor pattern suggests that you place the new behavior into a separate class called _visitor_, instead of trying to integrate it into existing classes. The original object that had to perform the behavior is now passed to one of the visitor's methods as an argument, providing the method access to all necessary data contained within the object
# Structure 🏗️
![image](https://user-images.githubusercontent.com/80462415/164970920-8f0d6577-023a-4657-8f8a-5790d692c3af.png)
