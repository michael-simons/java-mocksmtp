# A super simple local mocksmtp server based on subethasmtp

java-mocksmtp starts a local smtp for mocking etc. based on [subethasmtp](https://github.com/voodoodyne/subethasmtp).

Just clone the repository and run

```
mvn exec:java
```  

to start a server on port 25000 that prints all incoming mails to the console.  
