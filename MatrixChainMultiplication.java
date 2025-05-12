public class MatrixChainMultiplication {

    public static void matrixChainOrder(int[] p) {
        int n = p.length - 1;
        int[][] m = new int[n][n];
        int[][] s = new int[n][n];

        for (int i = 0; i < n; i++)
            m[i][i] = 0;

        for (int L = 2; L <= n; L++) {
            for (int i = 0; i < n - L + 1; i++) {
                int j = i + L - 1;
                m[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int q = m[i][k] + m[k + 1][j] + p[i] * p[k + 1] * p[j + 1];
                    if (q < m[i][j]) {
                        m[i][j] = q;
                        s[i][j] = k;
                    }
                }
            }
        }

        System.out.println("Minimum number of multiplications is " + m[0][n - 1]);
    }

    public static void main(String[] args) {
        int[] p = { 1, 2, 3, 4 };
        matrixChainOrder(p);
    }
}
