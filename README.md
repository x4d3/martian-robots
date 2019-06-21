# martian-robots 

## Developer Programming Problem  

[![Build Status](https://travis-ci.org/x4d3/martian-robots.svg?branch=master)](https://travis-ci.org/x4d3/martian-robots)

This project requires Java 8.

The entry point is in [com.example.Main](src/main/java/com/example/Main.java)

Execute Tests
```
mvn clean test
```

Create executable jar
```
mvn clean compile assembly:single
```

Then execute calling 
```
java -jar target/martian-robots-1.0.0-jar-with-dependencies.jar examples/input1.txt
```
