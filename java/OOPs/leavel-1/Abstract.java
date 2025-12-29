
//1.
abstract class Vehicle {
    abstract void start();
}

class Car extends Vehicle {
    void start() {
        System.out.println("Car is starting...");
    }
}

class Bike extends Vehicle {
    void start() {
        System.out.println("Bike is starting...");
    }
}

// 2.

interface Playable {
    void play();
}

class Guitar implements Playable {
    public void play() {
        System.out.println("Guitar is Playing...");
    }
}

class Piano implements Playable {
    public void play() {
        System.out.println("Piano is Playing...");
    }
}

// 3.
abstract class Bug {
    Bug() {
        System.out.println("Syntx err");
    }

    public abstract void run();
}

class Program extends Bug {
    public void run() {
        System.out.println("Bug fixed!");
    }
}

// 5.
interface A {
    void Aa();
}

abstract class B implements A {
    public abstract void Bb();
}

class C extends B {
    public void Aa() {
        System.out.println("A");
    }

    public void Bb() {
        System.out.println("B");
    }
}

public class Abstract {
    public static void main(String[] args) {
        System.out.println("Welcome to Abstract");

        // 1.
        Car c = new Car();
        Bike b = new Bike();
        c.start();
        b.start();

        // 2.
        Guitar g = new Guitar();
        g.play();
        Piano p = new Piano();
        p.play();

        // 3.
        // abstract class are the class with abstract but interfaces are abstract
        // defaultly
        // abstract class are contain constructors but interfaces arte not contain
        // constructors
        // abstract class are partially abstract but interfaces are used to achieve full
        // abstraction and multople inheritance

        // 4.
        // Yes, abstract class contains constructors
        Program p1 = new Program();
        p1.run();

        // 5.
        C c1 = new C();
        c1.Aa();
        c1.Bb();
    }
}
