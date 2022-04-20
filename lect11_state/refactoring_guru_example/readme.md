## Topic
Imagine we have a Document class. A document can be in one of three states: Draft, Moderation, and Published

The publish method of the document works a little bit differnetly in each state: 
- In _Draft_, it moves the document to moderation
- In _Moderastion_, it makes the document public, but only if the current user is an administrator
- In published, it doesn't do anything at all
![image](https://user-images.githubusercontent.com/80462415/164150386-103c5e7d-6395-4fc1-917e-d8ead14a483f.png)
