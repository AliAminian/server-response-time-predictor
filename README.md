# servicedelaypredictor
This is an example to show how Spark ML could be used to predict response time of a service for a server-side application.
The number of parameters that model a service for our ml-based module can differe and we could intensify the important parameters with suitalbe coefficients.
# Ideas
1) In a server/client scenarios that different services from server-side application, response time of a server for its services could be vital for client. This module could predict the response time of an especial service. Indeed, the response time as an important factor  helps administrators to make a suitalbe decision in different situations in real-world usage of services for their servers to be responsive and available.
2) There are many multi-instance server side applications that the number of instantians depends on the hardware of machine used in operational environments (e.g. RAM Space, CPU cors, etc). In fact, developers and tester may not pre-define a constant number of instances for their multi-instance server-side applications on different machines configuration. Based on this module we could have a intelligent module for automatically tunning the number of instanciation with predicating the response time of different instance of server application.

# How the module could help

![architecture](https://user-images.githubusercontent.com/17087119/45584337-0c698c00-b8e7-11e8-8dc5-ce2eb3fb9658.png)
