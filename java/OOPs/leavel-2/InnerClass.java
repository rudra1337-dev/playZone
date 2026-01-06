// class Outer {
//     String name = "Rudra";

//     class Inner {
//         void print() {

//             System.out.println("Name - " + name);
//         }
//     }

// }

// class Outer {
//     String name = "Rudra";

//     static class Inner {
//         void print() {

//             System.out.println("Name - " + name);
//         }
//     }

// }

interface A {
    void print();
}

public class InnerClass {
    public static void main(String[] args) {
        System.out.println("Welcome to Inner class classes...");

        // 1.
        // Outer obj = new Outer();
        // Outer.Inner obj1 = obj.new Inner();
        // obj1.print();

        // 2.
        // Outer.Inner obj1 = new Outer.Inner();
        // obj1.print();

        // InnerClass.java:19: error: non-static variable name cannot be referenced from
        // a static context
        // System.out.println("Name - " + name);
        // ^
        // 1 error

        A obj = new A() {
            public void print() {
                System.out.println("Hello from interface");
            }
        };

        obj.print();


        //4.
        // Inner classes are classes that are defined inside another class, method , we cant create obj of the inner classes without using the outer calsses
        // Normal classes are independend classes , we can create obj when we want

    }
}