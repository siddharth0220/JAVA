
import java.util.Arrays;

class Item implements Comparable<Item> {
    int w, p;
    float up;

    Item(int w, int p) {
        this.w = p;
        this.p = p;
        up = (float) p / w;
    }

    @Override
    public int compareTo(Item o) {
        if (up == o.up) {
            return 0;
        } else if (up > o.up) {
            return -1;
        }
        return 1;
    }
}

public class fractionalKnapsack {

    static void OptimalFractionalKnapsack(int W, int[] weights, int[] prices) {
        Item[] Items = new Item[weights.length];
        for (int i = 0; i < weights.length; i++) {
            Items[i] = new Item(weights[i], prices[i]);
        }

        Arrays.sort(Items);
        float totalProfit = 0;
        for (int i = 0; i < Items.length; i++) {
            if (W <= 0) {
                break;
            }

            if (W >= Items[i].w) {
                totalProfit += Items[i].p;
                System.out.println(
                        "Selected item with weight:" + Items[i].w + ",and price:" + Items[i].p);
                W = W - Items[i].w;
            } else {
                float p = (Items[i].up * W);
                totalProfit += p;
                System.out.println("(Fractional)Selected item with weight:" + W + ",and price:" + p);
                W = 0;
            }
        }
        System.out.println("Total profit:" + totalProfit);
    }

    public static void main(String[] args) {
        int[] w = { 2, 4, 3, 6, 6 };
        int[] p = { 32, 28, 15, 28, 24 };
        OptimalFractionalKnapsack(11, w, p);
    }
}
