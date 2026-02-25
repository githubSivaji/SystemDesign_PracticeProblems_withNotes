### **Rate Limiter**



A rate limiter controls how many requests a client / user can make within a timeframe.

It acts as a traffic controller for your api, allowing, for example , 100 requests per minute from a user 3 then rejecting excess request

with an http 429 "Too many request" response. It prevents abuse protect your servers being overwhelmed by bursts of traffic, and ensure fair usage across all users.





**Step 1. Requirements**



---> **functional requirements** \[Features of system].                             1. where should our rate limiter live in our architecture ?

           - identify users by Id, Ip, or API key                                                    2. How should we identify clients \[whether it is id, ip ,api key]? 

           - limit requests based on configurable users

           - return proper error headers and status code



ask Interviewer

    scale: example \[ 100 million daily users

                                      1 million requests per second ]



 

**---> Non functional requirements**

&nbsp;       - availability >> consistency

&nbsp;       -low latency rate limit checks(<10ms)

&nbsp;       -scalable to 1m rps



**Step 2. Core Entities  \& Interface** 



---->  **Core Entities**

&nbsp;                             -Request

&nbsp;                             - client (Ip, userId,  ApiKey)

&nbsp;                             -Rules(100 r/s )



**--->  System Interface **

                          **-** isRequestAllowed(clientsId, rulesId)--> { passes: Boolean , remaining  number , resetTime: timestamp}



