class A {
    final void print() {
        System.out.println("Hello");
    }
}

class B extends A {
    // void print() {
    // System.out.println("Hii");
    // }
}

// 3.
final class C {
    int c = 0;
}

// class D extends C {

// }

// 4.
class S {
    final int a;

    S(int a) {
        this.a = a;
        System.out.println(a);
    }
}

public class Final {

    final static float PI = 3.141f;

    public static void main(String args[]) {
        System.out.println("Welcome to final");

        // 1.
        System.out.println("PI = " + PI);

        // 2.
        /*
         * Final.java:8: error: print() in B cannot override print() in A
         * void print() {
         * ^
         * overridden method is final
         * 1 error
         */

        // 3.
        /*
         * Final.java:18: error: cannot inherit from final C
         * class D extends C {
         * ^
         * 1 error
         */

        // 4.
        S s = new S(34);

        // 5.
        /*
         * final - keyword usesd to make constants security etc
         * finally() ist is a block used in excecption handeling
         * finalize() it is a method called before obj is garbeg collect, clled be GC
         * and depricated by java +
         */
    }
}