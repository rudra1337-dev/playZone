class Animal{
    void sound(){
        System.out.println("Suuuu...");
    }
}

class Dog extends Animal{
    void sound(){
        System.out.println("Worf ...");
    }
} 

class Cat extends Animal{
    void sound(){
        System.out.println("Meaon...");
    }
}





class A{
    A(){
        System.out.println("A condtructer...");
    }
}

class B extends A{
    B(){
        System.out.println("B condtructer...");
    }
}

class C extends B{
    C(){
        System.out.println("C condtructer...");
    }
}




class Person{
    String name;
    int age;
}

class Student extends Person{
    int rollno;
    
    void printDetails(){
        System.out.println(super.name);
        System.out.println(super.age);
        System.out.println(this.rollno);
    }
}




class Shape{
    void area(int width, int length){
        System.out.println("Area = "+(width*length));
    }
}

class Circle extends Shape{
    void area(int radius){
        System.out.println("Area of the circle = "+(3.141*radius));
    }
}

class Rectangle extends Shape{
    void area(int w, int l){
        System.out.println("Area of the rectangle = "+(w*l));
    }
}


class Student1{
    
    String name = "Rudra";
    void greet(){
        System.out.println("Hii");
    }
    Student1(){
        System.out.println("Parent constructor");
    }
    
    Student1(int a){
        System.out.println("Parent constructor "+a);
    }
}

class Student2 extends Student1{
    Student2(){
        super(1);
    }
    void printName(){
        super.greet();
        System.out.println(super.name);
    }
}
public class Try {
    public static void main(String[] args) {
        
        Student2 s = new Student2();
        s.printName();
        /*
        //Q1.
        Animal a = new Animal();
        a.sound();
        
        Dog d1 = new Dog();
        d1.sound();
        
        Cat c1 = new Cat();
        c1.sound();
       */
        
        
        
        /*
        //Q2.
        C c1 = new C();
        */
        
        /*
        //Q3.
        Student s1 = new Student();
        s1.name = "Rudra";
        s1.age = 19;
        s1.rollno = 50;
        s1.printDetails();
        */
        
        /*
        //Q4.
        Shape s = new Shape();
        s.area(4,4);
        
        Circle c1 = new Circle();
        c1.area(4);
        
        Rectangle r1 = new Rectangle();
        r1.area(4,4);
        */
        
   }
    
}