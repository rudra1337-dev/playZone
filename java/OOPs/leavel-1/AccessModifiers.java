class Employee {
    private int salary = 30000;

    public int getSalary() {
        System.out.println("Salary = " + salary);
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}

// 2.
class A {
    int a = 70;
}

class B {
    protected int b = 20;
}

class C extends B {
    int c = super.b;
}

class D {
    public void d() {
        System.out.println("Hello");
    }
}

class E extends D {
    E() {
        super.d();
    }
}

public class AccessModifiers {
    public static void main(String[] args) {
        System.out.println("Welcome to AccessModifiers");

        // 1.
        Employee e = new Employee();
        // int s = e.salary;

        /*
         * AccessModifiers.java:20: error: salary has private access in Employee
         * int s = e.salary;
         * ^
         * 1 error
         */

        // 2.
        A a = new A();
        int l = a.a;

        // 3.
        C c = new C();
        int z = c.c;

        // 4.
        E f = new E();

        // 5.
        /*
         * private - it only acassiablee inside the same class
         * protected - it accassible everywhere except outside the package
         */
    }
}