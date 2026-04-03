
import java.io.*;
import java.util.*;

public class CF_2197_A {
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

        int ans = 0;

        int x = fs.nextInt();

        for (int i = 1; i <= 90; i++) {
            int y = x + i;

            if (d(y) == i)
                ans++;
        }

        out.println(ans);

        // ✍️ WRITE YOUR LOGIC HERE
        // ✍️ WRITE YOUR LOGIC HERE
    }

    private static int d(int y) {
        int sum = 0;

        while (y != 0) {
            sum += y % 10;
            y /= 10;
        }

        return sum;
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
