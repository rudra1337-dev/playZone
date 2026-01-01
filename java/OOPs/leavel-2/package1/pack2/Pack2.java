
// package package1.pack2;

// import package1.pack1.Pack1;

// public class Pack2 {
//     public static void main(String[] args) {
//         System.out.println("Welcome to Pack 2");

//         Pack1 p1 = new Pack1();
//         String name = p1.name;
//         int roll = p1.roll;
//         int amount = p1.amount;
//     }
// }

package package1.pack2;

import package1.pack1.Pack1;

public class Pack2 {
    public static void main(String[] args) {

        Pack1 p1 = new Pack1();

        System.out.println(p1.name); // ✅ public
        // System.out.println(p1.roll); // ❌ private
        // System.out.println(p1.amount); // ❌ protected
    }
}
