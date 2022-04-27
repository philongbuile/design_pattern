### Prototype
## Intent
Prototype is a creational design pattern that lets you copy existing objects without making your code dependent on their classes
![image](https://user-images.githubusercontent.com/80462415/165425210-a0d381a1-fb10-4f1a-adae-5a25a3f94192.png)

## Problem
![image](https://user-images.githubusercontent.com/80462415/165425251-1f1808dd-4b31-4a84-8b08-a63a41fb69ff.png)
> Copying an object "from the outside" isn't always possible

## Solution
The prototype pattern delegates the cloning process to the actual objects that are being cloned

  - declares a common interface for all objects that support cloning
  - the implementation ò thê clone method í very similar in all classes
  - the method creates an object ò the curent calss and caries over all of the field value of the old objects into the new one
-> How it works: create a set of object, configured in various ways. When you need an object like the one you've configured, you just clone a prototype instead of contructing a new object from scratch
## Real-World Anology 🚙
In real life, prototypes are used for performing various tests before starting mass production of a product. However, in this case, prototypes don’t participate in any actual production, playing a passive role instead.
![image](https://user-images.githubusercontent.com/80462415/165426113-96219eae-5916-40bc-9f72-4f9166dcd4fc.png)
## Structure 🏗️
![image](https://user-images.githubusercontent.com/80462415/165426147-c47b403b-923c-4023-90e0-1977994399a0.png)
1. Prototype interface declares the cloning methods. In most cases, it's a single _clone_ method
2. The Concrete Prototype class implements the cloning mthod. In addition to copying the original objects' data to the clone, this method may also handle some edge cases of the cloning process related to cloning linked objects, untangling recursive dependencies, etc.
3. The **Client** can produce a copy of ny object that follows the prototype interface 
