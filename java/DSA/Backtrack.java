import javax.swing.text.StyledEditorKit.BoldAction;

class Backtrack {

  // ---------- Array Backtracking ----------
  public static void printArr(int[] arr) {
    System.out.print("Arr : ");
    for (int num : arr)
      System.out.print(num + ",");
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
      if (sb.length() == 0)
        System.out.println("NULL");
      else
        System.out.println(sb.toString() + ",");
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
      if (board[row - i][col] == 'Q')
        return false;
    }

    // top-left
    for (int i = 1, j = 1; i <= row && j <= col; i++, j++) {
      if (board[row - i][col - j] == 'Q')
        return false;
    }

    // top-right
    for (int i = 1, j = 1; i <= row && j <= board.length - 1 - col; i++, j++) {
      if (board[row - i][col + j] == 'Q')
        return false;
    }

    return true;
  }

  // ---------------N-Queen count ways-------------
  public static int count = 0;

  public static void nQueensCount(char[][] board, int row) {
    // base case
    if (row == board.length) {
      count++;
      return;
    }

    // recursion
    for (int j = 0; j <= board.length - 1; j++) {
      if (isSafe1(board, row, j)) {
        // add Q
        board[row][j] = 'Q';
        // recursion call
        nQueensCount(board, row + 1);
        // remove Q for next itteration
        board[row][j] = 'X';
      }

    }
  }

  public static boolean isSafe1(char[][] board, int row, int col) {
    // top
    for (int i = 1; i <= row; i++) {
      if (board[row - i][col] == 'Q') {
        return false;
      }
    }

    // top left
    for (int i = 1, j = 1; i <= row && j <= col; i++, j++) {
      if (board[row - i][col - j] == 'Q') {
        return false;
      }
    }

    // top right
    for (int i = 1, j = 1; i <= row && j <= board.length - 1 - col; i++, j++) {
      if (board[row - i][col + j] == 'Q') {
        return false;
      }
    }

    return true;
  }

  // ----------N-Queen one solution------
  public static boolean nQueenOneSol(char[][] board, int row) {
    // base case
    if (row == board.length) {
      print2d(board);
      return true;
    }
    // recursion
    for (int j = 0; j <= board.length - 1; j++) {
      if (isSafe2(board, row, j)) {
        // add Q
        board[row][j] = 'Q';
        // recursion call
        // stoping recursion after oncce get the solution
        if (nQueenOneSol(board, row + 1)) {
          return true;
        }
        // removing Q for next itterTION
        board[row][j] = 'X';
      }
    }

    return false;
  }

  public static boolean isSafe2(char[][] board, int row, int col) {

    // top
    for (int i = 1; i <= row; i++) {
      if (board[row - i][col] == 'Q') {
        return false;
      }
    }

    // toop left
    for (int i = 1, j = 1; i <= row && j <= col; i++, j++) {
      if (board[row - i][col - j] == 'Q') {
        return false;
      }
    }

    // top right
    for (int i = 1, j = 1; i <= row && j <= board.length - 1 - col; i++, j++) {
      if (board[row - i][col + j] == 'Q') {
        return false;
      }
    }
    return true;
  }

  // ------------Grid ways---------------

  public static int gridWays(int[][] arr, int i, int j) {
    // base case
    // we have one choice if i am on the target mand n then ways = 1
    if (i == arr.length - 1 && j == arr[0].length - 1) {
      return 1;
    } else if (i == arr.length || j == arr[0].length) {
      return 0;
    }

    int botom = gridWays(arr, i + 1, j);
    int right = gridWays(arr, i, j + 1);

    int totalWays = botom + right;
    return totalWays;

  }

  public static int factorial(int n) {
    if (n == 1 || n == 0) {
      return 1;
    }

    return n * factorial(n - 1);
  }

  public static int gridWays2(int[][] arr) {
    int nomi = factorial(arr.length - 1 + arr[0].length - 1);
    int denomi = factorial(arr.length - 1) * factorial(arr[0].length - 1);
    return nomi / denomi;
  }

  // ------------------Sudoku solver-----------------------------
  public static boolean sudokuSolver(int[][] arr, int row, int col) {
    // base case
    if (row == arr.length)
      return true;

    // if col == 9 then move to next row
    if (col == arr.length) {
      return sudokuSolver(arr, row + 1, 0);
    }

    // digit already given
    // move to next iteration
    if (arr[row][col] != 0)
      return sudokuSolver(arr, row, col + 1);

    // recursion
    for (int i = 1; i <= 9; i++) {
      if (isSafe4(arr, i, row, col)) {
        // update the current digit as it safe
        arr[row][col] = i;

        // check is the next safe or not
        if (sudokuSolver(arr, row, col + 1)) {
          return true;
        }

        // if the next try is not safe then backtrack and try the next iteration
        arr[row][col] = 0;
      }

    }

    // no digit safe
    return false;
  }

  public static boolean isSafe4(int[][] arr, int dig, int row, int col) {

    // row case
    // //row left
    // for (int i = 0; i <= col; i++) {
    // if (arr[row][i] == dig) {
    // return false;
    // }
    // }

    // //row right
    // for (int i = col; i <= arr.length - 1; i++) {
    // if (arr[row][i] == dig) {
    // return false;
    // }
    // }

    for (int i = 0; i <= arr.length - 1; i++) {
      if (arr[row][i] == dig) {
        return false;
      }
    }

    // col case
    // //col top
    // for (int i = 0; i <= row; i++) {
    // if (arr[i][col] == dig) {
    // return false;
    // }
    // }

    // //col bottom
    // for (int i = row; i <= arr[0].length - 1; i++) {
    // if (arr[i][col] == dig) {
    // return false;
    // }
    // }

    for (int i = 0; i <= arr[0].length - 1; i++) {
      if (arr[i][col] == dig) {
        return false;
      }
    }

    // grid case
    int r = (row / 3) * 3;
    int c = (col / 3) * 3;
    for (int i = r; i <= r + 2; i++) {
      for (int j = c; j <= c + 2; j++) {
        if (arr[i][j] == dig) {
          return false;
        }
      }
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

    // nQueens(board, 0);

    nQueensCount(board, 0);
    System.out.println("Total way to solve n queens of n=" + n + " is " + count);

    System.out.println(nQueenOneSol(board, 0));

    int n1 = 3, m = 3;
    int[][] arr1 = new int[n1][m];
    System.out.println(gridWays(arr1, 0, 0));
    System.out.println(gridWays2(arr1));

    int sudoku[][] = { { 0, 0, 8, 0, 0, 0, 0, 0, 0 },
        { 4, 9, 0, 1, 5, 7, 0, 0, 2 },
        { 0, 0, 3, 0, 0, 4, 1, 9, 0 },
        { 1, 8, 5, 0, 6, 0, 0, 2, 0 },
        { 0, 0, 0, 0, 2, 0, 0, 6, 0 },
        { 9, 6, 0, 4, 0, 5, 3, 0, 0 },
        { 0, 3, 0, 0, 7, 2, 0, 0, 4 },
        { 0, 4, 9, 0, 3, 0, 0, 5, 7 },
        { 8, 2, 7, 0, 0, 9, 0, 1, 3 } };

    if (sudokuSolver(sudoku, 0, 0)) {
      System.out.println("Solution available");
      for (int i = 0; i <= sudoku.length - 1; i++) {
        for (int j = 0; j <= sudoku.length - 1; j++) {
          System.out.print(sudoku[i][j] + " ");
        }
        System.out.println();
      }
    } else {
      System.out.println("Solution is not available");
    }

  }
}