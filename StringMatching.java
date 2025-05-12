public class StringMatching {
    public static void stringMatching(String text, String pattern) {
        int n = text.length(), m = pattern.length();
        for (int i = 0; i <= n - m; i++) {
            for (int j = 0; j < m; j++) {
                if (text.charAt(i + j) != pattern.charAt(j))
                    break;
                if (j == m - 1)
                    System.out.println("Pattern found at index " + i);
            }
        }
    }

    public static void main(String[] args) {
        String text = "aabcaabcacb";
        String pattern = "abc";
        stringMatching(text, pattern);
    }
}
