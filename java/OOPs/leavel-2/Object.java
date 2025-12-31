class Student {
    String name;
    int roll;

    Student(String name, int roll) {
        this.name = name;
        this.roll = roll;
    }

    public String toString() {
        System.out.println(this.name + "," + this.roll);
        return this.name + "," + this.roll;
    }

    // @Override
    // public boolean equals(Object s) {
    // return this.roll == s.roll;
    // }

    // @Override
    // public int hashCode() {
    // return Integer.hashCode(roll);
    // }

}

public class Object {
    public static void main(String[] args) {
        System.out.println("Welcome to Object");

        // 1.
        Student s = new Student("Rudra", 50);
        s.toString();

        // 2.
        Student s1 = new Student("Akash", 58);
        Student s2 = new Student("Anil", 58);

        System.out.println(s1.equals(s2));

        // 3.
        Student s3 = s1;
        System.out.println(s1.hashCode());
        System.out.println(s3.hashCode());

        // 4.
        /*
         * It is because when their are two objects are equal their hashcode also equal
         */
    }
}