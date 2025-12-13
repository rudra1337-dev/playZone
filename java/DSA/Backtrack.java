class Backtrack {

  // ---------- Array Backtracking ----------
  public static void printArr(int[] arr) {
    System.out.print("Arr : ");
    for (int num : arr) System.out.print(num + ",");
    System.out.println();
  }

  public static void changeArr(int[] arr, int idx, int val) {
    if (idx == arr.length) {
      printArr(arr);
      return;
    }

    arr[idx] = val;
    changeArr(arr, idx + 1, val + 1);
    arr[idx] = val - 2; // backtrack
  }

  // ---------- Subsets ----------
  public static void findSubset(String str, int i, StringBuilder sb) {
    if (i == str.length()) {
      if (sb.length() == 0) System.out.println("NULL");
      else System.out.println(sb.toString() + ",");
      return;
    }

    sb.append(str.charAt(i));
    findSubset(str, i + 1, sb);

    sb.deleteCharAt(sb.length() - 1);
    findSubset(str, i + 1, sb);
  }

  // ---------- Permutations ----------
  public static void permutation(String str, StringBuilder res) {
    if (str.length() == 0) {
      System.out.println(res.toString());
      return;
    }

    for (int i = 0; i < str.length(); i++) {
      res.append(str.charAt(i));
      String ns = str.substring(0, i) + str.substring(i + 1);
      permutation(ns, res);
      res.deleteCharAt(res.length() - 1);
    }
  }

  // ---------- N Queens ----------
  public static void print2d(char[][] board) {
    System.out.println("---------------");
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board.length; j++) {
        System.out.print(board[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static void nQueens(char[][] board, int row) {
    if (row == board.length) {
      print2d(board);
      return;
    }

    for (int j = 0; j < board.length; j++) {
      if (isSafe(board, row, j)) {
        board[row][j] = 'Q';
        nQueens(board, row + 1);
        board[row][j] = 'X'; // backtrack
      }
    }
  }

  public static boolean isSafe(char[][] board, int row, int col) {

    // top
    for (int i = 1; i <= row; i++) {
      if (board[row - i][col] == 'Q') return false;
    }

    // top-left
    for (int i = 1, j = 1; i <= row && j <= col; i++, j++) {
      if (board[row - i][col - j] == 'Q') return false;
    }

    // top-right
    for (int i = 1, j = 1; i <= row && j <= board.length - 1 - col; i++, j++) {
      if (board[row - i][col + j] == 'Q') return false;
    }

    return true;
  }

  // ---------- MAIN ----------
  public static void main(String[] args) {

    System.out.println("WELCOME TO BACKTRACKING");

    int[] arr = new int[5];
    changeArr(arr, 0, 1);

    StringBuilder sb = new StringBuilder();
    findSubset("abc", 0, sb);

    StringBuilder res = new StringBuilder();
    permutation("abc", res);

    int n = 10;
    char[][] board = new char[n][n];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        board[i][j] = 'X';
      }
    }

    nQueens(board, 0);
  }
}