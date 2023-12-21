# FastJavaPointer
## What is this?

FastJavaPointer is a library to easily attach object to class at runtime without the need to use asm or java reflection.

## How to use it?

### Add the library to your project

#### Maven

```mvn
Coming soon
```

#### Gradle

```groovy
Coming soon
```

### implement Pointable in your class

```java
public class Player implements Pointable {
    private String name;
    private int age;
    
    public Player(String name, int age,PointerManager pointerManager) {
        super(pointerManager);
        this.name = name;
        this.age = age;
    }
}
```

### Initialize a PointerManager for your class

here are two ways to do it:

#### 1. Using one of the default PointerManager

```java
PointerManager pointerManager = PointerManager.createLogicPointerManager();
PointerManager pointerManager = PointerManager.createSingleWayPointerManager();
```


#### 2. Create your own PointerManager

```java
public class CustomPointerManager implements PointerManager{
    private int index = 43958374;
    @Override
    public int createNewPointer() {
        return index--;
    }
}
```

### Attach the PointerManager to the Pointable object

```java
Player player = new Player("Bob", 20, pointerManager);
Player player = new Player("Alice", 40, pointerManager);
```

### Create a Collection

A collection is a class that will hold a single object of a desired type per pointer.

to create a collection you need to implement the PointerCollection interface

```java
PointerCollection<CustomClass> collection = new PointerCollection<CustomClass>();
```

### Read and write to the collection

to read and write to the collection you need to use the class on which you implemented the Pointable interface

```java
public void example(Player player){
    player.writePointer(collection, new CustomClass());
    CustomClass customClass = player.readPointer(collection);
}
```

## Difference between the two PointerManager

### LogicPointerManager

The LogicPointerManager allows to release the pointer therefore allowing the pointer to be reused by another object.

#### use case

- A game where you have a lot of object that are created and destroyed at runtime
- A game where players can join and leave the game at any time

#### advantages
- Low memory usage
- The pointer can be reused
- The pointer can be released
- up to 10000000 pointer can exist at the same time

#### disadvantages
- Complex to use
- manual pointer release

### SingleWayPointerManager

The SingleWayPointerManager is good for when you have object who life indefinitely and you don't want to release the pointer.

#### advantages
- Easy to use
- No pointer management needed
- Faster pointer creation

#### disadvantages
- Higher memory usage
- Most likely to run out of pointer
- maximum 10000000 pointer can be created

## Benchmark

### Test environment

- CPU: Intel(R) Core(TM) i7-7700HQ CPU @ 2.80GHz
- RAM: 16GB
- OS: Windows 10
- Java: 1.8.0_271
- JVM: OpenJDK 64-Bit Server VM (25.271-b09, mixed mode)

#### comparison

# Insertion Benchmark Results

| Count | Fast Java Pointers | HashMap |
|-------|--------------------|---------|
| 10    | 0 ms               | 0 ms    |
| 100   | 0 ms               | 0 ms    |
| 1000  | 0 ms               | 0 ms    |
| 10000 | 0-2 ms             | 1 ms    |
| 100000| 0-35 ms            | 12 ms   |
| 1000000| 0-394 ms           | 110 ms  |
| 10000000| 0-394 ms          | 726 ms  |


**Insertion Time Ranges:**
- Fast Java Pointers: 0 ms - 394 ms
- HashMap: 0 ms - 726 ms

# Retrieval Benchmark Results

| Count | Fast Java Pointers | HashMap  |
|-------|--------------------|----------|
| 10    | 0 ms               | 0 ms     |
| 100   | 0-1 ms             | 0 ms     |
| 1000  | 0-1 ms             | 1 ms     |
| 10000 | 0 ms               | 2 ms     |
| 100000| 0-3 ms             | 13 ms    |
| 1000000| 0 ms               | 93 ms    |
| 10000000| 0 ms               | 820 ms   |

*Note: All times are in milliseconds.*

**Retrieval Time Ranges:**
- Fast Java Pointers: 0 ms - 3 ms
- HashMap: 0 ms - 820 ms

