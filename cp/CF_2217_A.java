
import java.io.*;
import java.util.*;

public class CF_2217_A {
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
        int k = fs.nextInt();
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += fs.nextInt();
        }

        int myTurn = n * k;

        if (sum % 2 != 0) {
            System.out.println("YES");
            return;
        }

        if (sum % 2 == 0 && myTurn % 2 == 0) {
            System.out.println("YES");
            return;
        } else {
            System.out.println("NO");
            return;
        }

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
