import java.io.*;
import java.util.*;

public class CF_2199_A {
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

        int noWA = 0, noWB = 0;
        int tsA = 0, tsB = 0;
        int k = fs.nextInt();

        for (int i = 0; i < 2; i++) {
            int a = fs.nextInt();
            int b = fs.nextInt();

            noWA = a > b ? 1 : 0;
            noWB = a < b ? 1 : 0;

            tsA += a;
            tsB += b;
        }

        int minSA = tsA + 0;
        int maxSB = tsB + k;

        if (maxSB > minSA) {
            out.println("YES");
        } else if (maxSB < minSA) {
            out.println("NO");
        } else {
            if (noWA < noWB) {
                out.println("YES");
            } else {
                out.println("NO");
            }
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
