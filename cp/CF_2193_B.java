
import java.io.*;
import java.util.*;

public class CF_2193_B {
    static FastScanner fs = new FastScanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = fs.nextInt();
        while (t-- > 0) {
            solution();
        }
        out.close();
    }

    static void solution() {
        // ✍️ WRITE YOUR LOGIC HERE
        // ✍️ WRITE YOUR LOGIC HERE

        int n = fs.nextInt();

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = fs.nextInt();
        }

        int i = 0;
        int j = n;

        for (i = 0; i < n; i++) {
            if (nums[i] != j)
                break;
            j--;
        }

        if (j > 0) {
            int k = i;

            while (i < n) {
                if (nums[i] == j)
                    break;
                i++;
            }

            n = i - k + 1;
            j = 0;
            // Reversing
            // while (k + 1 == i || k == i) {
            while (j < n / 2) {
                int temp = nums[i];
                nums[i] = nums[k];
                nums[k] = temp;
                i--;
                k++;
                j++;
            }

        }

        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();

        // ✍️ WRITE YOUR LOGIC HERE
        // ✍️ WRITE YOUR LOGIC HERE
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream is) {
            br = new BufferedReader(new InputStreamReader(is));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
