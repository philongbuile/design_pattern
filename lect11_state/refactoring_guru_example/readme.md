## Topic 1
Imagine we have a Document class. A document can be in one of three states: Draft, Moderation, and Published

The publish method of the document works a little bit differnetly in each state: 
- In _Draft_, it moves the document to moderation
- In _Moderastion_, it makes the document public, but only if the current user is an administrator
- In published, it doesn't do anything at all
![image](https://user-images.githubusercontent.com/80462415/164150386-103c5e7d-6395-4fc1-917e-d8ead14a483f.png)

## Topic 2
The button and swithces in your smartphone bahave differently depending on the current state of the device:
1. When the phone is unlocked, pressing buttons leads to executing various functions
2. when the phone is locked, pressing any button leads to the unlokc screen
3. When the phone's charge is low, pressing any button shows the chargin screen
#pseudocode
![image](https://user-images.githubusercontent.com/80462415/164152740-edcb4bca-086e-488f-8975-db1845b4e3df.png)
