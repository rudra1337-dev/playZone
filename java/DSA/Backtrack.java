
class Backtrack {

  public static void printArr(int[] arr) {
    System.out.print("Arr : ");
    for (int num : arr)
      System.out.print(num + ",");
  }

  public static void changeArr(int[] arr, int idx, int val) {
    // 1 base case
    if (idx == arr.length) {
      printArr(arr);
      return;
    }

    // 2 work
    arr[idx] = val;
    changeArr(arr, idx + 1, val + 1);
    // dexrease to -2
    arr[idx] = val - 2;
  }

  public static void findSubset(String str, int i, StringBuilder res) {
    // base case
    if (i == str.length()) {
      if (res.length() == 0) {
        System.out.println("NULL");
      } else {
        System.out.println(res.toString() + ",");
      }
      return;
    }

    // work or recursion
    // yes include
    res.append(str.charAt(i));
    findSubset(str, i + 1, res);

    // no exclude
    res.deleteCharAt(res.length() - 1);
    findSubset(str, i + 1, res);
  }

  public static void permutation(String str, StringBuilder res) {
    // base case
    if (str.length() == 0) {
      System.out.println(res.toString());
      return;
    }

    // recursion
    for (int i = 0; i <= str.length() - 1; i++) {
      res.append(str.charAt(i));

      // remove the ith char
      String ns = str.substring(0, i) + str.substring(i + 1);

      // recursion call
      permutation(ns, res);
      res.deleteCharAt(res.length() - 1);
    }
  }

  public static void main(String args[]) {
    System.out.println("WELCOME TO BACKTRACKING");

    int[] arr = new int[5];
    changeArr(arr, 0, 1);
    printArr(arr);

    StringBuilder sb = new StringBuilder();
    findSubset("abc", 0, sb);

    StringBuilder res = new StringBuilder();
    permutation("abc", res);

  }
}