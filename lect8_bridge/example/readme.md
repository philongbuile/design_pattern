## Devices and remote controls (Example)
This example shows separtation between classes of remotes and devices that they control

Remote act as abstractions, and devices are their implementations. Thanks to the common interfaces, the same remotes can work with different devices and vice versa

The Bridge pattern allows changing or even creating new classes without touching the code of the opposite hierarchy
## Core 🔷
- The **core** here is how you deal with the concept of making the life of client easier. 
- In this example, the "**bridge**" brings the client to the TV,Radio is the "**Remote**".
- We, the developer knows all the work of the TV and radio, but let's imagine if client they do not know the codes of them. Then thanks to this, they can still communicate with the TV and Radio through the **_remote_** interface.
