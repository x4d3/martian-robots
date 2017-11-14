# martian-robots Developer Programming Problem  



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
