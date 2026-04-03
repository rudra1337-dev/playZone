
import java.io.*;
import java.util.*;

public class CF_231_A {
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
        int res = 0;

        for (int i = 0; i < n; i++) {
            int a = fs.nextInt();
            int b = fs.nextInt();
            int c = fs.nextInt();

            if ((a + b + c) >= 2)
                res++;
        }

        // out.print(res);
        System.out.println(res);

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
