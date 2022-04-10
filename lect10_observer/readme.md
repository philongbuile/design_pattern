#Observer

🐲It's easy, you can understand it simply like

![image](https://user-images.githubusercontent.com/80462415/162475209-32bb11ef-6896-4660-8a49-78d13af807cf.png)

If you subscribe to a newspaper or magazine, you no longer need to go to the store to check if the next issue is available. Instead, the publisher sends new issues directly to your mailbox right after publication or even in advance.

The publisher maintains a list of subscribers and knows which magazines they’re interested in. Subscribers can leave the list at any time when they wish to stop the publisher sending new magazine issues to them.

🚑 Some source said they are called "Subject" and "Observer", others call them "Publishers" and "Subsribers", they are the same.

About the Structure, simply, we need an Interface for "Subjects" or "Publishers", and an Interface for "Subscribers" or "Observers" and the concrete instances of them.

Concrete Subjects have a list of Observers, requires method for notifyAllObservers()

Concrete Observers have an update(context) method, and the constructor of Observer will let the Subjects add the observers into its list.
![image](https://user-images.githubusercontent.com/80462415/162623437-f8b88a18-330f-44e6-ab44-2162f6a7715a.png)

Then things will be done, good luck !
