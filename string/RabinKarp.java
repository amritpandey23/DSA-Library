public class RabinKarp {
    public static void main(String[] args) {
        String s = "Amritisagoodboy";
        String pat = "isa";
        RBSearch(s, pat);
    }

    public static void RBSearch(String s, String pat) {
        int n, m, pow, h, ph, q, d;
        n = s.length();
        m = pat.length();
        q = 101;
        d = 256;
        pow = 1;
        for (int i = 0; i < m - 1; i++) {
            pow = (pow * d) % q;
        }
        h = ph = 0;
        for (int i = 0; i < m; i++) {
            h = (h * d + s.charAt(i)) % q;
            ph = (ph * d + pat.charAt(i)) % q;
        }
        // System.out.println("h = " + h + " ph = " + ph);
        for (int i = 0; i <= s.length() - m; i++) {
            // System.out.println(h);
            // System.out.println(s.substring(i, i + m));
            if (h == ph) {
                int j = 0;
                while (j < m && s.charAt(i + j) == pat.charAt(j)) {
                    j++;
                }
                if (j == m) {
                    System.out.println(i);
                }
            }
            if (i < n - m) {
                h = ((h - s.charAt(i) * pow) * d + s.charAt(i + m) % q) % q;
            }
            if (h < 0) {
                h += q;
            }
        }
    }
}
