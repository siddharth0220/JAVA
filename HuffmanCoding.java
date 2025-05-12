import java.util.PriorityQueue;

public class HuffmanCoding {
    class HuffmanNode implements Comparable<HuffmanNode> {

        char code;
        int freq;
        HuffmanNode left, right;

        @Override
        public int compareTo(HuffmanNode g) {
            return freq - g.freq;
        }
    }

    void printTree(HuffmanNode root, String s) {
        if (root.left == null && root.right == null) {
            System.out.println(root.code + ":" + s);
            return;
        }
        printTree(root.left, s + "0");
        printTree(root.right, s + "1");
    }

    public void HuffmanTree(char[] sym, int[] freq) {
        PriorityQueue<HuffmanNode> pq = new PriorityQueue<>();

        for (int i = 0; i < sym.length; i++) {
            HuffmanNode node = new HuffmanNode();
            node.code = sym[i];
            node.freq = freq[i];
            node.right = node.left = null;
            pq.add(node);
        }

        HuffmanNode root = null;
        while (pq.size() > 1) {
            HuffmanNode x = pq.peek();
            pq.poll();

            HuffmanNode y = pq.peek();
            pq.poll();

            HuffmanNode f = new HuffmanNode();
            f.freq = x.freq + y.freq;
            f.code = '-';

            f.left = x;
            f.right = y;

            root = f;
            pq.add(f);
        }
        printTree(root, "");
    }

    public static void main(String[] args) {
        char[] charArray = { 'a', 'b', 'c', 'd', 'e', 'f' };
        int[] charFreq = { 15, 9, 112, 53, 96, 45 };
        HuffmanCoding hc = new HuffmanCoding();
        hc.HuffmanTree(charArray, charFreq);
    }
}