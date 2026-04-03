
import java.io.*;
import java.util.*;

public class CF_2191_A {
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
        // ✍️ WRITE YOUR LOGIC HERE
        // ✍️ WRITE YOUR LOGIC HERE

        int n = fs.nextInt();
        int[] pos = new int[n + 1];

        for (int i = 0; i < n; i++) {
            int x = fs.nextInt();
            pos[x] = i;
        }

        for (int i = 1; i < n; i++) {
            if ((pos[i] % 2) == (pos[i + 1] % 2)) {
                out.println("NO");
                return;
            }
        }

        out.println("YES");

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
