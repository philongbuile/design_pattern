#Iterator pattern
![image](https://user-images.githubusercontent.com/80462415/162025548-f70f2d9c-eca6-450f-be8e-cb371e18d1ae.png)

You may visit these websites for more information about this pattern: 
1. https://gpcoder.com/4724-huong-dan-java-design-pattern-iterator/ (vietnamese's source)
2. https://refactoring.guru/design-patterns/iterator

![image](https://user-images.githubusercontent.com/80462415/162025430-73ee50e8-4627-4706-91b8-6529647241d0.png)


##Problem
⚠️Collections are one of the most used data types in programming, a colletion is a container for a group of object
![image](https://user-images.githubusercontent.com/80462415/162026104-dc191755-8866-4b42-87e6-f04c7f5eb185.png)

- There are many types of structure like list, stacks, trees, graph,...
- No matter how a collection is structured, it must provide some way of accessing its element so that other code 
can use these elements
![image](https://user-images.githubusercontent.com/80462415/162026380-c5070d3f-549b-43e3-8cc3-da8e14fd8b9d.png)

## 💡Solution
The main idea of the Iterator pattern is to extract the traversal behavior of a collection to a seprate object called an iterator
![image](https://user-images.githubusercontent.com/80462415/162026644-a95c554e-12f9-48c7-9e65-e863f87837c5.png)
## 🏗️Structure
![image](https://user-images.githubusercontent.com/80462415/162026700-49175cf3-e891-48db-a32c-d388289581af.png)
  1. **Iterator** interface declares the operations requires for traversing a collection: fetching next element, retrieving current position,...
  2. **Concrete Iterators** implement specific algorithm for traversing a collection. The iterator object should track the traversal progress on its own. THis allows several iterators to traverse the same collection independently of each other
  3. **Collection** interface declares one or multiple methods for getting iterators compatible with the collection
  4. **Concrete Collection** return new instances of a particular concrete iterator class each time th client requests one. 
